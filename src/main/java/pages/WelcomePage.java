package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Create new wallet\")")
    private WebElement createWalletButton;

    public void clickCreateWalletButton() {
        wait.until(driver -> createWalletButton.isDisplayed());
        createWalletButton.click();
    
    
    }

    public boolean isCreateWalletButtonVisible() {
        try {
            return createWalletButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}