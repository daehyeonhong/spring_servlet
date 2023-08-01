package hello.servlet.web.frontController.v3.controller;

import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.ModelView;

import java.util.Map;

public class MemberListControllerV3 implements hello.servlet.web.frontController.v3.ControllerV3 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(final Map<String, String> parameterMap) {
        final var members = this.memberRepository.findAll();
        final ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", members);
        return modelView;
    }
}
