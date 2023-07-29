package hello.servlet.web.frontController.v5.adapter;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.v4.ControllerV4;
import hello.servlet.web.frontController.v5.MyHandlerAdapter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(final Object handler) {
        return handler instanceof ControllerV4;
    }

    @Override
    public ModelView handle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) {
        final ControllerV4 controller = (ControllerV4) handler;

        final var parameterMap = createParameterMap(request);
        final var model = new HashMap<String, Object>();

        final var viewName = controller.process(parameterMap, model);

        final var modelView = new ModelView(viewName);
        modelView.setModel(model);
        return modelView;
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
