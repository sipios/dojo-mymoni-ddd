package com.mymoni.investorprofile.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InvestorProfileFilterTest {

    @ParameterizedTest
    @CsvSource(
        {
            "30000,10000,PRINCIPAL_RESIDENCE,WEDDING,LESS_THAN_TWO_YEARS,RESPONSIBLE",
            "50000,1000,RETIREMENT,WEDDING,LESS_THAN_TWO_YEARS,DYNAMIC",
            "50000,1000,GROW_MY_ASSET,COMPANY,THREE_TO_FIVE_YEARS,ADVENTURER",
        }
    )
    public void getProfile(
        int revenue,
        int savings,
        Goal goal,
        Vision vision,
        Availability availability,
        ProfileName expectedProfileName
    ) {
        InvestorProfileFilter profilFilter = new InvestorProfileFilter(
            new Revenue(revenue),
            new Savings(savings),
            goal,
            vision,
            availability
        );

        ProfileName profileName = profilFilter.investorProfile();

        assertThat(profileName).isEqualTo(expectedProfileName);
    }
}
