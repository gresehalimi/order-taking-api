package com.melita.ordertakingapi.order;

import com.melita.ordertakingapi.error.OrderTakingApiError;
import com.melita.ordertakingapi.error.OrderTakingApiException;

public class OrderNotFound extends OrderTakingApiException {

    public OrderNotFound(String message) {
        super(OrderTakingApiError.ORDER_NOT_FOUND, message);
    }

    public OrderNotFound(Integer id) {
        this("" + id);
    }
}
