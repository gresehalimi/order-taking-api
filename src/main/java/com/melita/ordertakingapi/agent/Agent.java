package com.melita.ordertakingapi.agent;

import com.melita.ordertakingapi.common.Country;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "agent")
@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String city;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Enumerated(EnumType.STRING)
    private Availability availability;

    enum Availability{
        NOT_AVAILABLE,
        AVAILABLE
    }
}
