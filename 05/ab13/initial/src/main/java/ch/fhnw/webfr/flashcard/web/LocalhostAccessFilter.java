package ch.fhnw.webfr.flashcard.web;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LocalhostAccessFilter extends HttpFilter {

    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getRemoteHost() != "localhost") {
            response.getWriter().append("Access Denied");
        } else {
            chain.doFilter(request, response);
        }
    }


}
