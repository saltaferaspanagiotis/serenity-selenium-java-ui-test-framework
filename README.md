# Serenity BDD – Selenium UI Test Demo Project

A Serenity BDD test automation framework using **Cucumber 7**, **JUnit 5**, **Selenium 4**, and **Spring Boot** for dependency injection. Tests run against the [Test Automation Playground](https://play1.automationcamp.ir/).

---

## Prerequisites

Make sure the following are installed before cloning:

| Tool | Version |
|---|---|
| Java JDK | 21+ |
| Maven | 3.8+ |
| Git | any recent |
| Chrome browser | latest |

No manual WebDriver installation is needed — Selenium Manager handles driver binaries automatically.

---

## Clone the Repository

```bash
git clone https://github.com/saltaferaspanagiotis/serenity-selenium-java-ui-test-framework.git
```

---

## Project Structure

```
src/
├── main/
│   ├── java/demo/bdd/
│   │   ├── actions/         # UI interaction methods (one class per page)
│   │   ├── configuration/   # Spring configuration (SpringConfig, TestConfig)
│   │   ├── enums/           # Enumerations (e.g. FileType)
│   │   ├── locators/        # Web element locators / Page Objects
│   │   ├── questions/       # Assertion helpers (one class per page)
│   │   └── utils/           # Shared utilities (Wait, Element, ScenarioContext, Download)
│   └── resources/
│       ├── application.yml                  # Root config (profile import)
│       └── config/application-test.yml      # Test profile config (URLs, credentials)
└── test/
    ├── java/demo/bdd/
    │   ├── runners/
    │   │   └── TestSuiteRunner.java         # JUnit Platform Suite entry point
    │   └── stepdefinitions/                 # Cucumber step definitions
    └── resources/
        ├── features/                        # Gherkin feature files
        └── serenity.conf                    # WebDriver & environment configuration
```

---

## Configuration

### Spring Profile & Encrypted Credentials

Test properties are loaded from `src/main/resources/config/application-test.yml` via the `test` Spring profile.
Passwords in that file are encrypted with [Jasypt](https://github.com/ulisesbocchio/jasypt-spring-boot). The encryption key must be supplied at runtime.

### Browser / Environment

Supported environments (configured in `src/test/resources/serenity.conf`):

| Value | Browser |
|---|---|
| `chrome` | Google Chrome |
| `firefox` | Mozilla Firefox |

For Chrome, the download directory in `serenity.conf` may need to be updated to match your local path:

```hocon
# serenity.conf – chrome environment
prefs {
  download.default_directory = "C:\\your\\local\\path\\src\\test\\resources\\testdata"
}
```

---

## Running Tests

### From the IDE (IntelliJ / Eclipse)

1. Open `src/test/java/demo/bdd/runners/TestSuiteRunner.java`.
2. Edit the `@ConfigurationParameter` tag filter to target the scenario you want:
   ```java
   @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@YourTag")
   ```
3. Add the following **VM options** in your run configuration:
   ```
   -ea
   -Dspring.profiles.active=test
   -Djasypt.encryptor.password=Tester123
   -Denvironment=chrome
   ```
4. Run `TestSuiteRunner` as a JUnit test.

### From the Command Line (Maven)

```bash
# Run all tests (uses Maven Failsafe)
mvn clean verify \
  -Dspring.profiles.active=test \
  -Djasypt.encryptor.password=Tester123 \
  -Denvironment=chrome

# Run tests filtered by tag
mvn clean verify \
  -Dspring.profiles.active=test \
  -Djasypt.encryptor.password=Tester123 \
  -Denvironment=chrome \
  -Dcucumber.filter.tags="@YourTag"

# Run with a different browser
mvn clean verify \
  -Dspring.profiles.active=test \
  -Djasypt.encryptor.password=Tester123 \
  -Denvironment=firefox
```

> **Note:** `mvn verify` triggers both the `integration-test` and `verify` phases via the Failsafe plugin, which is how Serenity reports are aggregated correctly.

### Parallel Execution

Parallel execution is configured in `src/test/resources/junit-platform.properties`:

```properties
cucumber.execution.parallel.config.strategy=fixed
cucumber.execution.parallel.config.fixed.parallelism=2
cucumber.execution.parallel.config.fixed.max-pool-size=2
```

To **enable** parallel execution, add the following property to that file (or pass it as a system property):

```properties
cucumber.execution.parallel.enabled=true
```

To run with more workers, increase `parallelism` and `max-pool-size` to match the number of available CPU cores. Each parallel worker opens its own browser instance, so make sure your machine can handle the load.

To **disable** parallel execution (e.g. for debugging), either remove that property or set it to `false`.

---

## Test Reports

After a test run, reports are generated at:

```
target/site/serenity/index.html
```

Open that file in a browser to view the full Serenity BDD report, including test results, screenshots, and living documentation.

To regenerate reports manually without re-running tests:

```bash
mvn serenity:aggregate
```

---

## Feature Coverage

| Feature | Tags |
|---|---|
| Forms | `@Forms_*` |
| Frames | `@Frames_*` |
| Mouse Actions | `@MouseActions_*` |
| Keyboard Actions | `@KeyboardActions_*` |
| Popup Windows | `@PopupWindows_*` |
| Wait Conditions | `@WaitConditions_*` |
| Advanced UI | `@AdvancedUI_*` |
| Sample Pages | `@SamplePages_*` |

---

## Key Parameters Reference

| Parameter                     | Description                                 | Example                                   |
|-------------------------------|---------------------------------------------|-------------------------------------------|
| `-Dspring.profiles.active`    | Activates the Spring config profile         | `test`                                    |
| `-Djasypt.encryptor.password` | Decryption key for encrypted credentials    | `Tester123`                               |
| `-Denvironment`               | Browser environment (from `serenity.conf`)  | `chrome`, `firefox`               |
| `-Dcucumber.filter.tags`      | Cucumber tag expression to filter scenarios | `@SamplePages_01`                         |
| `-Dcucumber.execution.parallel.enabled` | Activates parallel execution                | `true`                                    |
