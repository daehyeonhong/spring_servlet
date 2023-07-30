package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberControllerV2 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping(value = "/springmvc/v1/members/save")
    public ModelAndView process(final HttpServletRequest request, final HttpServletResponse response) {
        final String username = request.getParameter("username");
        final int age = Integer.parseInt(request.getParameter("age"));
        final Member member = new Member(username, age);
        memberRepository.save(member);

        final ModelAndView modelAndView = new ModelAndView("save-result");
        modelAndView.addObject("member", member);
        return modelAndView;
    }
}
