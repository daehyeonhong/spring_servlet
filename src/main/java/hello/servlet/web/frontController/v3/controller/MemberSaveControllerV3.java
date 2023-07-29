package hello.servlet.web.frontController.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.ModelView;

import java.util.Map;

public class MemberSaveControllerV3 implements hello.servlet.web.frontController.v3.ControllerV3 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(final Map<String, String> parameterMap) {
        final String username = parameterMap.get("username");
        final int age = Integer.parseInt(parameterMap.get("age"));

        final Member member = new Member(username, age);
        this.memberRepository.save(member);

        final ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);
        return modelView;
    }
}
