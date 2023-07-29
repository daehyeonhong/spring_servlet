package hello.servlet.web.frontController.v5;

import hello.servlet.basic.HelloServlet;
import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontController.v5.adapter.ControllerV3HandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HelloServlet {
    private final Map<String, Object> handlerMappingMap = new HashMap<>();

    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        this.handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        this.handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        this.handlerMappingMap.put("/front-controller/v5/v3/members/members", new MemberListControllerV3());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
    }

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final Object handler = getHandler(request);
        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        final MyHandlerAdapter adapter = getHandlerAdapter(handler);
        final ModelView modelView = adapter.handle(request, response, handler);

        final String viewName = modelView.getViewName();
        final MyView view = viewResolver(viewName);

        view.render(modelView.getModel(), request, response);
    }

    private MyView viewResolver(final String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private MyHandlerAdapter getHandlerAdapter(final Object handler) {
        return handlerAdapters.stream()
                .filter(adapter -> adapter.supports(handler))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("handler adapter not found. handler=%s".formatted(handler)));
    }

    private Object getHandler(final HttpServletRequest request) {
        final String requestURI = request.getRequestURI();
        return this.handlerMappingMap.get(requestURI);
    }
}
