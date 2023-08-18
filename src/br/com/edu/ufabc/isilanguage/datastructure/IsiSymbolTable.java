package br.edu.ufabc.isilanguage.datastructure;

import java.util.ArrayList;
import java.util.HashMap;

public class IsiSymbolTable {
    
    private HashMap<String, IsiSymbol> map;

    public IsiSymbolTable() {
        map = new HashMap<String, IsiSymbol>();
    }

    public void add(IsiSymbol symbol){
        map.put(symbol.getName(), symbol);
    }

    public boolean exists(String symbolName){
        return map.get(symbolName) != null;
    }

    public IsiSymbol get(String symbolName){
        return map.get(symbolName);
    }

    public ArrayList<IsiSymbol> getAll(){
        ArrayList<IsiSymbol> list = new ArrayList<IsiSymbol>();
        for (IsiSymbol symbol : map.values()) {
            list.add(symbol);
        }
        return list;
    }
}
