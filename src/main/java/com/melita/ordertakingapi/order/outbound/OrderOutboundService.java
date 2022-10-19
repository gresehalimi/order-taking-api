package com.melita.ordertakingapi.order.outbound;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderOutboundService {

    private final RabbitTemplate template;
    private final OrderOutboundSettings settings;

    public void sendToApprovalApi(OrderOutbound orderOutbound) {
        template.convertAndSend(settings.exchange, settings.routingkey, orderOutbound);
    }
}
