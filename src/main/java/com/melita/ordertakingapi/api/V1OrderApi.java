package com.melita.ordertakingapi.api;


import com.melita.ordertakingapi.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order/v1")
public class V1OrderApi {

    private final V1OrderConverter converter;

    private final OrderService service;

    @PostMapping(value = "create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    V1OrderCreateResponse create(HttpServletRequest request, @Valid @RequestBody V1OrderCreateRequest payload) {
        return converter.toCreateResponse(service.create(converter.toCreateQuery(payload)));
    }
}
