package util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * API Client - Data Layer
 * Fetches exchange rate data from a public API.
 */
public class ApiClient {

  private static final String API_URL = "https://open.er-api.com/v6/latest/";

  /**
   * Get the exchange rate from one currency to another.
   */
  public double getRate(String fromCurrency, String toCurrency) throws Exception {
    String url = API_URL + fromCurrency;

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();

    HttpResponse<String> response = client.send(
        request, HttpResponse.BodyHandlers.ofString());

    String body = response.body();

    // Simple JSON parsing (find the target currency rate)
    String key = "\"" + toCurrency + "\":";
    int index = body.indexOf(key);
    if (index == -1) {
      throw new RuntimeException("Currency not found: " + toCurrency);
    }

    int start = index + key.length();
    int end = body.indexOf(",", start);
    if (end == -1) end = body.indexOf("}", start);

    String rateStr = body.substring(start, end).trim();
    return Double.parseDouble(rateStr);
  }
}