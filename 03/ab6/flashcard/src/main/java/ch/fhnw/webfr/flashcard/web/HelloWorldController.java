package ch.fhnw.webfr.flashcard.web;

import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @GetMapping(produces = "text/html")
    @ResponseBody
    public String helloName(@RequestParam("name") String name) {
        int num = questionnaireRepository.findAll().size();
        return new StringBuffer("<span>Hello ")
                .append(name)
                .append("</span></br><span>You have ")
                .append(num)
                .append(" questionnaires in your repo.")
                .toString();
    }

}
