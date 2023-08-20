package br.com.edu.ufabc.isilanguage.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.com.edu.ufabc.isilanguage.exceptions.IsiSemanticException;
import br.com.edu.ufabc.isilanguage.parser.langLexer;
import br.com.edu.ufabc.isilanguage.parser.langParser;

public class MainClass {
    public static void main(String[] args){
        try{
            langLexer lexer;
            langParser parser;

            //lexer = new langLexer(CharStreams.fromFileName("src\\Resources\\teste2.isi"));
            lexer = new langLexer(CharStreams.fromFileName("src/Resources/teste1.isi"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            parser = new langParser(tokenStream);
            parser.prog();
            System.out.println("Compilação bem sucedida");

            parser.exibeComandos();
            parser.generateCode();
            /*parser.Warnings();*/

        } catch (IsiSemanticException ex) {
            System.err.println("Erro semântico- " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Erro - " + ex.getMessage());
        }
    }
}
