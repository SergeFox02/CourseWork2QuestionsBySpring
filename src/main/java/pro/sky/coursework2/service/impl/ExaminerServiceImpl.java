package pro.sky.coursework2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.exception.QuestionListBadRequest;
import pro.sky.coursework2.service.ExaminerService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> listOfQuestions = new HashSet<>();
        if (amount > questionService.getAll().size() || amount < 1) {
            throw new QuestionListBadRequest("Error in the number of questions");
        }
        int counter = 0;
        while (counter < amount) {
            Question randomQuestion = questionService.getRandomQuestion();
            if (listOfQuestions.add(randomQuestion)) {
                counter++;
            }
        }
        return listOfQuestions;
    }
}
