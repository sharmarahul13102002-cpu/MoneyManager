package in.bushansirgur.moneymanager.controller;

import in.bushansirgur.moneymanager.dto.InvestmentRequestDTO;
import in.bushansirgur.moneymanager.service.InvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/investment")
@RequiredArgsConstructor
public class InvestmentController {

    private final InvestmentService investmentService;

    @PostMapping("/suggestions")
    public Object getSuggestions(@RequestBody InvestmentRequestDTO request) {
        return investmentService.getSuggestions(request);
    }
}
