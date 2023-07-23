package hello.servlet.basic.response;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ResponseHeaderServlet.class);

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK);
        // [response-headers]
        // response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        // [Header Utils Method]
        content(response);
        cookie(response);
        redirect(response);
        response.getWriter().print("OK");
    }

    private static void content(final HttpServletResponse response) {
        // Content-Type: text/plain;charset=utf-8
        // Content-Length: 2
        // response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // response.setContentLength(2);
    }

    private void cookie(final HttpServletResponse response) {
        // Set-Cookie: myCookie=good; Max-Age=600;
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        final Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 600s
        response.addCookie(cookie);
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        // response.addHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        // response.addCookie(new Cookie("myCookie", "good"));
    }

    private void redirect(final HttpServletResponse response) {
        // Status Code 302
        // Location: /basic/hello-form.html
        response.setStatus(HttpServletResponse.SC_FOUND); // 302
        response.setHeader("Location", "/basic/hello-form.html");
        // response.sendRedirect("/basic/hello-form.html");
    }
}
