package com.melita.ordertakingapi.agent;

import com.melita.ordertakingapi.error.OrderTakingApiError;
import com.melita.ordertakingapi.error.OrderTakingApiException;
import com.melita.ordertakingapi.mail.MailService;
import com.melita.ordertakingapi.mail.MailSettings;
import com.melita.ordertakingapi.mail.MailTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import com.melita.ordertakingapi.common.Country;

@Slf4j
@RequiredArgsConstructor
@Service
public class AgentService {

    private final AgentRepository agentRepository;
    private final MailService mailService;
    private final MailSettings mailSettings;

    public void sendEmailToAgent(Country country, String city, Integer orderId) {
        Agent agent = findAnActiveAgent(country, city);
        mailService.sendEmail(MailTemplate.builder().from(mailSettings.getFrom()).to(agent.getEmail()).subject("Order " + orderId).text(mailSettings.link + orderId).build());
    }

    // we suppose that in every city of a country, we must have agents
    private Agent findAnActiveAgent(Country country, String city) {
        try {
            List<Agent> agents = agentRepository.findByCountryAndCityAndAvailability(country, city, Agent.Availability.AVAILABLE);
            if (!agents.isEmpty()) {
                return agents.get(0);
            }
            agents = agentRepository.findByCountryAndCity(country, city);
            return agents.get(0);
        } catch (OrderTakingApiException e) {
            log.info("No agent found in {} {}", city, country);
            throw new OrderTakingApiException(OrderTakingApiError.NO_AGENTS_FOUND);
        }
    }
}
