package pro.sky.coursework2.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.repository.QuestionRepository;
import pro.sky.coursework2.service.QuestionService;

import java.util.*;

@Service("javaService")
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository javaQuestionRepository;
    private final Random random = new Random();

    public JavaQuestionService(@Qualifier("javaRepository") QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(String question) {
        return javaQuestionRepository.add(new Question(question, ""));
    }

    @Override
    public Question remove(String question) {
        return javaQuestionRepository.remove(new Question(question, ""));
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> arrQfQuestions = new ArrayList<>(javaQuestionRepository.getAll());
        return arrQfQuestions.get(random.nextInt(arrQfQuestions.size()));
    }
}
