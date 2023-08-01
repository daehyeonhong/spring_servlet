package hello.servlet.web.springmvc.v1;

import hello.servlet.web.frontController.ModelView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMemberFormControllerV1 {
    @RequestMapping(value = "/springmvc/v1/members/new-form")
    public ModelView process() {
        return new ModelView("new-form");
    }
}
