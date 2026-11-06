# SauceDemo UI Test Automation

UI test automation project for [SauceDemo](https://www.saucedemo.com/), built with **Java 17, Selenide, JUnit 5, and Maven**. The project uses the Page Object pattern, configurable test execution, and Allure reporting integrated with GitHub Actions.

**[View the latest Allure report](https://xvladislavx.github.io/saucedemo-ui-tests/)**

## Tech stack

- **Java 17** — test implementation
- **Selenide** — browser automation and assertions
- **JUnit 5** — test execution and lifecycle
- **Maven / Surefire** — dependency management and test execution
- **Allure** — test steps, results, and reporting
- **GitHub Actions** — CI execution and artifact collection
- **GitHub Pages** — hosting the latest Allure HTML report

## Test coverage

The current suite covers two authentication scenarios:

| Test | Expected behavior |
| --- | --- |
| `successfulLogin` | A standard user logs in and sees the Products page. |
| `loginWithLockedOutUser` | A locked-out user receives the expected error message. |

## Project structure

```text
.github/workflows/
└── ui-tests.yml           # CI execution and Allure report deployment
src/test/
├── java/
│   ├── config/
│   │   └── TestConfig.java # Configuration loading and overrides
│   ├── pages/
│   │   ├── LoginPage.java
│   │   └── ProductsPage.java
│   └── tests/
│       ├── BaseTest.java  # Selenide setup and Allure listener
│       └── LoginTest.java
└── resources/
    ├── config.properties
    └── allure.properties
pom.xml
```

Page Objects encapsulate UI elements and interactions. Tests describe scenarios and assertions, while `TestConfig` centralizes runtime settings.

## Running locally

**Prerequisites:** JDK 17, Maven, and Google Chrome.

Clone the repository and run the tests:

```bash
git clone https://github.com/xVladislavx/saucedemo-ui-tests.git
cd saucedemo-ui-tests
mvn clean test
```

Run Chrome in headless mode (recommended for CI):

```bash
mvn clean test -Dheadless=true
```

In Windows PowerShell, you can quote the property argument:

```powershell
mvn clean test '-Dheadless=true'
```

Default settings are stored in `src/test/resources/config.properties`. Individual values can be overridden using Maven system properties, for example:

```bash
mvn clean test -Dheadless=true -DbrowserSize=1366x768
```

## Reports and CI

The GitHub Actions workflow runs on pushes and pull requests targeting `main`. It:

1. Runs the UI tests with Chrome in headless mode.
2. Uploads Allure raw results and, when applicable, Selenide failure artifacts.
3. Generates and uploads an Allure HTML report.
4. Publishes the latest report to GitHub Pages on pushes to `main` when report generation succeeds.

**[Open the published Allure report](https://xvladislavx.github.io/saucedemo-ui-tests/)**

To inspect results locally, install Allure CLI and run:

```bash
allure serve target/allure-results
```

The project reports both business-level steps and underlying Selenide actions. Password entry is recorded as a separate Allure step without automatically serializing the password as a step parameter; Selenide's sensitive-input option masks it in action logs.

## Planned improvements

- Extend coverage to product catalog, cart, and checkout flows.
- Add broader negative scenarios and data-driven tests.
- Improve test organization as the suite grows.
