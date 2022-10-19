package com.melita.ordertakingapi.order.outbound;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class OrderOutboundApi {

    private final OrderOutboundSettings settings;
    private final OrderOutboundService service;

    @PostMapping(value = "/order")
    public String publishPendingOrder(@RequestBody OrderOutbound orderOutbound) {
        service.sendToApprovalApi(orderOutbound);
        return settings.message;
    }
}
