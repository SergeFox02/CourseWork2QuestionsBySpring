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

@Repository("javaRepository")
public class JavaQuestionRepository implements QuestionRepository{

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add(new Question("How much memory has a byte?","A byte has a storage capacity 1 byte."));
        add(new Question("How much memory has a short?","A short has a storage capacity 2 byte."));
        add(new Question("How much memory has a int?","A int has a storage capacity 4 byte."));
        add(new Question("How much memory has a long?","A long has a storage capacity 8 byte."));
        add(new Question("How much memory has a float?","A float has a storage capacity 4 byte."));
        add(new Question("How much memory has a double?","A double has a storage capacity 8 byte."));
        add(new Question("How much memory has a char?","A char has a storage capacity 2 byte."));
        add(new Question("How much memory has a boolean?","A boolean has a storage capacity 1 byte."));
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
