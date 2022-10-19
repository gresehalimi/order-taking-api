package com.melita.ordertakingapi.error;

public class InvalidData extends OrderTakingApiException{
    public InvalidData(String message) {
        super(OrderTakingApiError.INVALID_DATA, message);
    }
}
