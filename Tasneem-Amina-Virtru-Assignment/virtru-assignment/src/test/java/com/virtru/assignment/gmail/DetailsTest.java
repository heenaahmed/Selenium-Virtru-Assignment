package com.virtru.assignment.gmail;

import com.virtru.assignment.util.DriverUtils;
import com.virtru.assignment.virtru.Login;
import com.virtru.assignment.virtru.Virtru;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DetailsTest {

    private WebDriver driverobject;

    @Before
    public void login() throws Exception {
        this.driverobject = DriverUtils.getDriver();
        this.driverobject.get("http://www.gmail.com");
    }

    @Test
    public void deatils() throws Exception {
        DetailsLogin loginDetails = new DetailsLogin(this.driverobject);
        loginDetails.enterUserName("tasneemsmileforever");
        loginDetails.enterPassword("............");

        GmailInbox emailFrom = new GmailInbox(this.driverobject);
        emailFrom.clickOnFirstEmailFrom("kjc varun");

        UnlockVirtru virtruEmail = new UnlockVirtru(this.driverobject);
        virtruEmail.clickOnUnlockLink();

        ArrayList<String> windowtab = new ArrayList<String>(driverobject.getWindowHandles());
        driverobject.switchTo().window(windowtab.get(1));

        Login virtruLoginPage = new Login(this.driverobject);
        virtruLoginPage.loginWithEmail("tasneemsmileforever@gmail.com@gmail.com");
        virtruLoginPage.clickOnSendMeEmail();

        Thread.sleep(1000);

        this.driverobject.switchTo().window(windowtab.get(0));

        this.driverobject.get("https://mail.google.com/mail/u/0/#inbox");
        this.driverobject.navigate().refresh();
        Thread.sleep(1000);

        emailFrom = new GmailInbox(this.driverobject);
        Thread.sleep(1000);
        emailFrom.clickOnFirstEmailFrom("verify@virtru.com");

        virtruEmail = new UnlockVirtru(this.driverobject);
        virtruEmail.clickOnVerifyMeLink();

        windowtab = new ArrayList<String>(driverobject.getWindowHandles());
        this.driverobject.switchTo().window(windowtab.get(2));

        Virtru verifyPage = new Virtru(this.driverobject);
        Thread.sleep(1000);

        assertEquals("Virtru Assignment", verifyPage.getSubject());
        assertEquals("Sample message", verifyPage.getBody());
    }

    @After
    public void closeBrowser() throws Exception {
        this.driverobject.close();
    }
}