
package pageTest;

import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;


public class AppiumTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.6.4");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName", "huawei-ho_u19-TSTCIFBE9SZH49DA");
        capabilities.setCapability("appPackage", "com.google.android.gm");
        capabilities.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @Test(priority = 0)
    public void testToSwichAccountAndRevertIt(){
        HomePage hp=new HomePage(driver);
        hp.waitForVisibilityOf(hp.gotItButton);
        hp.gotItButton.click();
        hp.takeMeToGmail.click();
        hp.homeIcon.click();
        hp.waitForVisibilityOf(hp.inbox);
        hp.accountSwitch.click();
        hp.waitForVisibilityOf(hp.dahal1Account);
        hp.dahal1Account.click();
        hp.waitForVisibilityOf(hp.searchIcon);
        hp.homeIcon.click();
        hp.accountSwitch.click();
        hp.dahal57Account.click();
    }
    
    @Test(priority = 1)
    public void testToComposeEmail(){
        try {
            HomePage hp=new HomePage(driver);
            hp.waitForVisibilityOf(hp.gotItButton);
            hp.gotItButton.click();
            hp.takeMeToGmail.click();
            hp.composeEmailButton.click();
            hp.waitForVisibilityOf(hp.sendButton);
            hp.toTextArea.sendKeys("john.concessao@gmail.com");
            hp.subjectTextArea.sendKeys("Hello from the Automation Side!!!");
            hp.contentTextArea.sendKeys("My Name is John");
            hp.sendButton.click();
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AppiumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
