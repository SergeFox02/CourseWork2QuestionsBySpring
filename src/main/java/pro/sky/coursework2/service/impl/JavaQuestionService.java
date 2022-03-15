package pro.sky.coursework2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.exception.QuestionIsExist;
import pro.sky.coursework2.exception.QuestionNotExist;

import java.util.*;

@Service
public class JavaQuestionService implements pro.sky.coursework2.service.QuestionService {

    private final Set<Question> questions = new HashSet<>(Set.of(
            new Question("How much memory has a byte?","A byte has a storage capacity 1 byte."),
            new Question("How much memory has a short?","A short has a storage capacity 2 byte."),
            new Question("How much memory has a int?","A int has a storage capacity 4 byte."),
            new Question("How much memory has a long?","A long has a storage capacity 8 byte."),
            new Question("How much memory has a float?","A float has a storage capacity 4 byte."),
            new Question("How much memory has a double?","A double has a storage capacity 8 byte."),
            new Question("How much memory has a char?","A char has a storage capacity 2 byte."),
            new Question("How much memory has a boolean?","A boolean has a storage capacity 1 byte.")
    ));

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (questions.add(newQuestion)) {
            return newQuestion;
        }
        throw new QuestionIsExist("This question exist!");
    }

    @Override
    public Question add(String question) {
        Question newQuestion = new Question(question, "");
        if (questions.add(newQuestion)) {
            return newQuestion;
        }
        throw new QuestionIsExist("This question exist!");
    }

    @Override
    public Question remove(String question) {
        Question removeQuestion = new Question(question, "");
        if (questions.remove(removeQuestion)) {
            return removeQuestion;
        }
        throw new QuestionNotExist("This question not exist!");
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> arrQfQuestions = new ArrayList<>(questions);
        int randomQuestion = random.nextInt(questions.size());
        return arrQfQuestions.get(randomQuestion);
    }
}
