package br.com.edu.ufabc.isilanguage.ast;

public class CommandAtribuicao extends AbstractCommand{

	private String id;
	private String expr;
	
        
        public String getId()
        {
            return this.id;
        }
        
	public CommandAtribuicao(String id, String expr) {
		this.id = id;
		this.expr = expr;
	}
	@Override
	public String generateJavaCode() {
		return id + " = "+expr+";";
	}
	@Override
	public String generatePythonCode(int tabs) {
		StringBuilder identacao = new StringBuilder();;
		for (int i = 0; i < tabs; i++){
			identacao.append("\t");
		}
		String identacaoStr = identacao.toString();
		return identacaoStr + id + " = "+expr+"\n";
	}
	@Override
	public String toString() {
		return "CommandAtribuicao [id=" + id + ", expr=" + expr + "]";
	}
        @Override
        public String getCommand()
        {
            String command = this.getClass().getSimpleName();
            return command;
        }
	
	

}
