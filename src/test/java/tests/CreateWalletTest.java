package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WelcomePage;

public class CreateWalletTest extends BaseTest {

    @Test(description = "Test Create Wallet Flow")
    public void testCreateWalletFlow() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage();

        Assert.assertTrue(welcomePage.isCreateWalletButtonVisible(), "Create Wallet button is not visible");
        welcomePage.clickCreateWalletButton();

        System.out.println("Clicked on Create Wallet button successfully.");
    }
}