package hello.servlet.web.frontController.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(final Map<String, String> parameterMap, final Map<String, Object> model) {
        final String username = parameterMap.get("username");
        final int age = Integer.parseInt(parameterMap.get("age"));

        final Member member = new Member(username, age);
        this.memberRepository.save(member);

        model.put("member", member);
        return "save-result";
    }
}
