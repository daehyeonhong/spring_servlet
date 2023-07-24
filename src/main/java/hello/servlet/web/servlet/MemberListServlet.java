package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(MemberListServlet.class);
    private static final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final List<Member> members = memberRepository.findAll();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        final PrintWriter writer = response.getWriter();

        final String forward = """
                <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                <a href="/index.html">메인</a>
                <table>
                    <thead>
                    <th>id</th>
                    <th>username</th>
                    <th>age</th>
                    </thead>
                    <tbody>""";
        final String backward = """
                    </tbody>
                </table>
                </body>
                </html>
                        """;
        writer.write(forward);
        members.forEach(
                member -> writer.write("""
                        <tr>
                            <td>%d</td>
                            <td>%s</td>
                            <td>%d</td>
                        </tr>
                        """.formatted(member.getId(), member.getUsername(), member.getAge()))
        );
        writer.write(backward);
    }
}
