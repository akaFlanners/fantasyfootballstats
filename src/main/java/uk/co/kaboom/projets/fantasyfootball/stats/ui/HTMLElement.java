package uk.co.kaboom.projets.fantasyfootball.stats.ui;

public enum HTMLElement {
    FOOTER("footerLogo", HTMLElementType.DIV),
    VIEW_SELECTBOX("id_element_filter", HTMLElementType.SELECT),
    SORT_SELECTBOX("id_stat_filter", HTMLElementType.SELECT);
    
    private final String name;
    private final HTMLElementType type;
    private final String selector;
    
    private HTMLElement(String name, HTMLElementType type) {
        this.name = name;
        this.type = type;
        this.selector = type.getType() + type.getCssSelectorSymbol() + name;
    }

    public String getName() {
        return name;
    }
    
    public HTMLElementType getType() {
        return type;
    }
   
    public String getSelector() {
        return selector;
    }
}
