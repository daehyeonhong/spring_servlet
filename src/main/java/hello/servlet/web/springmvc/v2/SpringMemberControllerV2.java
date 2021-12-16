package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/springmvc/v2/members")
public class SpringMemberControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping(value = "/save")
    public ModelAndView process(HttpServletRequest request) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        this.memberRepository.save(member);

        return new ModelAndView("save-result").addObject("member", member);
    }

    @RequestMapping(value = "/new-form")
    public ModelAndView save() {
        return new ModelAndView("new-form");
    }

    @RequestMapping(value = "")
    public ModelAndView list() {
        return new ModelAndView("members").addObject("members", this.memberRepository.findAll());
    }

}
