package in.bushansirgur.moneymanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvestmentResponseDTO {
    private String symbol;
    private String companyName;
    private String sector;
    private double price;
    private String riskLevel;
    private String reason;
    private int quantity;
}