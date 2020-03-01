//package by.it.academy.offer.filter;
//
//import by.it.academy.entity.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.DispatcherType;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.*;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/*", dispatcherTypes = DispatcherType.REQUEST)
//public class AuthFilter extends HttpFilter {
//
//    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);
//
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpSession session = req.getSession();
//
//        logger.debug("url: {}", req.getRequestURI());
//        User user = (User) session.getAttribute("user");
//
//        if (user == null
//                && !req.getRequestURI().endsWith("/")
//                && !req.getRequestURI().endsWith("/home")
//                && !req.getRequestURI().endsWith("/login")
//                && !req.getRequestURI().endsWith("/Car-list")) {
//            res.sendRedirect(req.getContextPath() + "/login");
//
//        } else {
//            super.doFilter(req, res, chain);
//        }
//    }
//}
