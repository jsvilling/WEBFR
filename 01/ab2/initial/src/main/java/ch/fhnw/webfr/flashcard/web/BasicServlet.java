package ch.fhnw.webfr.flashcard.web;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import ch.fhnw.webfr.flashcard.util.QuestionnaireInitializer;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BasicServlet extends HttpServlet {
    /*
     * Attention: This repository will be used by all clients, concurrency
     * could be a problem. THIS VERSION IS NOT PRODUCTION READY!
     */
    private QuestionnaireRepository questionnaireRepository;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");

        String[] pathElements = request.getRequestURI().split("/");
        if (isLastPathElementQuestionnaires(pathElements)) {
            handleQuestionnairesRequest(request, response);
        } else if (isPathForSingleQuestionaire(pathElements)) {
            handleSingleQuestionaireRequest(request, response);
        } else {
            handleIndexRequest(request, response);
        }
    }

    private boolean isPathForSingleQuestionaire(String[] pathElements) {
        return pathElements[pathElements.length - 2].equals("questionnaires")
                && isNumber(pathElements[pathElements.length - 1]);
    }

    private boolean isNumber(String string) {
        try {
            Long.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isLastPathElementQuestionnaires(String[] pathElements) {
        String last = pathElements[pathElements.length - 1];
        return last.equals("questionnaires");
    }

    private void handleQuestionnairesRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<Questionnaire> questionnaires = questionnaireRepository.findAll();
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Example</title></head><body><h3>Frageb&ouml;gen</h3>");
        for (Questionnaire questionnaire : questionnaires) {
            String url = request.getContextPath() + request.getServletPath();
            url = url + "/questionnaires/" + questionnaire.getId().toString();
            writer.append("<p><a href='").append(response.encodeURL(url)).append("'>").append(questionnaire.getTitle()).append("</a></p>");
        }
        writer.append("</body></html>");
    }

    private void handleSingleQuestionaireRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String[] pathElements = request.getRequestURI().split("/");
        final Long index = Long.valueOf(pathElements[pathElements.length - 1]);
        Questionnaire questionnaire;
        try {
            questionnaire = questionnaireRepository.findById(index);
        } catch(Exception e) {
            questionnaire = null;
        }
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Questionaire</title></head><body><h3>Test Questionaire ");
        writer.append(pathElements[pathElements.length - 1]);
        if (questionnaire != null) {
            writer.append("<strong>").append(questionnaire.getTitle()).append("</strong></br>");
            writer.append("<span>").append(questionnaire.getDescription()).append("</span>");
        }
        writer.append("</h3><p>Lorem ipsum dolor si amet...</p></body></html>");
    }

    private void handleIndexRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String url = request.getContextPath() + request.getServletPath();
        writer.append("<html><head><title>Example</title></head><body><h3>Welcome</h3>");
        writer.append("<p><a href='").append(response.encodeURL(url)).append("/questionnaires'>All Questionnaires</a></p></body></html>");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        questionnaireRepository = new QuestionnaireInitializer().initRepoWithTestData();

    }

}
