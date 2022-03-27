package pro.sky.coursework2.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.repository.QuestionRepository;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.coursework2.service.impl.DataConstants.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepositoryMock;

    @InjectMocks
    private MathQuestionService out;

    @Test
    void ShouldReturnQuestionWhenAddQuestionAndAnswer() {
        when(questionRepositoryMock.add(QUESTION_ANSWER_1)).thenReturn(QUESTION_ANSWER_1);
        assertEquals(QUESTION_ANSWER_1, out.add(QUESTION_1, ANSWER_1));
    }

    @Test
    void ShouldReturnQuestionWhenAddQuestion() {
        Question expectedQuestion = new Question(QUESTION_1, "");
        when(questionRepositoryMock.add(expectedQuestion)).thenReturn(expectedQuestion);
        assertEquals(expectedQuestion, out.add(QUESTION_1));
    }

    @Test
    void ShouldReturnQuestionWhenRemoveQuestion() {
        Question result = out.add(QUESTION_1);
        assertEquals(result, out.remove(QUESTION_1));
    }

    @Test
    void ShouldReturnAllQuestionsInGetAll() {
        Collection<Question> actual = out.getAll();
        assertEquals(out.getAll().getClass(), LinkedList.class);
        for (Question question : actual) {
            assertEquals(question.getClass(), Question.class);
        }
    }

    @Test
    void ShouldReturnQuestionInGetRandomQuestion() {
        when(questionRepositoryMock.getAll()).thenReturn(JAVA_QUESTIONS);
        assertEquals(out.getRandomQuestion().getClass(), Question.class);
    }
}