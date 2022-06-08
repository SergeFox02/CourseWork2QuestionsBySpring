package pro.sky.coursework2.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exception.QuestionListBadRequest;
import pro.sky.coursework2.service.QuestionService;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.coursework2.service.impl.DataConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private static final int DEFAULT_AMOUNT = 3;
    private static final int INVALID_AMOUNT_1 = - 1;
    private QuestionService mock1;
    private QuestionService mock2;
    private ExaminerServiceImpl out;

    @BeforeEach
    public void setUp() {
        mock1 = mock(QuestionService.class);
        mock2 = mock(QuestionService.class);
        this.out = new ExaminerServiceImpl(List.of(mock1, mock2));
    }

    @Test
    void ShouldReturnThrowWhenInvalidAmountInGetQuestions() {
        assertThrows(QuestionListBadRequest.class, () -> out.getQuestions(INVALID_AMOUNT_1));
    }

    @Test
    void ShouldReturnQuestionInGetQuestionsWhenAmountQuestionsENormal() {
        when(mock1.getRandomQuestion()).thenReturn(QUESTION_ANSWER_1, QUESTION_ANSWER_2);
        when(mock2.getRandomQuestion()).thenReturn(QUESTION_ANSWER_1, QUESTION_ANSWER_2, QUESTION_ANSWER_3);
        assertEquals(out.getQuestions(DEFAULT_AMOUNT).getClass(), HashSet.class);
    }
}