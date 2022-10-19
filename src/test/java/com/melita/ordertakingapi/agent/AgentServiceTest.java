package com.melita.ordertakingapi.agent;

import com.melita.ordertakingapi.common.Country;
import com.melita.ordertakingapi.mail.MailService;
import com.melita.ordertakingapi.mail.MailSettings;
import com.melita.ordertakingapi.mail.MailTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgentServiceTest {

    private static final Integer AGENT_ID = 1;
    private static final String EMAIL = "agent@gmail.com";

    @Mock
    MailService mailService;
    @Mock
    AgentRepository repository;
    @InjectMocks
    AgentService underTest;

    @Spy
    MailSettings mailSettings = MailSettings.builder().from("from").host("host").link("http://localhost:order").username("email").password("password").build();

    @Test
    void sendEmailToAnAgent_shouldSendEmail(){
        Agent agent = Agent.builder().id(AGENT_ID).email(EMAIL).build();
        when(repository.findByCountryAndCityAndAvailability(any(),any(),any())).thenReturn(Collections.singletonList(agent));
        underTest.sendEmailToAgent(Country.AL, "CITY", 1);
        verify(mailService).sendEmail(MailTemplate.builder().from(mailSettings.getFrom()).to(agent.getEmail()).subject("Order " + 1).text(mailSettings.link + 1).build());
    }
}
