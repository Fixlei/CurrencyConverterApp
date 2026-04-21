# Currency Converter App

A simple Java app that converts one currency to another using a public exchange rate API.

## Project Structure

```
CurrencyConverterApp/
├── controller/
│   └── ConverterController.java   (Handles user input/output)
├── service/
│   └── ExchangeRateService.java   (Business logic)
├── model/
│   └── CurrencyRequest.java       (Request data object)
└── util/
    └── ApiClient.java             (Fetches data from API)
```

## Design Highlights

1. **Layered Design** — Controller → Service → ApiClient
2. **Single Responsibility** — Each class does one thing
3. **Easy to Extend** — Just swap ApiClient if you change the data source

## How to Run

Requires **JDK 11 or above**.

```bash
# Compile all files
javac controller/*.java service/*.java model/*.java util/*.java

# Run
java controller.ConverterController
```

## Example

```
=== Currency Converter ===
From currency (e.g. USD): USD
To currency (e.g. EUR): EUR
Amount: 100
100.00 USD = 84.87 EUR
```

## API

Uses free API: https://open.er-api.com (no API key needed).
