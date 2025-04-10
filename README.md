# Sample Mobile Framework

A mobile automation testing framework built with Appium, Selenium, and TestNG for Android applications.

## Prerequisites

- Java 8 or higher
- Maven 3.6 or higher
- Android SDK
- Appium Server 2.0 or higher
- Android device or emulator

## Setup

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/sample-mobile-framework.git
   cd sample-mobile-framework
   ```

2. Install dependencies:
   ```
   mvn clean install
   ```

3. Start Appium server:
   ```
   appium
   ```

4. Connect an Android device or start an emulator

## Project Structure

- `src/main/java/pages/` - Page object classes
- `src/main/java/utils/` - Utility classes including driver setup
- `src/test/java/tests/` - Test classes
- `src/test/resources/` - Test configuration files

## Running Tests

Execute all tests:
```
mvn test
```

Run a specific test class:
```
mvn test -Dtest=CreateWalletTest
```

## Configuration

The framework is configured to test the Trust Wallet application. To test a different app, update the capabilities in `DriverUtils.java`:

```java
capabilities.setCapability("appPackage", "com.wallet.crypto.trustapp");
capabilities.setCapability("appActivity", "com.wallet.crypto.trustapp.ui.app.AppActivity");
```

## Dependencies

- Selenium: 4.11.0
- Appium Java Client: 8.3.0
- TestNG: 7.8.0
- Commons IO: 2.7

## License

MIT