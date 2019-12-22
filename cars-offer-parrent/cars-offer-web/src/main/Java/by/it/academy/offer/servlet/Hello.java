package by.it.academy.offer.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello")
public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.print("<html>");
        pw.print("<h1> Hello-world</h1>");
        pw.print("</html>");
        req.getRequestDispatcher("/WEB-INF/first.jsp").forward(req, resp);
    }
}
