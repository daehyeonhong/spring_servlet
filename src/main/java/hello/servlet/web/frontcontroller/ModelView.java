package hello.servlet.web.frontcontroller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ModelView {

    String viewName;

    Map<String, Object> model = new ConcurrentHashMap<>();

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

}
