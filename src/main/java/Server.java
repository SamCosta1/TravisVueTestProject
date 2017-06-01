
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class Server
 */
@WebServlet("/Server")
public class Server extends HttpServlet {

    private static final long serialVersionUID = 1L;

    int count;

    @Resource(name="jdbc/MathsChat")
    private DataSource ds;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With")) || request.getHeader("X-Requested-With") == null)
            ajax(request, response);
        else
            getPage(request, response);
    }

    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> list = new HashMap<String, Object>();
        System.out.println("POST" + request.getParameter("message"));

        list.put("msg", request.getParameter("message"));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(list));

    }

    private void ajax(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int x = 0;
        Connection con = null;
        try {
            con = ds.getConnection();
            ResultSet rs = con.createStatement().executeQuery("CALL spGetHighestUserID();");
            rs.next();

            x = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (con != null) try { con.close(); } catch (Exception e) { System.out.println(e); }
        }
        HashMap<String, Object> list = new HashMap<String, Object>();
        HashMap<String, Object> sublist = new HashMap<String, Object>();

        list.put("hello", new Date().toString());
        list.put("sqltest", ""+x);

        String s[] = {"First message" , "Second Message", "Third Message"} ;
        list.put("heads", s);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(list));

    }
    private void getPage(HttpServletRequest request, HttpServletResponse response) throws IOException	{
       // System.out.println("GET");
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