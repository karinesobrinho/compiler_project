package br.com.edu.ufabc.isilanguage.ast;

public abstract class AbstractCommand {

	
	public abstract String generateJavaCode();
        public abstract String generatePythonCode(int tabs);
        public abstract String getId();
        public abstract String getCommand();
        
}