package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.ModelView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/springmvc/v2/members")
public class SpringMemberListControllerV2 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping(value = "/new-form")
    public ModelView newForm() {
        return new ModelView("new-form");
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(final HttpServletRequest request, final HttpServletResponse response) {
        final String username = request.getParameter("username");
        final int age = Integer.parseInt(request.getParameter("age"));
        final Member member = new Member(username, age);
        memberRepository.save(member);

        final ModelAndView modelAndView = new ModelAndView("save-result");
        modelAndView.addObject("member", member);
        return modelAndView;
    }

    @RequestMapping
    public ModelAndView members() {
        final List<Member> members = this.memberRepository.findAll();

        final ModelAndView modelAndView = new ModelAndView("members");
        modelAndView.addObject("members", members);
        return modelAndView;
    }
}
