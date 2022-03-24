package pro.sky.coursework2.service.impl;

import pro.sky.coursework2.data.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DataConstants {
    public static final String QUESTION_1= "How much memory has a int?";
    public static final String QUESTION_2= "How much memory has a short?";
    public static final String QUESTION_3= "How much memory has a int?";
    public static final String ANSWER_1 = "A byte has a storage capacity 1 byte.";
    public static final String ANSWER_2 = "A short has a storage capacity 2 byte.";
    public static final String ANSWER_3 = "A int has a storage capacity 4 byte.";

    public static final Question QUESTION_ANSWER_1 = new Question (QUESTION_1, ANSWER_1);
    public static  final Question QUESTION_ANSWER_2 = new Question (QUESTION_2, ANSWER_2);
    public static  final Question QUESTION_ANSWER_3 = new Question (QUESTION_3, ANSWER_3);

    public static  final Collection<Question> QUESTIONS = new HashSet<>(Set.of(
            QUESTION_ANSWER_1
//            QUESTION_ANSWER_2,
//            QUESTION_ANSWER_3
    ));
}
