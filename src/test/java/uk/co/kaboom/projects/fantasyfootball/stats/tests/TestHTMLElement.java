package uk.co.kaboom.projects.fantasyfootball.stats.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.HTMLElement;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.HTMLElementType;

/**
 * Test HTMLElement and HTMLElementType
 * These tests are closely aligned to the data - changes in data will require changes in the tests.
 *  @author FlannersAdmin
 *
 */
public class TestHTMLElement {

    @Test
    public final void testGetName() {
        assertEquals("footerLogo", HTMLElement.FOOTER.getName());
    }

    @Test
    public final void testGetType() {
        assertEquals("Test of DIV",              ".",                 HTMLElementType.DIV.getCssSelectorSymbol());
        assertEquals("Test of SELECT",           "#",                 HTMLElementType.SELECT.getCssSelectorSymbol());
        
        assertEquals("Test FOOTER DIV",          HTMLElementType.DIV, HTMLElement.FOOTER.getType());
        assertEquals("TEST FOOTER DIV Selector", ".",                 HTMLElement.FOOTER.getType().getCssSelectorSymbol());
    }

    @Test
    public final void testGetSelector() {
        assertEquals("div.footerLogo", HTMLElement.FOOTER.getSelector());
    }

}
