package com.virtru.assignment.virtru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Virtru {

    private WebDriver driverobject;

    public Virtru(WebDriver driver) {
        this.driverobject = driver;
    }

    public String getSubject() {
        WebElement subjectElement = this.driverobject.findElement(By.className("subject"));
        return subjectElement.getText();
    }

    public String getBody() {
        WebElement subjectElement = this.driverobject.findElement(By.className("tdf-body"));
        return subjectElement.getText();
    }
}
