# Assignment Task: Selenium 101
This project automates three scenarios using **Java**, **Selenium**, and **TestNG**. The structure is organized into separate packages for scenarios, locators, and hooks, with an XML file for execution.

## Project Structure

- **src/main/java**  
  - **scenarios**: This package contains the test scenarios that are automated using TestNG.  
  - **locators**: This package holds the locators for the elements found in the web application under test.  
  - **hooks**: This package is responsible for the setup and teardown of the browser, including initializing the WebDriver and managing browser sessions.

## Technologies Used

- **Java**  
- **Selenium WebDriver**  
- **TestNG**

## Packages

1. **Scenarios**  
   This package contains the following test scenarios:
   - `Scenario1`: Automates the first feature.
   - `Scenario2`: Automates the second feature.
   - `Scenario3`: Automates the third feature.

2. **Locators**  
   The locators are stored separately for easy maintenance and reusability.

3. **Hooks**  
   The hooks package includes the browser setup and teardown logic. The `BeforeTest` and `AfterTest` methods ensure that the browser starts and closes correctly during test execution.

