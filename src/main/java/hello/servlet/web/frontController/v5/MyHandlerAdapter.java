package hello.servlet.web.frontController.v5;

import hello.servlet.web.frontController.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface MyHandlerAdapter {
    boolean supports(final Object handler);

    ModelView handle(final HttpServletRequest request, final HttpServletResponse response,final Object handler) throws ServletException, IOException;
}
