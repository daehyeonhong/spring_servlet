package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 1. parameter transmission method
 * Path: http://localhost:8080/request-parameter?username=hello&age=20
 */
@WebServlet(name = "requestParameterServlet", urlPatterns = "/request-parameter")
public class RequestParameterService extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(RequestParameterService.class);

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        logger.info("[ALL PARAMETER] - START");
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(
                        paramName -> logger.info("{} = {}", paramName, request.getParameter(paramName))
                );
        logger.info("[ALL PARAMETER] - END");

        logger.info("[SINGLE PARAMETER] - START");
        final String username = request.getParameter("username");
        final String age = request.getParameter("age");
        logger.info("username = {}", username);
        logger.info("age = {}", age);
        logger.info("[SINGLE PARAMETER] - END");

        response.getWriter().write("OK");
    }
}
