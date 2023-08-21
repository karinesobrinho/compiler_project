package br.com.edu.ufabc.isilanguage.ast;

import br.com.edu.ufabc.isilanguage.datastructure.IsiVariable;

public class CommandLeitura extends AbstractCommand {

	private String id;
	private IsiVariable var;
	
	public CommandLeitura (String id, IsiVariable var) {
		this.id = id;
		this.var = var;
	}
	@Override
	public String generatePythonCode(int tabs) {

		StringBuilder identacao = new StringBuilder();
		for (int i = 0; i < tabs; i++){
			identacao.append("\t");
		}
		String identacaoStr = identacao.toString();
		return identacaoStr + id +" = " + (var.getType()==IsiVariable.NUMBER? "float(input())": "input()");
	}
	@Override
	public String generateJavaCode() {

		return id +"= _key." + (var.getType()==IsiVariable.NUMBER? "nextDouble();": "nextLine();");
	}
	@Override
	public String toString() {
		return "CommandLeitura [id=" + id + "]";
	}
        @Override
        public String getId()
        {
            return "";
        }
        @Override
        public String getCommand()
        {
            return this.getClass().getName();
        }

}