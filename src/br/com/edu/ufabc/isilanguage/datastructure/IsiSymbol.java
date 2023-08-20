package br.com.edu.ufabc.isilanguage.datastructure;

public abstract class IsiSymbol {
    
    protected String name;
    public abstract String generateJavaCode();

    public IsiSymbol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }
    

    @Override
    public String toString() {
        return "IsiSymbol[" + "name=" + name + ']';
    }
}
