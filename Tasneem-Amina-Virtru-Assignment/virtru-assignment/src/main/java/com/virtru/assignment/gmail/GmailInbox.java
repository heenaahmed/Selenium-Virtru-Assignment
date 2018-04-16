package com.virtru.assignment.gmail;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GmailInbox {

    private WebDriver driverobject;

    public GmailInbox(WebDriver driver) {
        this.driverobject = driver;
    }

    public void clickOnFirstEmail() {
        List<WebElement> unreadEmails = driverobject.findElements(By.xpath("//*[@class='zF']"));
//        List<WebElement> elements2 = driver.findElements(By.xpath("//*[@class='zA yO']"));
        unreadEmails.get(0).click();
    }

    public void clickOnFirstEmailWithText(final String query) {
        List<WebElement> unreadEmails = driverobject.findElements(By.xpath("//*[@class='zF']"));
        List<WebElement> unreadEmailsWithText = ImmutableList.copyOf(Iterables.filter(unreadEmails, new Predicate<WebElement>() {
            public boolean apply(WebElement webElement) {
                return webElement.getText().contains(query);    //*[@id="content"]/div/div/div/div[3]/a[2]/div/span
                
            }
        }));
        unreadEmailsWithText.get(0).click();
    }

    public void clickOnFirstEmailFrom(final String fromEmail) {
        List<WebElement> unreadEmails = driverobject.findElements(By.xpath("//*[@class='zF']"));
        List<WebElement> unreadEmailsWithText = ImmutableList.copyOf(Iterables.filter(unreadEmails, new Predicate<WebElement>() {
            public boolean apply(WebElement webElement) {
                return webElement.getText().contains(fromEmail);
            }
        }));
//        List<WebElement> unreadEmailsWithText = unreadEmails.stream().filter(email -> email.getText().contains(query)).collect(Collectors.toList());
        unreadEmailsWithText.get(0).click();
    }

    public void refreshInbox() {
        this.driverobject.get("https://mail.google.com/mail/u/0/#inbox");
        this.driverobject.navigate().refresh();
    }
}
