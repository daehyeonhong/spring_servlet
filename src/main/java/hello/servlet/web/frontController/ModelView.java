package hello.servlet.web.frontController;

import java.util.HashMap;
import java.util.Map;

public class ModelView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelView(final String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return this.viewName;
    }

    public Map<String, Object> getModel() {
        return this.model;
    }

    public void setViewName(final String viewName) {
        this.viewName = viewName;
    }

    public void setModel(final Map<String, Object> model) {
        this.model = model;
    }
}
