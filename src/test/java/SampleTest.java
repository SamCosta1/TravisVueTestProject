import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by sam on 27/05/17.
 */
public class SampleTest {

    @Test
    public void myTest() {
        assertTrue(Sample.sampleMethod() == 1);
    }

    @Test
    public void myOtherTest() {
        assertTrue(Sample.sampleMethod() == 1);
    }


    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("Message")).thenReturn("testMessage");
        PrintWriter writer = new PrintWriter("somefile.txt");
        when(response.getWriter()).thenReturn(writer);

        new Server().doPost(request, response);

        writer.flush(); // it may not have been flushed yet...



    }
}