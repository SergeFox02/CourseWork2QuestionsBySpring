package pro.sky.coursework2.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.exception.QuestionListBadRequest;
import pro.sky.coursework2.service.ExaminerService;
import pro.sky.coursework2.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(
            @Qualifier("javaService") QuestionService javaQuestionService,
            @Qualifier("mathService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<QuestionService> listOfQuestions = List.of(javaQuestionService, mathQuestionService);
        int size = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        if (amount > size || amount < 1) {
            throw new QuestionListBadRequest("Error in the number of questions");
        }
        Set<Question> questions = new HashSet<>();
        Random random = new Random();
        while (questions.size() < amount) {
            questions.add(listOfQuestions.get(random.nextInt(listOfQuestions.size())).getRandomQuestion());
        }
        return questions;
    }
}
