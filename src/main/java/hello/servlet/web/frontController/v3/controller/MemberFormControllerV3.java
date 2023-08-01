package hello.servlet.web.frontController.v3.controller;

import hello.servlet.web.frontController.ModelView;

import java.util.Map;

public class MemberFormControllerV3 implements hello.servlet.web.frontController.v3.ControllerV3 {
    @Override
    public ModelView process(final Map<String, String> parameterMap) {
        return new ModelView("new-form");
    }
}
