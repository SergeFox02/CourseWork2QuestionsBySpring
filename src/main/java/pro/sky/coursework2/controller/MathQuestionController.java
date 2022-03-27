package pro.sky.coursework2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.service.QuestionService;

@RestController
@RequestMapping("exam/math")
public class MathQuestionController {

    private final QuestionService mathQuestionService;

    public MathQuestionController(@Qualifier("mathService") QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public String addQuestion(@RequestParam(value = "question", required = false) String question,
                              @RequestParam(value = "answer", required = false) String answer) {
        return mathQuestionService.add(question, answer).toString();
    }

    @GetMapping("/remove")
    public String removeQuestion(@RequestParam(value = "question", required = false) String question) {
        return mathQuestionService.remove(question).toString();
    }

    @GetMapping()
    public String getAllQuestion() {
        return mathQuestionService.getAll().toString();
    }
}
