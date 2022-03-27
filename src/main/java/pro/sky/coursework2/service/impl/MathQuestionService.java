package pro.sky.coursework2.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.repository.QuestionRepository;
import pro.sky.coursework2.service.QuestionService;

import java.util.*;

@Service("mathService")
public class MathQuestionService implements QuestionService {

    private final QuestionRepository mathQuestionRepository;
    private final Random random = new Random();

    public MathQuestionService(@Qualifier("mathRepository") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return mathQuestionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(String question) {
        return mathQuestionRepository.add(new Question(question, ""));
    }

    @Override
    public Question remove(String question) {
        return mathQuestionRepository.remove(new Question(question, ""));
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> arrQfQuestions = new ArrayList<>(mathQuestionRepository.getAll());
        int randomQuestion = random.nextInt(arrQfQuestions.size());
        return arrQfQuestions.get(randomQuestion);
    }
}
