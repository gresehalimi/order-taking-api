package com.melita.ordertakingapi.agent;

import com.melita.ordertakingapi.common.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Integer> {

    List<Agent> findByCountryAndCityAndAvailability(Country country, String city, Agent.Availability availability);

    List<Agent> findByCountryAndCity(Country country, String city);
}
