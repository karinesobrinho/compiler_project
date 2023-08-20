// Generated from lang.g4 by ANTLR 4.7.1
package br.com.edu.ufabc.isilanguage.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import br.com.edu.ufabc.isilanguage.datastructure.IsiSymbol;
import br.com.edu.ufabc.isilanguage.datastructure.IsiVariable;
import br.com.edu.ufabc.isilanguage.datastructure.IsiSymbolTable;
import br.com.edu.ufabc.isilanguage.exceptions.IsiSemanticException;
import br.com.edu.ufabc.isilanguage.ast.IsiProgram;
import br.com.edu.ufabc.isilanguage.ast.AbstractCommand;
import br.com.edu.ufabc.isilanguage.ast.CommandLeitura;
import br.com.edu.ufabc.isilanguage.ast.CommandEscrita;
import br.com.edu.ufabc.isilanguage.ast.CommandAtribuicao;
import br.com.edu.ufabc.isilanguage.ast.CommandDecisao;
import br.com.edu.ufabc.isilanguage.ast.CommandRepeticao;
import java.util.ArrayList;
import java.util.Stack;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link langParser}.
 */
public interface langListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link langParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(langParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(langParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(langParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(langParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(langParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(langParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(langParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(langParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(langParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(langParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(langParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(langParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(langParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(langParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(langParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(langParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(langParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(langParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdenquanto(langParser.CmdenquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdenquanto(langParser.CmdenquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(langParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(langParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(langParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(langParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(langParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(langParser.TermoContext ctx);

	
}