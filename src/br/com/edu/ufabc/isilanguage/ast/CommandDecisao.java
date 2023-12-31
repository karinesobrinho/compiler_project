package br.com.edu.ufabc.isilanguage.ast;

import java.util.ArrayList;

public class CommandDecisao extends AbstractCommand {
 
	private String condition;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	
	public CommandDecisao(String condition, ArrayList<AbstractCommand> lt, ArrayList<AbstractCommand> lf) {
		this.condition = condition;
		this.listaTrue = lt;
		this.listaFalse = lf;
	}
	@Override
	public String generateJavaCode() {

		StringBuilder str = new StringBuilder();
		str.append("if ("+condition+") {\n");
		for (AbstractCommand cmd: listaTrue) {
			str.append(cmd.generateJavaCode());
		}
		str.append("}");
		if (listaFalse.size() > 0) {
			str.append("else {\n");
			for (AbstractCommand cmd: listaFalse) {
				str.append(cmd.generateJavaCode());
			}
			str.append("}\n");
		
		}
		return str.toString();
	}

	@Override
	public String generatePythonCode(int tabs) {

		StringBuilder identacao = new StringBuilder();
		for (int i = 0; i < tabs; i++){
			identacao.append("\t");
		}
		String identacaoStr = identacao.toString();

		StringBuilder str = new StringBuilder();
		str.append(identacaoStr+"if ("+condition+") :\n");
		for (AbstractCommand cmd: listaTrue) {
			str.append(cmd.generatePythonCode(tabs+1));
		}
		str.append("\n");
		if (listaFalse.size() > 0) {
			str.append(identacaoStr+"else :\n");
			for (AbstractCommand cmd: listaFalse) {
				str.append(cmd.generatePythonCode(tabs+1));
			}
			str.append("\n");
		
		}
		return str.toString();
	}


	@Override
	public String toString() {
		return "CommandDecisao [condition=" + condition + ", listaTrue=" + listaTrue + ", listaFalse=" + listaFalse
				+ "]";
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
