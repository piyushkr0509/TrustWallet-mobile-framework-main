package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class WelcomePage extends BasePage {

    // Step 1: Welcome screen
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Create new wallet\")")
    private WebElement createWalletBtn;

    // Step 2: Wallet type selection
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Secret phrase\")")
    private WebElement secretPhraseOption;

    // Step 3: Confirm seed phrase (Continue)
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Continue\")")
    private WebElement continueBtn;

    // Step 4: Dashboard verification
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Wallet\")")
    private WebElement dashboardHeader;

    public void clickCreateWalletButton() {
        wait.until(driver -> createWalletBtn.isDisplayed());
        createWalletBtn.click();
    }

    public void enterPasscode(String passcode) {
        Map<Character, AndroidKey> keyMap = new HashMap<>();
        keyMap.put('0', AndroidKey.DIGIT_0);
        keyMap.put('1', AndroidKey.DIGIT_1);
        keyMap.put('2', AndroidKey.DIGIT_2);
        keyMap.put('3', AndroidKey.DIGIT_3);
        keyMap.put('4', AndroidKey.DIGIT_4);
        keyMap.put('5', AndroidKey.DIGIT_5);
        keyMap.put('6', AndroidKey.DIGIT_6);
        keyMap.put('7', AndroidKey.DIGIT_7);
        keyMap.put('8', AndroidKey.DIGIT_8);
        keyMap.put('9', AndroidKey.DIGIT_9);

        for (char digit : passcode.toCharArray()) {
            if (keyMap.containsKey(digit)) {
                ((AndroidDriver) driver).pressKey(new KeyEvent(keyMap.get(digit)));
            }
        }
    }

    public void selectSecretPhraseWallet() {
        wait.until(driver -> secretPhraseOption.isDisplayed());
        secretPhraseOption.click();
    }

    public void confirmSeedPhraseBackup() {
        wait.until(driver -> continueBtn.isDisplayed());
        continueBtn.click();
    }

    public boolean isDashboardVisible() {
        try {
            wait.until(driver -> dashboardHeader.isDisplayed());
            return dashboardHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}