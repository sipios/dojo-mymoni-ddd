package com.mymoni.investorprofile.infrastructure.controller;

import com.mymoni.investorprofile.domain.InvestorProfileFilter;
import com.mymoni.investorprofile.domain.ProfileName;
import com.mymoni.investorprofile.infrastructure.dto.InvestorProfileFilterRequestDTO;
import com.mymoni.investorprofile.infrastructure.dto.InvestorProfileResponseDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/investor-profile")
@Validated
public class InvestorProfileController {

    @PostMapping
    @Valid
    public InvestorProfileResponseDTO getInvestorProfile(
        @Valid @RequestBody InvestorProfileFilterRequestDTO investorProfileFilterRequestDTO
    ) {
        InvestorProfileFilter investorProfileFilter =
            investorProfileFilterRequestDTO.toDomain();

        ProfileName profile = investorProfileFilter.investorProfile();

        return new InvestorProfileResponseDTO(profile);
    }
}
