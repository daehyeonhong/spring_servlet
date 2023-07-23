package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ResponseJsonServlet.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        // Content-Type: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        final HelloData helloData = new HelloData("kim", 20);

        // {"username": "kim", "age": 20}
        final String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);
    }
}
