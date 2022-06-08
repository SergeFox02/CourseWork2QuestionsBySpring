package pro.sky.coursework2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.exception.IllegalStateException;
import pro.sky.coursework2.exception.MethodNotAllowedException;
import pro.sky.coursework2.service.QuestionService;

import java.util.*;

@Service("mathService")
public class MathQuestionService implements QuestionService {

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException("Method add is not Allowed.");
    }

    @Override
    public Question add(String question) {
        throw new MethodNotAllowedException("Method add is not Allowed.");
    }

    @Override
    public Question remove(String question) {
        throw new MethodNotAllowedException("Method remove is not Allowed.");
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException("Method getAll is not Allowed.");
    }

    @Override
    public Question getRandomQuestion() {
        int number1 = random.nextInt(100);
        int number2 = random.nextInt(100);
        int operation = random.nextInt(3);
        String question;
        String answer;
        switch (operation) {
            case 0:
                question = number1 + " + " + number2;
                answer = String.valueOf(number1 + number2);
                break;
            case 1:
                question = number1 + " - " + number2;
                answer = String.valueOf(number1 - number2);
                break;
            case 2:
                question = number1 + " * " + number2;
                answer = String.valueOf(number1 * number2);
                break;
            case 3:
                if (number2 == 0) {
                    while (number2 != 0) {
                        number2 = random.nextInt(100);
                    }
                }
                question = number1 + " / " + number2;
                answer = String.valueOf(number1 / number2);
                break;
            default:
                throw new IllegalStateException("Illegal state exception");
        }
        return new Question(question, answer);
    }
}
