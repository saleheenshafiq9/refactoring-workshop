package workshop;

import org.junit.Test;

import  org.junit.Assert;

public class HtmlPagesConverterTest {
    PlaintextToHtmlConverterFake converter = new PlaintextToHtmlConverterFake();
    @Test
    public void charConversion() throws Exception {
        converter.setRead("<");
        Assert.assertEquals("&lt;", converter.toHtml());

        converter.setRead(">");
        Assert.assertEquals("&gt;", converter.toHtml());

        converter.setRead("&");
        Assert.assertEquals("&amp;", converter.toHtml());

        converter.setRead("\n");
        Assert.assertEquals("<br />", converter.toHtml());
    }

    @Test
    public void noConversion() throws Exception {
        converter.setRead("simple");
        Assert.assertEquals("simple", converter.toHtml());
    }

    @Test
    public void mixedCharConversion() throws Exception {
        converter.setRead("<small>\n&space");
        Assert.assertEquals("&lt;small&gt;<br />&amp;space", converter.toHtml());
    }

    static class PlaintextToHtmlConverterFake extends PlaintextToHtmlConverter {
        String text;
        protected void setRead(String text) {
            this.text = text;
        }
    }
}
