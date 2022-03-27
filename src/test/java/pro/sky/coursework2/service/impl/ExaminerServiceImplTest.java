package pro.sky.coursework2.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exception.QuestionListBadRequest;
import pro.sky.coursework2.repository.JavaQuestionRepository;
import pro.sky.coursework2.repository.MathQuestionRepository;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.coursework2.service.impl.DataConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private static final int DEFAULT_AMOUNT = 3;
    private static final int INVALID_AMOUNT_1 = - 1;
    private static final int INVALID_AMOUNT_2 = 1000;

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @Mock
    private MathQuestionService mathQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void ShouldReturnThrowWhenInvalidAmountInGetQuestions() {
        assertThrows(QuestionListBadRequest.class, () -> out.getQuestions(INVALID_AMOUNT_1));
        assertThrows(QuestionListBadRequest.class, () -> out.getQuestions(INVALID_AMOUNT_2));
    }

    @Test
    void ShouldReturnQuestionInGetQuestionsWhenAmountQuestionsEqualsOne() {
        when(javaQuestionServiceMock.getAll()).thenReturn(JAVA_QUESTIONS);
        when(mathQuestionServiceMock.getAll()).thenReturn(MATH_QUESTIONS);
        assertEquals(out.getQuestions(DEFAULT_AMOUNT).getClass(), Collection.class);
    }
}