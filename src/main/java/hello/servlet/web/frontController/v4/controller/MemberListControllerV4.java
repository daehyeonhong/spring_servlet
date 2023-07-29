package hello.servlet.web.frontController.v4.controller;

import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.v4.ControllerV4;

import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(final Map<String, String> parameterMap, final Map<String, Object> model) {
        final var members = this.memberRepository.findAll();

        model.put("members", members);
        return "members";
    }
}
