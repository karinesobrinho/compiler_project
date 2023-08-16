// Generated from Lang.g4 by ANTLR 4.7.1
package br.com.language.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(LangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(LangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(LangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(LangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(LangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(LangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(LangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(LangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(LangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(LangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(LangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(LangParser.TermoContext ctx);
}