package pro.sky.coursework2.service;

import pro.sky.coursework2.data.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
