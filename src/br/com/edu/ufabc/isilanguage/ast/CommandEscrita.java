package br.com.edu.ufabc.isilanguage.ast;

public class CommandEscrita extends AbstractCommand {

	private String id;
	
	public CommandEscrita(String id) {
		this.id = id;
	}
	@Override
	public String generateJavaCode() {

		return "System.out.println("+id+");";
	}
	@Override
	public String generatePythonCode(int tabs) {
		
		StringBuilder identacao = new StringBuilder();
		for (int i = 0; i < tabs; i++){
			identacao.append("\t");
		}
		String identacaoStr = identacao.toString();
		return identacaoStr+"print("+id+")\n";
	}
	@Override
	public String toString() {
		return "CommandEscrita [id=" + id + "]";
	}
	@Override
        public String getId()
        {
            return "";
        }@Override
        public String getCommand()
        {
            return this.getClass().getName();
        }
        

}
