package com.virtru.assignment.gmail;

import com.virtru.assignment.util.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsLogin {

    private WebDriver driverobject;

    public DetailsLogin(WebDriver driver) {
        this.driverobject = driver;
    }

    public void enterUserName(String userName) {
        enterTextInElementById("identifierId", userName);
        this.driverobject.findElement(By.id("identifierNext")).click();
    }

    public void enterPassword(String password) {
        enterTextInElementByName("password", password);
        this.driverobject.findElement(By.id("passwordNext")).click();
    }

    public String title() {
        return this.driverobject.getTitle();
    }

    private void enterTextInElementById(String elementId, String text) {
        WebElement idElement = this.driverobject.findElement(By.id(elementId));
        idElement.sendKeys(text);
    }

    private void enterTextInElementByName(String elementName, String text) {
        WebElement idElement = this.driverobject.findElement(By.name(elementName));
        idElement.sendKeys(text);
    }
}
