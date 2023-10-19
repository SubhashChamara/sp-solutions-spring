package biz.spsolutions.workallocationpanel.app.business.exception;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class BusinessException extends RuntimeException {
    private final BusinessExceptionType businessExceptionType;

    public BusinessException(BusinessExceptionType businessExceptionTypes) {
        this.businessExceptionType = businessExceptionTypes;
    }

    public BusinessException(BusinessExceptionType type, String message, Throwable cause) {
        super("Code: " + type.getCode() +"; " + message, cause);
        this.businessExceptionType = type;
    }
}
