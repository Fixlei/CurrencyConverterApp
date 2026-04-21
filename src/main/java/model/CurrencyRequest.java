package model;

/**
 * Data Transfer Object (DTO)
 * Holds the user's conversion request.
 */
public class CurrencyRequest {

  private String fromCurrency;
  private String toCurrency;
  private double amount;

  public CurrencyRequest(String fromCurrency, String toCurrency, double amount) {
    this.fromCurrency = fromCurrency.toUpperCase();
    this.toCurrency = toCurrency.toUpperCase();
    this.amount = amount;
  }

  public String getFromCurrency() {
    return fromCurrency;
  }

  public String getToCurrency() {
    return toCurrency;
  }

  public double getAmount() {
    return amount;
  }
}