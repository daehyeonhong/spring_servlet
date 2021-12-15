package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        this.memberRepository.save(member);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(
                "<!doctype html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                        "    <title>FormSuccess</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h1>성공!</h1>" +
                        "<ul>\n" +
                        "    <li>id=" + member.getId() + "</li>\n" +
                        "    <li>username=" + member.getUsername() + "</li>\n" +
                        "    <li>age=" + member.getAge() + "</li>\n" +
                        "</ul>" +
                        "<a href=\"/index.html\">메인</a>" +
                        "</body>\n" +
                        "</html>\n");
    }
}
