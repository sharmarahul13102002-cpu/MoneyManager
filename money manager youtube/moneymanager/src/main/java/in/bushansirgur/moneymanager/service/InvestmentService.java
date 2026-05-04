package in.bushansirgur.moneymanager.service;

import in.bushansirgur.moneymanager.dto.InvestmentRequestDTO;
import in.bushansirgur.moneymanager.dto.InvestmentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InvestmentService {

    private final DashboardService dashboardService;

    public Object getSuggestions(InvestmentRequestDTO request) {

        Map<String, Object> dashboardData = dashboardService.getDashboardData();
        double balance = 0.0;

        if (dashboardData.get("totalBalance") != null) {
            balance = Double.parseDouble(dashboardData.get("totalBalance").toString());
        }

        if (balance <= 0) {
            return Map.of("message", "No available balance for investment");
        }

        List<InvestmentResponseDTO> list = new ArrayList<>();

        if ("LOW".equalsIgnoreCase(request.getRiskLevel())) {

            list.add(build("TCS", "Tata Consultancy Services", "IT", 4000, "LOW", "Stable large-cap company", balance));
            list.add(build("HDFCBANK", "HDFC Bank", "Banking", 1500, "LOW", "Consistent and reliable stock", balance));
            list.add(build("INFY", "Infosys", "IT", 1450, "LOW", "Strong IT sector presence", balance));
            list.add(build("ITC", "ITC Limited", "Consumer Goods", 430, "LOW", "Stable dividend paying company", balance));
            list.add(build("HINDUNILVR", "Hindustan Unilever", "FMCG", 2500, "LOW", "Strong consumer brand", balance));
            list.add(build("NESTLEIND", "Nestle India", "FMCG", 2400, "LOW", "Defensive quality stock", balance));
            list.add(build("ASIANPAINT", "Asian Paints", "Paints", 3000, "LOW", "Market leader in paints", balance));
            list.add(build("SUNPHARMA", "Sun Pharma", "Pharma", 1600, "LOW", "Stable pharmaceutical company", balance));

        } else if ("MEDIUM".equalsIgnoreCase(request.getRiskLevel())) {

            list.add(build("INFY", "Infosys", "IT", 1500, "MEDIUM", "Balanced growth opportunity", balance));
            list.add(build("ICICIBANK", "ICICI Bank", "Banking", 1000, "MEDIUM", "Moderate risk with good return potential", balance));
            list.add(build("LT", "Larsen & Toubro", "Infrastructure", 3600, "MEDIUM", "Strong engineering company", balance));
            list.add(build("MARUTI", "Maruti Suzuki", "Automobile", 12500, "MEDIUM", "Strong automobile brand", balance));
            list.add(build("TATAMOTORS", "Tata Motors", "Automobile", 980, "MEDIUM", "Balanced growth in EV space", balance));
            list.add(build("AXISBANK", "Axis Bank", "Banking", 1150, "MEDIUM", "Good growth with moderate risk", balance));
            list.add(build("BAJFINANCE", "Bajaj Finance", "Finance", 7200, "MEDIUM", "High quality financial company", balance));
            list.add(build("ULTRACEMCO", "UltraTech Cement", "Cement", 11000, "MEDIUM", "Stable with sector growth", balance));

        } else if ("HIGH".equalsIgnoreCase(request.getRiskLevel())) {

            list.add(build("ZOMATO", "Zomato", "Tech", 200, "HIGH", "High growth but volatile", balance));
            list.add(build("PAYTM", "Paytm", "Fintech", 800, "HIGH", "Risky stock with high return potential", balance));
            list.add(build("NYKAA", "Nykaa", "E-Commerce", 190, "HIGH", "Consumer growth company", balance));
            list.add(build("OLA", "Ola Electric", "EV", 120, "HIGH", "Aggressive EV sector play", balance));
            list.add(build("IREDA", "IREDA", "Renewable Finance", 180, "HIGH", "High momentum government-linked stock", balance));
            list.add(build("RVNL", "Rail Vikas Nigam", "Railways", 390, "HIGH", "High movement PSU stock", balance));
            list.add(build("SUZLON", "Suzlon Energy", "Renewable Energy", 55, "HIGH", "Cheap but volatile energy stock", balance));
            list.add(build("YESBANK", "Yes Bank", "Banking", 28, "HIGH", "Very risky turnaround play", balance));

        } else {
            return Map.of("message", "Invalid risk level. Please choose LOW, MEDIUM, or HIGH");
        }

        return list;
    }

    private InvestmentResponseDTO build(String symbol,
                                        String companyName,
                                        String sector,
                                        double price,
                                        String riskLevel,
                                        String reason,
                                        double balance) {

        int quantity = (int) (balance / price);

        return InvestmentResponseDTO.builder()
                .symbol(symbol)
                .companyName(companyName)
                .sector(sector)
                .price(price)
                .riskLevel(riskLevel)
                .reason(reason)
                .quantity(quantity)
                .build();
    }
}