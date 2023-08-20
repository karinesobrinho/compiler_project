package br.com.edu.ufabc.isilanguage.main;

import br.com.edu.ufabc.isilanguage.parser.langLexer;
import br.com.edu.ufabc.isilanguage.parser.langParser;

import org.antlr.v4.runtime.*;
public class MainClass {
    public static void main(String[] args){
        try{
            langLexer lexer;
            langParser parser;

            lexer = new langLexer(CharStreams.fromFileName("input.isi"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            parser = new langParser(tokenStream);
            System.out.println("Compilation Successful!");

            parser.exibeComandos();
            parser.generateCode();

        } catch (IsiSemanticException ex) {
            System.err.println("Semantic error - " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("ERROR - " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("ERROR - " + ex.getMessage());
        }
    }
}
