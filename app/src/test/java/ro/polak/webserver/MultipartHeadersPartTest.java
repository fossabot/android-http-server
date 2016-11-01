package ro.polak.webserver;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class MultipartHeadersPartTest {

    @Test
    public void shouldParseValidAttachmentHeader() {
        MultipartHeadersPart headers = new MultipartHeadersPart();
        headers.parse("Content-Disposition: attachment; name=\"FIELDNAME\"; filename=\"FILE.PDF\"\nContent-type: application/pdf");

        assertThat(headers.getFileName(), is("FILE.PDF"));
        assertThat(headers.getName(), is("FIELDNAME"));
        assertThat(headers.getContentType(), is("application/pdf"));
    }

    @Test
    public void shouldParseValidAttachmentHeaderCaseInsensitive() {
        MultipartHeadersPart headers = new MultipartHeadersPart();
        headers.parse("CONTENT-DISPOSITION: attachment; NAME=\"FIELDNAME\"; FILENAME=\"FILE.PDF\"\nContent-TYPE: application/pdf");

        assertThat(headers.getFileName(), is("FILE.PDF"));
        assertThat(headers.getName(), is("FIELDNAME"));
        assertThat(headers.getContentType(), is("application/pdf"));
    }

    @Test
    public void shouldParseFormDataText() {
        MultipartHeadersPart headers = new MultipartHeadersPart();
        headers.parse("Content-Disposition: form-data; name=\"text\"");

        assertThat(headers.getFileName(), is(nullValue()));
        assertThat(headers.getName(), is("text"));
        assertThat(headers.getContentType(), is(nullValue()));
    }
}
