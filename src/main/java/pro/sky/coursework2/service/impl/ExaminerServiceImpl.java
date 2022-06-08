package pro.sky.coursework2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.exception.QuestionListBadRequest;
import pro.sky.coursework2.service.ExaminerService;
import pro.sky.coursework2.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> services;

    public ExaminerServiceImpl(List<QuestionService> questionServices){
        this.services = questionServices;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0) {
            throw new QuestionListBadRequest("Error in the number of questions");
        }
        Set<Question> questions = new HashSet<>();
        Random random = new Random();
        while (questions.size() < amount) {
            questions.add(services.get(random.nextInt(services.size())).getRandomQuestion());
        }
        return questions;
    }
}
