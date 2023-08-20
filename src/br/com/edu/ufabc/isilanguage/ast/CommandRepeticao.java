package br.com.edu.ufabc.isilanguage.ast;

import java.util.ArrayList;

public class CommandRepeticao extends AbstractCommand {
 
	private String repetition;
	private ArrayList<AbstractCommand> listaTrue;
		
	public CommandRepeticao(String repetition, ArrayList<AbstractCommand> lt) {
		this.repetition = repetition;
		this.listaTrue = lt;
		
	}
	@Override
	public String generateJavaCode() {

		StringBuilder str = new StringBuilder();
		str.append("while ("+repetition+") {\n");
		for (AbstractCommand cmd: listaTrue) {
			str.append(cmd.generateJavaCode());
		}
		str.append("}");
	
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
		str.append(identacaoStr+"while ("+repetition+") :\n");
		for (AbstractCommand cmd: listaTrue) {
			str.append(identacaoStr+"\t"+cmd.generatePythonCode(tabs));
		}
		str.append("\n");
	
		return str.toString();
	}
	@Override
	public String toString() {
		return "CommandRepeticao [repetition=" + repetition + ", listaTrue=" + listaTrue + "]";
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
