package tddmicroexercises.textconvertor;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class HtmlTextConverterShould {
    @Test
    public void save_file_name() {
        HtmlTextConverter converter = new HtmlTextConverter("fullFilenameWithPath");
        assertEquals("fullFilenameWithPath", converter.getFilename());
    }

    @Test public void
    convertFromFileToHtml() {

        //MatcherAssert.assertThat(, is());
    }
}
