package pro.sky.coursework2.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exception.QuestionListBadRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.coursework2.service.impl.DataConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private static final int DEFAULT_AMOUNT = 1;
    private static final int INVALID_AMOUNT_1 = - 1;
    private static final int INVALID_AMOUNT_2 = 1000;

    @Mock
    private JavaQuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void ShouldReturnThrowWhenInvalidAmountInGetQuestions() {
        assertThrows(QuestionListBadRequest.class, () -> out.getQuestions(INVALID_AMOUNT_1));
        assertThrows(QuestionListBadRequest.class, () -> out.getQuestions(INVALID_AMOUNT_2));
    }

    @Test
    void ShouldReturnQuestionInGetQuestionsWhenAmountQuestionsEqualsOne() {
        when(questionServiceMock.getRandomQuestion()).thenReturn(QUESTION_ANSWER_1);
        when(questionServiceMock.getAll()).thenReturn(QUESTIONS);
        assertTrue(out.getQuestions(DEFAULT_AMOUNT).contains(QUESTION_ANSWER_1));
        verify(questionServiceMock, (times(1))).getAll();
        assertEquals(1, out.getQuestions(DEFAULT_AMOUNT).size());
        verify(questionServiceMock, (times(2))).getAll();
    }
}