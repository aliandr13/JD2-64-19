package by.it.academy.offer.servlet;

import by.it.academy.entity.Car;
import by.it.academy.offer.service.ModelService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = "/Car-list")
@Slf4j
public class ModelListServlet extends HttpServlet {

    private ModelService modelService = new ModelService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        List<Car> avaliableCars = modelService.getAvaliableCars();

        log.info("cars {}", avaliableCars);

        req.setAttribute("avaliableCars", avaliableCars);

        req.getRequestDispatcher("/WEB-INF/jsp/model-list.jsp").forward(req, resp);
    }
}