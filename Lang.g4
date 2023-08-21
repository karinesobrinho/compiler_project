grammar Lang;

@header{
	import br.edu.ufabc.isilanguage.datastructure.IsiSymbol;
	import br.edu.ufabc.isilanguage.datastructure.IsiVariable;
	import.br.edu.ufabc.isilanguage.datastructure.IsiSymbolTable;
	import.edu.ufabc.isilanguage.exception.IsiSemanticException;
	import java.util.ArrayList;
	import java.util.HashMap;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private symbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
	private IsiProgram program = new IsiProgram();
	private ArrayList<AbstractCommand> curThread;
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _expreDecision;
	private String _expreRepetition;
	privavte ArrayList<String> variavelSemUso;
	private ArrayList<AbstractCommand> listTrue;
	private ArrayList<AbstractCommand> listFalse; 

}

public void verificaID(String id){
	if(!symbolTable.exists(id)){
		throw new IsiSemanticException("Symbol " +id+ " not declared");
	}
}

public void exibeComandos(){
	for(AbstractCommand c: program.getComandos()){
		System.out.println(c);
	}
}

public StringBuilder exibeVariavelSemUso(){
	StringBuilder varWarning = program.getVarSemUso();
	ArrayList<String> var = program.getVarSemUso();
	varWarning.append("Variables declared but not used: ");
	if(var.isEmpty()) return null;

	int size = var.size();
	if(size == 1){
		varWarning.append(var.get(0));
	}
	else{
		for(int i = 0; i < size-2; i++){
			String v = var.get(i);
			varWarning.append(v);
			varWarning.append(", ");
		}
		varWarning.append(var.get(size-1));
		}
	return varWarning;
}

public void Warning(){
	StringBuilder warning = new StringBuilder();
	StringBuilder var = exibeVariavelSemUso();
	if(var != null) return;
	warning.append(exibeVariavelSemUso());
	System.out.println(warning);
	
}

prog	: 'programa'  decl bloco  'fimprog;' 
		  {
			program.setVarTable(symbolTable);
			program.setComandos(stack.pop());
		  }
		;

decl	: (declaravar)+
		;

declaravar	:	tipo ID {
			  			_varName = _input.LT(-1).getText();
			  			_varValue = null;
			  			symbol = new IsiVariable(_varName, _tipo, _varValue);
						System.out.println("Simbolo adicionado " +symbol);
						if (!symbolTable.exists(_varName)){
			  				symbolTable.add(symbol);
						}
						else{
							throw new IsiSemanticException("Symbol" +_varName+" already declared");
						}
						}
				(	VIR 
					ID	{
						_varName = _LT(-1).getText();
			  			_varValue = null;
			  			symbol = new IsiVariable(_varName, _tipo, _varValue);
						if (!symbolTable.exists(_varName)){
			  				symbolTable.add(symbol);
						}
						else{
							throw new IsiSemanticException("Symbol" +_varName+" already declared");
						}
					}
				)* 
				 SC
			;

bloco	: {curThread = new ArrayList<AbstractCommand>();
				stack.push(curThread);
		  } 
		(cmd)+
		;

tipo	: 'numero' { _tipo = IsiVariable.Number; }
		| 'texto'  { _tipo = IsiVariable.TEXT; }
		;

bloco	: {curThread = new ArrayList<AbstractCommand>();
				stack.push(curThread);
		  } 
		(cmd)+
		;

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
		|  cmdselecao
		|  cmdenquanto
		;

cmdleitura	: 'read' AP
                     ID { verificaID(_input.LT(-1).getText());
					 	  _readID = _input.LT(-1).getText();
					 }
                     FP 
                     SC

					 {
						IsiVariable var = (IsiVariable)symbolTable.get(_readID);
						CommandLeitura cmd = new CommandLeitura(_readID, var);
						stack.peek().add(cmd);
					 }
			;

cmdescrita	: 'write' 
			AP 
			ID { verificaID(_input.LT(-1).getText());
				 _writeID = _input.LT(-1).getText();
			}
			FP 
			SC
			{
				CommandEscrita cmd = new CommandEscrita(_writeID);
				stack.peek().add(cmd);
			}
			;

cmdattrib	:  ID { verificaID(_input.LT(-1).getText());
					_exprID = _input.LT(-1).getText();
			   }
			   ATTR 
			   expr 
			   SC
			   {
					if(_exprContent == "")
					{
						throw new IsiSemanticException("Variavel " +_exprID+ " não foi atribuida");
					}
					else{
						COmmandAtribuicao cmd = new COmmandAtribuicao(_expreID, _exprContent);
						stack.peek().add(cmd);
					}
			   }
			;

cmdenquanto	: 'enquanto'
				AP
				ID {_expreRepetition = _input.LT(-1).getText(); }
				OPREL {_expreRepetition += _input.TL(-1).getText(); }
				(ID | NUMBER) {_expreRepetition += _input.LT(-1).getText(); }
				FP
				ACH {curThread = new ArrayList<AbstractCommand>();
					 stack.push(curThread);
					}
					(cmd)+
				FCH { listTrue = stack.pop();
					  CommandRepeticao cmd = new CommandRepeticao(_expreRepetition, listTrue);
					  stack.peek().add(cmd);
					}
			;

cmdselecao	:	'se'
				AP
				ID	{_expreDecision = _input.LT(-1).getText(); }
				OPREL {_expreDecision += _input.LT(-1).getText(); }
				(ID | NUMBER) {_expreDecision += _input.LT(-1).getText(); }
				FP
				ACH {curThread = new ArrayList<AbstractCommand>();
					 stack.push(curThread);
					}
					(cmd)+
				FCH { listaTrue = stack.pop();
					}
				('senao' 
					ACH {
						curThread = new ArrayList<AbstractCommand>();
					 	stack.push(curThread);
					}
					(cmd)+
					FCH { listFalse = stack.pop();
						  CommandDecisao cmd = new CommandDecisao(_expreDecision, listTrue, listFalse);
						  stack.peek().add(cmd);
						}
				)?	
			;

expr		:  term ( 
						OP {_exprContent += _input.LT(-1).getText();}
						term )*
			;

term		: ID {verificaID(_input.LT(-1).getText());
				  _exprContent += _input.LT(-1).getText();
			  }
			  | 
			  (NUMBER | TEXTO) {_exprContent += _input.LT(-1).getText();
			  }
			;


AP	: '('
	;

FP	: ')'
	;

SC	: ';'
	;

OP	: '+' | '-' | '*' | '/'
	;

ATTR : '='
	 ;

VIR : ','
	;

ACH	: '{'
	;

FCH	: '}'
	;

OPREL	: '==' | '!=' | '>=' | '<=' | '>' | '<'
	    ;

ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;

NUMBER	: [0-9]+ ('.' [0-9]+)?
		;

TEXTO	: ['"']([a-z] | [A-Z] | [0-9] | ' ')*['"']

WS	: (' ' | '\t' | '\n' | '\r') -> skip;