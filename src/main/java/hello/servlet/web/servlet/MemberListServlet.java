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
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = this.memberRepository.findAll();

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
                        "    <title>MemberList</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<a href=\"/index.html\">메인</a>" +
                        "<table>\n" +
                        "    <thead>\n" +
                        "    <th>id</th>\n" +
                        "    <th>username</th>\n" +
                        "    <th>age</th>\n" +
                        "    </thead>\n" +
                        "    <tbody>\n");
        for (Member member : members)
            writer.write("    <tr>\n" +
                    "        <td>" + member.getId() + "</td>\n" +
                    "        <td>" + member.getUsername() + "</td>\n" +
                    "        <td>" + member.getAge() + "</td>\n" +
                    "    </tr>\n");

        writer.write("    </tbody>\n" +
                "</table>" +
                "</body>\n" +
                "</html>\n");
    }
}
