package com.melita.ordertakingapi.mail;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class MailSettings {

    public String defaultEncoding;
    public String host;
    public String from;
    public String link;
    public String username;
    public String password;
    public  Integer port;
    public String protocol;
    public boolean testConnection;
    public boolean propertiesMailSmtpAuth;
    public boolean propertiesMailSmtpStarttlsEnable;
}
