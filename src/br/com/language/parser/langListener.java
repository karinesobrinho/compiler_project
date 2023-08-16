// Generated from lang.g4 by ANTLR 4.7.1
package br.com.language.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

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