package com.melita.ordertakingapi.mail;

import lombok.*;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class MailTemplate {

    private String from;

    private String to;

    private String subject;

    private String text;
}