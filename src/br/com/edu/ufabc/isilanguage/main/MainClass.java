package br.com.edu.ufabc.isilanguage.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.com.edu.ufabc.isilanguage.exceptions.IsiSemanticException;
import br.com.edu.ufabc.isilanguage.parser.langLexer;
import br.com.edu.ufabc.isilanguage.parser.langParser;

public class MainClass {
	public static void main(String[] args) {
		try {
			langLexer lexer;
			langParser parser;

			lexer = new langLexer(CharStreams.fromFileName("src/Resources/teste5.isi"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			parser = new langParser(tokenStream);			
			parser.prog();
			System.out.println("Compilation Successful");
			
			parser.exibeComandos();                      
			parser.generateCode();
            parser.Warning();
		}
		catch(IsiSemanticException ex) {
			System.err.println("Semantic error - "+ex.getMessage());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.err.println("Syntaxe error -"+ex.getMessage());
		}
		
	}

}
