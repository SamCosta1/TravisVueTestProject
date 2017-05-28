
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Server
 */
@WebServlet("/Server")
public class Server extends HttpServlet {

    private static final long serialVersionUID = 1L;

    int count;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getHeader("X-Requested-With"));
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With")) || request.getHeader("X-Requested-With") == null)
            ajax(request, response);
        else
            getPage(request, response);
    }

    private void ajax(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HashMap<String, String> list = new HashMap<String, String>();
        list.put("hello", "world");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(list));
    }

    private void getPage(HttpServletRequest request, HttpServletResponse response) throws IOException	{
        System.out.println("GET");
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        out.println("Get Page");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Server Starting");
    }

    public void destroy() {
        super.destroy();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}