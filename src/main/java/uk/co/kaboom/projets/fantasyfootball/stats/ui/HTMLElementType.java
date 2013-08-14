package uk.co.kaboom.projets.fantasyfootball.stats.ui;

public enum HTMLElementType {
    DIV("div", "."),
    SELECT("select", "#");
    
    private final String type;
    private final String cssSelectorSymbol;
    
    private HTMLElementType(String type, String cssSelectorSymbol) {
        this.type = type;
        this.cssSelectorSymbol = cssSelectorSymbol;
    }

    public String getType() {
        return type;
    }
    
    public String getCssSelectorSymbol() {
        return cssSelectorSymbol;
    }
    
    
}
