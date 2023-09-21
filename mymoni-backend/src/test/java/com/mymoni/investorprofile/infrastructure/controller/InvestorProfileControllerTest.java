package com.mymoni.investorprofile.infrastructure.controller;

import static com.mymoni.investorprofile.domain.Availability.LESS_THAN_TWO_YEARS;
import static com.mymoni.investorprofile.domain.Availability.THREE_TO_FIVE_YEARS;
import static com.mymoni.investorprofile.domain.Goal.GROW_MY_ASSET;
import static com.mymoni.investorprofile.domain.Goal.PRINCIPAL_RESIDENCE;
import static com.mymoni.investorprofile.domain.Vision.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mymoni.investorprofile.infrastructure.dto.InvestorProfileFilterRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
class InvestorProfileControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_return_RESPONSIBLE_investment_profil() throws Exception {
        InvestorProfileFilterRequestDTO investorProfileFilterRequestDTO =
            new InvestorProfileFilterRequestDTO(
                30000,
                10000,
                PRINCIPAL_RESIDENCE.name(),
                WEDDING.name(),
                LESS_THAN_TWO_YEARS.name()
            );

        this.getInvestments(investorProfileFilterRequestDTO)
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.label").value("RESPONSIBLE"))
            .andExpect(jsonPath("$.investments", hasSize(5)))
            .andExpect(jsonPath("$.investments[0].share").value(25))
            .andExpect(jsonPath("$.investments[1].share").value(12))
            .andExpect(jsonPath("$.investments[2].share").value(12))
            .andExpect(jsonPath("$.investments[3].share").value(25))
            .andExpect(jsonPath("$.investments[4].share").value(25));
    }

    @Test
    void should_return_DYNAMIC_investment_profil() throws Exception {
        InvestorProfileFilterRequestDTO investorProfileFilterRequestDTO =
            new InvestorProfileFilterRequestDTO(
                30000,
                10000,
                GROW_MY_ASSET.name(),
                COMPANY.name(),
                LESS_THAN_TWO_YEARS.name()
            );

        this.getInvestments(investorProfileFilterRequestDTO)
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.label").value("DYNAMIC"))
            .andExpect(jsonPath("$.investments", hasSize(5)))
            .andExpect(jsonPath("$.investments[0].share").value(20))
            .andExpect(jsonPath("$.investments[1].share").value(17))
            .andExpect(jsonPath("$.investments[2].share").value(17))
            .andExpect(jsonPath("$.investments[3].share").value(22))
            .andExpect(jsonPath("$.investments[4].share").value(22));
    }

    @Test
    void should_return_ADVENTURER_investment_profil() throws Exception {
        InvestorProfileFilterRequestDTO investorProfileFilterRequestDTO =
            new InvestorProfileFilterRequestDTO(
                300000,
                500000,
                GROW_MY_ASSET.name(),
                RETIREMENT.name(),
                THREE_TO_FIVE_YEARS.name()
            );

        this.getInvestments(investorProfileFilterRequestDTO)
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.label").value("ADVENTURER"))
            .andExpect(jsonPath("$.investments", hasSize(5)))
            .andExpect(jsonPath("$.investments[0].share").value(15))
            .andExpect(jsonPath("$.investments[1].share").value(25))
            .andExpect(jsonPath("$.investments[2].share").value(15))
            .andExpect(jsonPath("$.investments[3].share").value(22))
            .andExpect(jsonPath("$.investments[4].share").value(22));
    }

    private ResultActions getInvestments(
        InvestorProfileFilterRequestDTO investorProfileFilterRequestDTO
    ) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(
            investorProfileFilterRequestDTO
        );

        return mockMvc.perform(
            post("/investor-profile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)
        );
    }
}
