package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @PostMapping(value = "/save")
    public String process(@RequestParam String username,
                          @RequestParam int age,
                          Model model) {
        Member member = new Member(username, age);
        this.memberRepository.save(member);
        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping(value = "/new-form")
    public String save() {
        return "new-form";
    }

    @GetMapping(value = "")
    public String list(Model model) {
        model.addAttribute("members", this.memberRepository.findAll());
        return "members";
    }

}
