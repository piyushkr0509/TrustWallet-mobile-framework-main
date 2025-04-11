package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WelcomePage;

public class CreateWalletTest extends BaseTest {

    @Test
    public void testFullCreateWalletFlow() {
        WelcomePage welcomePage = new WelcomePage();

        welcomePage.clickCreateWalletButton();
        welcomePage.enterPasscode("123456");
        welcomePage.selectSecretPhraseWallet();
        welcomePage.confirmSeedPhraseBackup();
        Assert.assertTrue(welcomePage.isDashboardVisible(), "Dashboard is not visible after wallet creation.");
        System.out.println("✅ Wallet created and dashboard is visible.");
    }
}