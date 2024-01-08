# eBanking Automation Project

## Overview

This project is an automation framework for an eBanking application. It includes test cases for user login, adding new customers, and data-driven testing for login functionality. The framework uses Selenium WebDriver, TestNG, Apache POI for Excel operations, and Maven as the build tool.

## Project Structure

The project is structured as follows:

- **ebanking.pageobjects**: Contains Page Object classes for different pages in the application.
- **ebanking.testcases**: Contains TestNG test cases for various functionalities.
- **ebanking.utilities**: Includes utility classes for reading configuration, working with Excel, and a base class for setting up and tearing down the WebDriver.

## Dependencies

- Java
- Selenium WebDriver
- TestNG
- Apache POI
- Maven

## Setup

1. **Clone the Repository:**
   git clone <https://github.com/ahmedmahddi/ebankingV1>
--------------------------------------------------------
1-Configure WebDriver:

Download the appropriate WebDriver executable (e.g., ChromeDriver) and update the chromepath in the config.properties file.
Configure Project:
2-Configure Project:

Update the config.properties file in the Configuration folder with the correct application URL, username, password, and WebDriver path.
Run Tests:
3-Run Tests:

Execute the tests using the following Maven command:
mvn clean test
Additional Information
Configuration File:

config.properties: Contains configuration details such as the application URL, username, password, and WebDriver path.
Test Data:

Test data for data-driven testing is provided in an Excel file located at testData/LoginData.xlsx.
Extensions:

The project includes a Chrome extension (ublock.crx) configured in the Baseclass for additional browser capabilities.
Contributors
[Ahmed Mahdi]


