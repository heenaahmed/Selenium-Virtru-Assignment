package com.virtru.assignment.virtru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void loginWithEmail(String email) {
        WebElement emailLink = this.driver.findElement(By.xpath("//*[@id='content']/div/div/div/div[3]/a[1]/div/span"));
        emailLink.click();
    }

    public void clickOnSendMeEmail() {
        WebElement sendMeAnEmail = this.driver.findElement(By.className("sendEmailButton"));
        sendMeAnEmail.click();
    }
}
