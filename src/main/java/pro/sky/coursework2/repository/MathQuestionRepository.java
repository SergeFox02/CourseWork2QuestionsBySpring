package pro.sky.coursework2.repository;

import org.springframework.stereotype.Repository;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.exception.QuestionIsExist;
import pro.sky.coursework2.exception.QuestionNotExist;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("mathRepository")
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public MathQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    private void init() {
        add(new Question("2 + 2 ","4"));
        add(new Question("2 + 3 ","5"));
        add(new Question("2 - 2 ","0"));
        add(new Question("2 - 3 ","-1"));
        add(new Question("2 * 2 ","4"));
        add(new Question("2 * 3 ","6"));
        add(new Question("6 / 2 ","3"));
        add(new Question("6 / 3 ","2"));
    }

    @Override
    public Question add(Question newQuestion) {
        if (questions.add(newQuestion)) {
            return newQuestion;
        }
        throw new QuestionIsExist("This question exist!");
    }

    @Override
    public Question remove(Question removeQuestion) {
        if (questions.remove(removeQuestion)) {
            return removeQuestion;
        }
        throw new QuestionNotExist("This question not exist!");
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
}
