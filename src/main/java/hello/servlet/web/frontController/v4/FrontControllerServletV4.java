package hello.servlet.web.frontController.v4;

import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontController.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontController.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
    private final Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        this.controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        this.controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        this.controllerMap.put("/front-controller/v4/members/members", new MemberListControllerV4());
    }

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final var requestURI = request.getRequestURI();
        final var controller = this.controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        final var parameterMap = createParameterMap(request);
        final var model = new HashMap<String, Object>();
        final String viewName = controller.process(parameterMap, model);

        final MyView view = viewResolver(viewName);

        view.render(model, request, response);
    }

    private static MyView viewResolver(final String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static HashMap<String, String> createParameterMap(final HttpServletRequest request) {
        final var parameterMap = new HashMap<String, String>();
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(paramName -> parameterMap.put(paramName, request.getParameter(paramName)));
        return parameterMap;
    }
}
