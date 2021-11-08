package ch.fhnw.webfr.flashcard.web;

import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import ch.fhnw.webfr.flashcard.util.QuestionnaireInitializer;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class BasicListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final String mode = (String) sce.getServletContext().getInitParameter("mode");
        QuestionnaireRepository  questionnaireRepository;
        if (mode != null && mode.equals("test")) {
            questionnaireRepository = new QuestionnaireInitializer().initRepoWithTestData();
        } else {
            questionnaireRepository = new QuestionnaireRepository();
        }
        sce.getServletContext().setAttribute("questionnaireRepository", questionnaireRepository);
    }
}
