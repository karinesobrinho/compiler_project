package br.com.edu.ufabc.isilanguage.ast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import br.com.edu.ufabc.isilanguage.datastructure.IsiSymbol;
import br.com.edu.ufabc.isilanguage.datastructure.IsiSymbolTable;

public class IsiProgram {
	private IsiSymbolTable varTable;
	private ArrayList<AbstractCommand> comandos;
        private ArrayList<String> varSemAtrib = new ArrayList<String>();
	private String programName;

	public void generateJavaTarget() {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Scanner;\n");
		str.append("public class MainClass{ \n");
		str.append("  public static void main(String args[]){\n ");
		str.append("      Scanner _key = new Scanner(System.in);\n");
		for (IsiSymbol symbol: varTable.getAll()) {
			str.append(symbol.generateJavaCode()+"\n");
                        varSemAtrib.add(symbol.getName());
		}
		for (AbstractCommand command: comandos) {
			str.append(command.generateJavaCode()+"\n");
                        
                        if(command.getCommand().equals("CommandAtribuicao"))
                        {
                            if(varSemAtrib.contains(command.getId()))
                            {
                                varSemAtrib.remove(command.getId());
                            }
                        }
		}
                
		str.append("  }");
		str.append("}");
		
		try {
			FileWriter fr = new FileWriter(new File("Output/MainClass.java"));
			fr.write(str.toString());
			fr.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}


	public void generatePythonTarget() {
		StringBuilder str = new StringBuilder();
		str.append("import sys\n");
		str.append("def main(args):\n");
		for (IsiSymbol symbol: varTable.getAll()) {
			str.append("\t"+symbol.generatePythonCode()+"\n");
                        varSemAtrib.add(symbol.getName());
		}
		int tabs = 1;
		for (AbstractCommand command: comandos) {
			str.append(command.generatePythonCode(tabs)+"\n");
                        
                        if(command.getCommand().equals("CommandAtribuicao"))
                        {
                            if(varSemAtrib.contains(command.getId()))
                            {
                                varSemAtrib.remove(command.getId());
                            }
                        }
		}
                
		str.append("\n");
		str.append("if __name__ == '__main__':\n");
		str.append("\t"+"main(sys.argv)\n");
		
		try {
			FileWriter fr = new FileWriter(new File("Output/main_.py"));
			fr.write(str.toString());
			fr.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}


	public IsiSymbolTable getVarTable() {
		return varTable;
	}

	public void setVarTable(IsiSymbolTable varTable) {
		this.varTable = varTable;
	}

	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}

	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
        
        public ArrayList<String> getVarSemUso()
        {
            return this.varSemAtrib;
        }

}