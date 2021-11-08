package ch.fhnw.webfr.flashcard.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ch.fhnw.webfr.flashcard.domain.FilterModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {

    private static final Log logger = LogFactory.getLog(QuestionnaireController.class);

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("questionnaires", questionnaireRepository.findAll());
        return "questionnaires/list";
    }

    @GetMapping(value = "/{id}")
    public String findById(@PathVariable String id, Model model) {
        Optional<Questionnaire> optional = questionnaireRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("questionnaire", optional.get());
            return "questionnaires/show";
        } else {
            return "404";
        }
    }

    @GetMapping(params = "form")
    public String createForm(Model model) {
        model.addAttribute("questionnaire", new Questionnaire());
        return "questionnaires/create";
    }

    @PostMapping
    public String create(@Valid Questionnaire questionnaire, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.debug("Binding error: " + bindingResult.getAllErrors());
            return "questionnaires/create";
        }
        questionnaireRepository.save(questionnaire);
        return "redirect:/questionnaires";
    }

    @PutMapping("/{id}")
    public String update(@Valid Questionnaire received, BindingResult bindingResult, @PathVariable("id") String id) {
        Optional<Questionnaire> optionalExisting = questionnaireRepository.findById(id);

        if (bindingResult.hasErrors()) {
            logger.debug("Binding error: " + bindingResult.getAllErrors());
            return "questionnaires/update";
        }

        if (optionalExisting.isEmpty()) {
            logger.warn("Questionnaire not found");
            return "404";
        }

        final Questionnaire existing = optionalExisting.get();
        existing.setTitle(received.getTitle());
        existing.setDescription(received.getDescription());

        questionnaireRepository.save(existing);
        return "redirect:/questionnaires";
    }

    @GetMapping(path = "/{id}", params = "form")
    public String updateView(@PathVariable("id") String id, Model model) {
        Optional<Questionnaire> optional = questionnaireRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("questionnaire", optional.get());
            return "questionnaires/update";
        } else {
            return "404";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        Optional<Questionnaire> optionalQuestionnaire = questionnaireRepository.findById(id);
        if (optionalQuestionnaire.isPresent()) {
            questionnaireRepository.delete(optionalQuestionnaire.get());
            return "redirect:/questionnaires";
        }
        logger.warn("Questionnaire not found");
        return "404";
    }

    @GetMapping(params = "filterForm")
    public String filterForm(Model model) {
        model.addAttribute("filterModel", new FilterModel());
        return "questionnaires/filterForm";
    }

    @GetMapping(params = "filterString")
    public String filterView(@RequestParam("filterString") String filterString, Model model) {
        List<Questionnaire> filtered = questionnaireRepository.findAll().stream().filter(q -> q.getTitle().startsWith(filterString)).collect(Collectors.toList());
        model.addAttribute("questionnaires", filtered);
        return "questionnaires/filterView";
    }

}
