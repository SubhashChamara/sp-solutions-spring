package biz.spsolutions.workallocationpanel.app.business.exception;

public enum BusinessExceptionType {

    BUSINESS(1000, "Business Exception"),
    FILE_NOT_CREATE(1001, "File Not Create");

    private final int code;
    private final String message;

    BusinessExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
