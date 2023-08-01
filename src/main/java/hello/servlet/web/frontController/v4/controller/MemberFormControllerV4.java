package hello.servlet.web.frontController.v4.controller;

import hello.servlet.web.frontController.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {
    @Override
    public String process(final Map<String, String> parameterMap, final Map<String, Object> model) {
        return "new-form";
    }
}
