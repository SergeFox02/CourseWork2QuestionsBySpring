package pro.sky.coursework2.service.impl;

import org.junit.jupiter.api.Test;
import pro.sky.coursework2.data.Question;
import pro.sky.coursework2.exception.QuestionIsExist;
import pro.sky.coursework2.exception.QuestionNotExist;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.coursework2.service.impl.DataConstants.*;

class JavaQuestionServiceTest {

    private final JavaQuestionService out= new JavaQuestionService();

//    public static Stream<Arguments> QuestionServiceAddParamsTests() {
//        return Stream.of(
//                Arguments.of(Question(QU)),
//                Arguments.of(NUM_1, ZERO, NUM_1)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("QuestionServiceAddParamsTests")
//    public void shouldTrueSum(String question, String answer, String resultOfadd) {
//        Question result = out.add(question, answer);
//        assertEquals(result, resultOfadd);
//    }

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
}