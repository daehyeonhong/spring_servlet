package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(RequestHeaderServlet.class);

    private static void printStartLine(final HttpServletRequest request) {
        logger.info("=== REQUEST-LINE - START ===");
        logger.info("request.getMethod() = {}", request.getMethod());
        logger.info("request.getProtocol() = {}", request.getProtocol());
        logger.info("request.getScheme() = {}", request.getScheme());
        logger.info("request.getRequestURL() = {}", request.getRequestURL());
        logger.info("request.getRequestURI() = {}", request.getRequestURI());
        logger.info("request.getQueryString() = {}", request.getQueryString());
        logger.info("request.isSecure() = {}", request.isSecure());
        logger.info("=== REQUEST-LINE - END ===");
    }

    private static void printHeaders(final HttpServletRequest request) {
        logger.info("=== Headers - START ===");

        request.getHeaderNames()
                .asIterator()
                .forEachRemaining(
                        headerName -> logger.info("{}: {}", headerName, request.getHeader(headerName))
                );

        logger.info("=== Headers - END ===");
        logger.info("");
    }

    private static void printHeadUtils(final HttpServletRequest request) {
        logger.info("=== Header 편의 조회 start ===");
        logger.info("[Host 편의 조회]");
        logger.info("request.getServerName() = {}", request.getServerName());
        logger.info("request.getServerPort() = {}", request.getServerPort());

        logger.info("[Accept-Language 편의 조회]");
        request.getLocales()
                .asIterator()
                .forEachRemaining(
                        locale -> logger.info("locale = {}", locale)
                );
        logger.info("request.getLocale() = {}", request.getLocale());

        logger.info("[cookie 편의 조회]");
        Arrays.asList(request.getCookies())
                .forEach(
                        cookie -> logger.info("cookie = name: {}, value: {}", cookie.getName(), cookie.getValue())
                );
        logger.info("[Content 편의 조회]");
        logger.info("request.getContentType() = {}", request.getContentType());
        logger.info("request.getContentLength() = {}", request.getContentLength());
        logger.info("request.getCharacterEncoding() = {}", request.getCharacterEncoding());
        logger.info("=== Header 편의 조회 end ===");
    }

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeadUtils(request);
    }
}
