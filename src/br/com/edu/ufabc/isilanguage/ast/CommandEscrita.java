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
	public String generatePythonCode() {

		return "print("+id+")";
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
