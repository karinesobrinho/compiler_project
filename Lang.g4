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
}

prog	: 'programa'  decl bloco  'fimprog;' 
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
				ID	{_ex}


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

ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;

NUMBER	: [0-9]+ ('.' [0-9]+)?
		;

TEXTO	: ['"']([a-z] | [A-Z] | [0-9] | ' ')*['"']

WS	: (' ' | '\t' | '\n' | '\r') -> skip;