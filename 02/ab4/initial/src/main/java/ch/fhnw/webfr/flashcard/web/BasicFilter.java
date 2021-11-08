package ch.fhnw.webfr.flashcard.web;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebFilter(urlPatterns = {"/*"})
public class BasicFilter extends HttpFilter {

    private static final Logger logger = Logger.getLogger(BasicFilter.class.getName());

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        final StringBuilder sb = new StringBuilder("Before request [uri=");
        sb.append(request.getRequestURI());
        sb.append("]");
        logger.log(Level.INFO, sb.toString());
        chain.doFilter(request, response);
    }

}
