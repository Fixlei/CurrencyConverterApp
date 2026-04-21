package Service;

import model.CurrencyRequest;
import util.ApiClient;

/**
 * Service - Business Logic Layer
 * Handles currency conversion logic.
 */
public class ExchangeRateService {

  private ApiClient apiClient;

  public ExchangeRateService() {
    this.apiClient = new ApiClient();
  }

  /**
   * Convert an amount from one currency to another.
   */
  public double convert(CurrencyRequest request) throws Exception {
    // Same currency, no conversion needed
    if (request.getFromCurrency().equals(request.getToCurrency())) {
      return request.getAmount();
    }

    double rate = apiClient.getRate(
        request.getFromCurrency(),
        request.getToCurrency()
    );

    return request.getAmount() * rate;
  }
}