package C02_4.SIBUSINESS.rest;

public class BaseResponse<A> {
    private int status;
    private String message;
    private A result;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public A getResult() {
        return result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(A result) {
        this.result = result;
    }
}