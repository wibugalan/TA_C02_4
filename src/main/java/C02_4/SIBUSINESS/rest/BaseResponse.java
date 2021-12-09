package C02_4.SIBUSINESS.rest;

public class BaseResponse {
    private int status;
    private String message;
    private ItemResponse result;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ItemResponse getResult() {
        return result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(ItemResponse result) {
        this.result = result;
    }
}