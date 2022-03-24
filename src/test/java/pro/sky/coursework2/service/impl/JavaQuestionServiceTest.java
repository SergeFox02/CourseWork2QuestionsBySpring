package pro.sky.coursework2.service.impl;

import org.junit.jupiter.api.Test;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.exception.QuestionIsExist;
import pro.sky.coursework2.exception.QuestionNotExist;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.coursework2.service.impl.DataConstants.*;

class JavaQuestionServiceTest {

    private final JavaQuestionService out= new JavaQuestionService();

    @Test
    void ShouldReturnTrueAddQuestionAndAnswer() {
        Question result = out.add(QUESTION_1, ANSWER_1);
        assertEquals(QUESTION_ANSWER_1, result);
    }

    @Test
    void ShouldReturnExceptionInAddWhenQuestionAndAnswerExistInList() {
        out.add(QUESTION_1, ANSWER_1);
        assertThrows(QuestionIsExist.class, () -> out.add(QUESTION_1, ANSWER_1));
    }

    @Test
    void ShouldReturnTrueAddQuestion() {
        Question result = out.add(QUESTION_1);
        assertEquals(new Question(QUESTION_1, ""), result);
    }

    @Test
    void ShouldReturnExceptionInAddWhenQuestionExistInList() {
        out.add(QUESTION_1);
        assertThrows(QuestionIsExist.class, () -> out.add(QUESTION_1));
    }

    @Test
    void ShouldReturnTrueQuestionWhenRemove() {
        Question result = out.add(QUESTION_1);
        assertEquals(result, out.remove(QUESTION_1));
    }


    @Test
    void ShouldReturnExceptionInRemoveWhenQuestionNotExistInList() {
        assertThrows(QuestionNotExist.class, () -> out.remove(QUESTION_1));
    }

    @Test
    void ShouldReturnAllQuestionsInGetAll() {
        Collection<Question> actual = out.getAll();
        out.add(QUESTION_1, ANSWER_1);
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

    @Test
    void ShouldReturnAnyQuestionInGetRandomQuestion() {
        out.add(QUESTION_1, ANSWER_1);
        Question actualQuestion = out.getRandomQuestion();
        assertTrue(actualQuestion != null && Question.class == actualQuestion.getClass());
    }
}