package controller;

import Service.ExchangeRateService;
import java.util.Scanner;
import model.CurrencyRequest;

/**
 * Controller - Presentation Layer
 * Handles user input and output.
 */
public class ConverterController {

  private ExchangeRateService service;

  public ConverterController() {
    this.service = new ExchangeRateService();
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=== Currency Converter ===");
    System.out.print("From currency (e.g. USD): ");
    String from = scanner.nextLine();

    System.out.print("To currency (e.g. EUR): ");
    String to = scanner.nextLine();

    System.out.print("Amount: ");
    double amount = Double.parseDouble(scanner.nextLine());

    try {
      CurrencyRequest request = new CurrencyRequest(from, to, amount);
      double result = service.convert(request);

      System.out.printf("%.2f %s = %.2f %s%n",
          amount, from.toUpperCase(),
          result, to.toUpperCase());
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }

    scanner.close();
  }

  public static void main(String[] args) {
    new ConverterController().run();
  }
}