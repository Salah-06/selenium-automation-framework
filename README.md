# SauceDemo Selenium Automation Framework

A Java-based web automation testing framework for the SauceDemo application.

## Technology Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Extent Reports
- Git and GitHub

## Framework Features

- Page Object Model (POM)
- Data-driven testing using TestNG DataProvider
- Reusable BaseTest and utility classes
- Explicit waits
- Automatic screenshots on test failure
- Extent HTML reporting
- Centralized test execution using testng.xml
- Browser configuration using ChromeOptions

## Automated Test Scenarios

1. Valid login
2. Invalid credentials
3. Locked-out user
4. Incorrect password
5. Empty username
6. Empty password
7. Add product to cart
8. End-to-end checkout

## Execution

Prerequisites: Java 21 or compatible newer JDK, Maven and Google Chrome.

Run the following command:

`mvn clean test`

## Reports

- Extent Report: `reports/AutomationReport.html`
- TestNG and Surefire Reports: `target/surefire-reports/`
- Failure Screenshots: `screenshots/`

## Design Principles

The framework uses inheritance, encapsulation, abstraction and reusable components to improve maintainability and reduce code duplication.

## Project Status

Automation practice project with eight implemented test scenarios.