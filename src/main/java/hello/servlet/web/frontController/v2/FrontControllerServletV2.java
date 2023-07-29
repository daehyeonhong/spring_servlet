package hello.servlet.web.frontController.v2;

import hello.servlet.web.frontController.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {
    private final Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        this.controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        this.controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        this.controllerMap.put("/front-controller/v2/members/members", new MemberListControllerV2());
    }

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final var requestURI = request.getRequestURI();
        final var controller = this.controllerMap.get(requestURI);
        if (controller == null) response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        else controller.process(request, response).render(request, response);
    }
}
