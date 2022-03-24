package pro.sky.coursework2.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class QuestionIsExist extends RuntimeException{
    public QuestionIsExist(String message) {
        super(message);
    }
}
