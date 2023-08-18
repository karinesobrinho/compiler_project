package br.edu.ufabc.isilanguage.datastructure;

public class IsiSymbol {
    
    protected String name;

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
