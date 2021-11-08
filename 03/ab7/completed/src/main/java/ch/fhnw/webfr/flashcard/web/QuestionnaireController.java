package ch.fhnw.webfr.flashcard.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {
    private static final Log logger = LogFactory.getLog(QuestionnaireController.class);

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @GetMapping
    public void findAll(final HttpServletResponse response, final HttpServletRequest request) throws IOException {
        final List<Questionnaire> questionnaires = questionnaireRepository.findAll();
        final PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Example</title></head><body>");
        writer.append("<h3>Frageb&ouml;gen</h3>");
        for (final Questionnaire questionnaire : questionnaires) {
            String url = request.getContextPath() + request.getServletPath();
            url = url + "/" + questionnaire.getId().toString();
            writer.append("<p><a href='" + response.encodeURL(url) + "'>" + questionnaire.getTitle() + "</a></p>");
        }
        logger.debug("Found " + questionnaires.size() + " questionnaire entities");
        writer.append("</body></html>");
    }

    @GetMapping(value = "/{id}")
    public void findById(@PathVariable final Long id, final HttpServletResponse response,
            final HttpServletRequest request) throws IOException {
        final Questionnaire questionnaire = questionnaireRepository.findById(id);
        final PrintWriter writer = response.getWriter();
        if (questionnaire != null) {
            writer.append("<html><head><title>Example</title></head><body>");
            writer.append("<h3>Questionnaire</h3>");
            writer.append("<strong>" + questionnaire.getTitle() + "</strong></br>");
            writer.append("<span>" + questionnaire.getDescription() + "</span></p>");
            writer.append("</body></html>");
        } else {
            writer.append("<html><head><title>Example</title></head><body>");
            writer.append("<h3>Questionnaire no found</h3>");
        }
    }
}
