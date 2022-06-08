package pro.sky.coursework2.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.exception.MethodNotAllowedException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.coursework2.service.impl.DataConstants.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    private final MathQuestionService out = new MathQuestionService();

    @Test
    void ShouldReturnThrowInAddQuestionAndAnswer() {
        assertThrows(MethodNotAllowedException.class, () -> out.add(QUESTION_1, ANSWER_1));
    }

    @Test
    void ShouldReturnThrowInAddQuestion() {
        assertThrows(MethodNotAllowedException.class, () -> out.add(QUESTION_1));
    }

    @Test
    void ShouldReturnThrowInRemove() {
        assertThrows(MethodNotAllowedException.class, () -> out.remove(QUESTION_1));
    }

    @Test
    void ShouldReturnThrowInGetAll() {
        assertThrows(MethodNotAllowedException.class, () -> out.getAll());
    }

    @Test
    void ShouldReturnQuestionInGetRandomQuestion() {
        assertEquals(out.getRandomQuestion().getClass(), Question.class);
    }
}