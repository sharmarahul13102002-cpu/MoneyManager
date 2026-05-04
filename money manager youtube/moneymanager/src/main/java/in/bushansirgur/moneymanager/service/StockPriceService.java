package in.bushansirgur.moneymanager.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockPriceService {

    @Value("${alphavantage.api.key}")
    private String apiKey;

    public double getCurrentPrice(String symbol) {
        try {
            String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol="
                    + symbol + "&apikey=" + apiKey;

            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response);
            JsonNode quote = root.path("Global Quote");
            String priceText = quote.path("05. price").asText();

            if (priceText == null || priceText.isEmpty()) {
                return 0.0;
            }

            return Double.parseDouble(priceText);
        } catch (Exception e) {
            return 0.0;
        }
    }
}