package com.melita.ordertakingapi.error;

public class OrderTakingApiException extends RuntimeException {

    private final OrderTakingApiError error;

    public OrderTakingApiException(OrderTakingApiError error) {
        this.error = error;
    }

    public OrderTakingApiException(OrderTakingApiError error, String message) {
        super(message);
        this.error = error;
    }

    public OrderTakingApiError getError(){
        return error;
    }
}
