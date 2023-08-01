package hello.servlet.web.frontController.v5.adapter;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.v3.ControllerV3;
import hello.servlet.web.frontController.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(final Object handler) {
        return handler instanceof ControllerV3;
    }

    @Override
    public ModelView handle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws ServletException, IOException {
        final ControllerV3 controller = (ControllerV3) handler;

        final Map<String, String> parameterMap = createParameterMap(request);

        return controller.process(parameterMap);
    }


    private static Map<String, String> createParameterMap(final HttpServletRequest request) {
        final var parameterMap = new HashMap<String, String>();
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(paramName -> parameterMap.put(paramName, request.getParameter(paramName)));
        return parameterMap;
    }
}
