package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();


    @GetMapping(value = "/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping(value = "/save")
    public String save(@RequestParam(value = "username") final String username,
                       @RequestParam(value = "age") final int age,
                       final Model model) {
        final Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping
    public String members(final Model model) {
        final List<Member> members = this.memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}
