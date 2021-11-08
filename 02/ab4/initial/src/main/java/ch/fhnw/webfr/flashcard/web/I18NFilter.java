package ch.fhnw.webfr.flashcard.web;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebFilter(urlPatterns = {"/*"})
public class I18NFilter extends HttpFilter {

    private static final String DEFAULT_FILE_NAME = "i18n.properties";
    private Properties properties;

    private Logger logger = Logger.getLogger(I18NFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);

        String filename = filterConfig.getServletContext().getInitParameter("translationFileName");
        filename = filename == null ? DEFAULT_FILE_NAME : filename;
        InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
        properties = new Properties();
        try {
            properties.load(new InputStreamReader(input, Charset.forName("UTF-8")));
            logger.log(Level.INFO, "Loaded translations");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not load translations");
            properties = null;
        }
    }

    protected void doFilter(HttpServletRequest request, HttpServletResponse response,
                            FilterChain chain) throws IOException, ServletException {


        logger.log(Level.INFO, "Its called");
        ResponseWrapper responseWrapper = new ResponseWrapper(response);
        chain.doFilter(request, responseWrapper);

        BufferedReader reader = new BufferedReader(responseWrapper.getReader());
        String line = reader.readLine();
        StringBuffer sb = new StringBuffer();

        while (line != null) {
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                line = line.replace((String) entry.getKey(), (String) entry.getValue());
                logger.log(Level.INFO, line);
                logger.log(Level.INFO, (String) entry.getKey());
                logger.log(Level.INFO, (String) entry.getValue());
            }
            sb.append(line);
            line = reader.readLine();
        }

        // Write updated response into original response instance
        Writer wr = response.getWriter();
        wr.append(sb.toString());
        wr.flush();
    }
}
