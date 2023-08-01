package hello.servlet.web.frontController.v1.controller;

import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.v1.ControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberListControllerV1 implements ControllerV1 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final var members = this.memberRepository.findAll();

        request.setAttribute("members", members);

        final var viewPath = "/WEB-INF/views/members.jsp";
        final var dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
