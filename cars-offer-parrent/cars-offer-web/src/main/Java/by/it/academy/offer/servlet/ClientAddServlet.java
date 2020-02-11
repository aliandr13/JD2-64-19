//package by.it.academy.offer.servlet;
//
//import by.it.academy.offer.model.Client;
//import by.it.academy.offer.service.CarServiceImp;
//import by.it.academy.offer.service.ClientService;
//import by.it.academy.offer.service.ClientServiceImpl;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.logging.Logger;
//
//@WebServlet(urlPatterns = "/student-add")
//public class ClientAddServlet extends HttpServlet {
//    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ClientAddServlet.class);
//    private final ClientService service = ClientServiceImpl.getService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("carSelected", 2L);
//        req.setAttribute("cars", CarServiceImp.getService().getAll());
//        req.getRequestDispatcher("/WEB-INF/jsp/client-add.jsp")
//                .forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String carId = req.getParameter("carId");
//
//        log("course id: " + carId);
//        Client client = new Client(null,
//                req.getParameter("firstName"),
//                req.getParameter("middleName"),
//                req.getParameter("lastName"),
//                req.getParameter("phone"));
//
//        service.add(client);
//        resp.sendRedirect(req.getContextPath() + "/client-list");
//
//    }
//}
//
