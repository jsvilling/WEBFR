package ch.fhnw.webfr.flashcard.web;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/questionnaires")
public class QuestionnaireController {

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @GetMapping
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final List<Questionnaire> questionnaires = questionnaireRepository.findAll();
        final PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Example</title></head><body>");
        writer.append("<h3>Fragebögen</h3>");
        for (Questionnaire questionnaire : questionnaires) {
            String url = request.getContextPath() + request.getServletPath() + "/" + questionnaire.getId().toString();
            writer.append("<p><a href='").append(response.encodeURL(url)).append("'>").append(questionnaire.getTitle()).append("</a></p>");
        }
        writer.append("</body></html>");
    }

    @GetMapping("/{id}")
    public void findById(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) throws IOException {
        final Optional<Questionnaire> questionnaire = questionnaireRepository.findById(id);
        final PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Example</title></head><body>");
        writer.append("<h3>Questionnaire</h3>");
        questionnaire.ifPresentOrElse(q -> {
                    writer.append("<strong>").append(q.getTitle()).append("</strong></br>");
                    writer.append("<span>").append(q.getDescription()).append("</span></p>");
                }, () -> writer.append("no questionnaire found"));
        writer.append("</body></html>");
    }

}

