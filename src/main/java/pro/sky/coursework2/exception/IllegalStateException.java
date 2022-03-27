package pro.sky.coursework2.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class IllegalStateException extends RuntimeException{
    public IllegalStateException(String message) {
        super(message);
    }
}
