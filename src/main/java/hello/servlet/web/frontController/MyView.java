package hello.servlet.web.frontController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MyView {
    private final String viewPah;

    public MyView(final String viewPah) {
        this.viewPah = viewPah;
    }

    public void render(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final RequestDispatcher dispatcher = request.getRequestDispatcher(this.viewPah);
        dispatcher.forward(request, response);
    }

    public void render(final Map<String, Object> model, final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);
        final RequestDispatcher dispatcher = request.getRequestDispatcher(this.viewPah);
        dispatcher.forward(request, response);
    }

    private static void modelToRequestAttribute(final Map<String, Object> model, final HttpServletRequest request) {
        model.forEach(request::setAttribute);
    }
}
