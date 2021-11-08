package ch.fhnw.webfr.flashcard.web;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TracingListener implements ServletRequestListener {

    private static final Log logger = LogFactory.getLog(TracingListener.class);

    public void requestInitialized (ServletRequestEvent sre) {
        final String filterName = sre.getServletRequest().getParameter("filterName");
        if (filterName != null) {
            logger.info("Filter for " + filterName + " aplied");
        }
    }

}
