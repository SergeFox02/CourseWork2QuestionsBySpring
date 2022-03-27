package pro.sky.coursework2.repository;

import org.junit.jupiter.api.Test;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.exception.QuestionIsExist;
import pro.sky.coursework2.exception.QuestionNotExist;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.coursework2.service.impl.DataConstants.QUESTION_ANSWER_1;

class JavaQuestionRepositoryTest {

    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @Test
    void shouldReturnQuestionWhenAddQuestion() {
        assertEquals(out.add(QUESTION_ANSWER_1), QUESTION_ANSWER_1);
    }

    @Test
    void shouldReturnThrowWhenAddExistQuestion() {
        out.add(QUESTION_ANSWER_1);
        assertThrows(QuestionIsExist.class, () -> out.add(QUESTION_ANSWER_1));
    }
    @Test
    void shouldReturnQuestionWhenRemoveQuestion() {
        out.add(QUESTION_ANSWER_1);
        assertEquals(out.remove(QUESTION_ANSWER_1), QUESTION_ANSWER_1);
    }

    @Test
    void shouldReturnThrowWhenRemoveNotExistQuestion() {
        assertThrows(QuestionNotExist.class, () -> out.remove(QUESTION_ANSWER_1));
    }

    @Test
    void getAll() {
        Collection<Question> actual = out.getAll();
        out.add(QUESTION_ANSWER_1);
        assertEquals(actual.size(), out.getAll().size());
        boolean addQuestion = false;
        for (Question question : actual) {
            if (question.equals(QUESTION_ANSWER_1)) {
                addQuestion = true;
                break;
            }
        }
        assertTrue(addQuestion);
    }
}