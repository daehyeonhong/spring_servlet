package hello.servlet.web.frontController.v3;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
    private final Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        this.controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        this.controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        this.controllerMap.put("/front-controller/v3/members/members", new MemberListControllerV3());
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
        final ModelView modelView = controller.process(parameterMap);

        final String viewName = modelView.getViewName();
        final MyView view = viewResolver(viewName);

        view.render(modelView.getModel(), request, response);
    }

    private static MyView viewResolver(final String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParameterMap(final HttpServletRequest request) {
        return Collections.list(request.getParameterNames())
                .stream()
                .collect(Collectors.toMap(
                        paramName -> paramName,
                        request::getParameter
                ));
    }
}
