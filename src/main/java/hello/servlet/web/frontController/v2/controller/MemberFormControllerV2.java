package hello.servlet.web.frontController.v2.controller;

import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
