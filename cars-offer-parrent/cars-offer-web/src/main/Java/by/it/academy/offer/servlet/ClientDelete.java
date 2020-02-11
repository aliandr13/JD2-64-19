//package by.it.academy.offer.servlet;
//
//import by.it.academy.offer.service.ClientService;
//import by.it.academy.offer.service.ClientServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/client-delete")
//public class ClientDelete extends HttpServlet {
//
//    private final ClientService service = ClientServiceImpl.getService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        deleteStudent(req, resp);
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        deleteStudent(req, resp);
//    }
//
//    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        Long clientId = Long.valueOf(req.getParameter("id"));
//        service.delete(clientId);
//        resp.sendRedirect(req.getContextPath() + "/client-list");
//    }
//}

