package com.mymoni.investorprofile.infrastructure.repository;

import com.mymoni.investorprofile.domain.Fund;
import com.mymoni.investorprofile.domain.RiskLevel;
import com.mymoni.investorprofile.domain.port.Funds;
import java.time.Instant;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FundsRepository implements Funds {

    @Override
    public List<Fund> all() {
        return List.of(
            new Fund(
                "ESG Obligation europe",
                new RiskLevel(1),
                Instant.parse("2025-11-20T20:14:12Z")
            ),
            new Fund(
                "ESG prudent euro",
                new RiskLevel(1),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "ESG court terme",
                new RiskLevel(2),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "Echiquier positif impact europe",
                new RiskLevel(2),
                Instant.parse("2021-12-10T09:12:11Z")
            ),
            new Fund(
                "Choix solidaire",
                new RiskLevel(2),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "Duration ESG",
                new RiskLevel(3),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "Planète monde",
                new RiskLevel(3),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "Echiquier positif impact Europe",
                new RiskLevel(5),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "Fidelity Europe Action",
                new RiskLevel(3),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "Echiquier world equity growth",
                new RiskLevel(4),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "Tikehau cross assets",
                new RiskLevel(4),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "ESG Obligation europe",
                new RiskLevel(4),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "Lazard Equity",
                new RiskLevel(5),
                Instant.parse("2022-01-14T09:14:36Z")
            ),
            new Fund(
                "ESG Croissance durable solidaire",
                new RiskLevel(5),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "Sustainable Equity",
                new RiskLevel(6),
                Instant.parse("2023-09-12T12:24:36Z")
            ),
            new Fund(
                "Choix solidaire",
                new RiskLevel(6),
                Instant.parse("2023-09-12T12:24:36Z")
            )
        );
    }
}
