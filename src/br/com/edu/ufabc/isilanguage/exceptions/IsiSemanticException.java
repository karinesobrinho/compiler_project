package br.com.edu.ufabc.isilanguage.exceptions;

public class IsiSemanticException extends RuntimeException {
    public IsiSemanticException(String msg) {
        super(msg);
    }
    public static void showWarning(Warning warning, String name) {
        System.out.println(Warning(warning, name));
    }
    
    public static String Warning(Warning warning, String name) {
        String message;
        if (warning == Warning.UNASSIGNED_VARIABLE)
            message = "WARNING: Variable '" + name + "' declared but not used";
        else 
            message = "WARNING: " + name;
        
        return message;
    }
}
