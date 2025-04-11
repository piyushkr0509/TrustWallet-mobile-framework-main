
# 📱 Sample Mobile Automation Framework – Trust Wallet Flow

This is a test automation framework built using **Appium + Java + TestNG** to automate the Trust Wallet mobile app's "Create Wallet" flow.

---

## ✅ Features

- Automates full wallet creation flow:
  - Clicks "Create New Wallet"
  - Enters 6-digit passcode
  - Selects wallet type (Secret Phrase)
  - Mocks seed phrase confirmation
  - Verifies successful navigation to Dashboard
- Built with **Page Object Model (POM)** design pattern
- Uses **@AndroidFindBy** for clean and readable element management
- Compatible with **TestNG** for scalable test execution
- Supports real devices and emulators via Appium

---

## 🧠 Algorithm Used in the Framework

### 1. Page Object Model (POM)
Each screen of the app is abstracted into a class with elements and user actions:
- WelcomePage
- Passcode entry (via `driver.pressKey()`)
- Wallet type selection
- Seed phrase confirmation
- Dashboard assertion

This encapsulates UI logic and separates it from test logic.

### 2. Flow Control
- **Sequential user simulation** of each screen interaction
- Assertions after major steps for validation
- Retry/wait logic using WebDriverWait for reliable execution

---

## 📂 Folder Structure

```
src
├── main
│   └── java
│       └── pages         # Page classes with @AndroidFindBy
│       └── utils         # Driver management (DriverUtils)
├── test
│   └── java
│       └── tests         # TestNG test classes
```

---

## ⚙️ Setup Instructions

### 1. Install Dependencies
Make sure you have:
- Java 11+
- Maven
- Appium server (CLI or Appium Desktop)
- Android Emulator or Device with Trust Wallet installed

### 2. Start Appium Server
```bash
appium server -p 4725 -a 127.0.0.1 -pa /wd/hub
```

### 3. Run Tests
```bash
mvn clean test
```

---

## 🧪 Test Case Automated

| TC ID  | Description                              |
|--------|------------------------------------------|
| TC001  | Full Create Wallet flow with passcode    |
| TC002  | Validate Dashboard appears post-creation |

---

## 🧑‍💻 Author

Created by a QA Engineer using Appium Java Client `8.x` and TestNG.

---

## 📌 Notes

- Appium inspector may fail on some screens (secure flag) – handled with key events.
- Designed for extendibility (e.g., Face ID, Notifications, Import Wallet)


---

## 🔧 App Launch Configuration

This framework uses **Appium Desired Capabilities** to launch the app directly using the app’s **package** and **main activity** instead of reinstalling an APK every time.

### ✍️ To change the app package or activity:
Go to `DriverUtils.java` and update:

```java
capabilities.setCapability("appPackage", "com.wallet.crypto.trustapp");
capabilities.setCapability("appActivity", "com.wallet.crypto.trustapp.ui.app.AppActivity");
```

You can find these values using:
```bash
adb shell dumpsys window | grep -E 'mCurrentFocus|mFocusedApp'
```

---

## 📱 Changing Device or OS Version

To run tests on a different **Android version** or emulator/device:

1. Connect your physical device or start an emulator:
   ```bash
   emulator -avd Pixel_API_33
   ```

2. In `DriverUtils.java`, update:
```java
capabilities.setCapability("deviceName", "emulator-5554"); // or actual device name
capabilities.setCapability("platformVersion", "13"); // or your device's OS version
```

3. To list devices:
```bash
adb devices
```

---

## 🧪 Emulator vs Real Device

| Property        | Emulator                      | Real Device                      |
|----------------|-------------------------------|----------------------------------|
| deviceName      | `emulator-5554`                | `Pixel_6`, `Samsung_Galaxy` etc. |
| platformVersion | `13` or `14`                   | Match your real device version   |
| Notes           | Ideal for CI or dry runs       | Required for biometric flows     |

