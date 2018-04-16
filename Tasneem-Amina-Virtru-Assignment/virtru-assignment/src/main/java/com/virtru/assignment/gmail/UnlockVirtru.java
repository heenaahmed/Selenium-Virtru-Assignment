
//Submitted by Tasneem Amina
//Virtru Assignment

package com.virtru.assignment.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UnlockVirtru {

    private WebDriver driverobject;

    public UnlockVirtru(WebDriver driver) {
        this.driverobject = driver;
    }

    
    //Virtru Assignment Submssion
    public void clickOnUnlockLink() {
        WebElement unlockLink = this.driverobject.findElement(By.linkText("Unlock Message"));
        unlockLink.click();
    }

    public void clickOnVerifyMeLink() {
        List<WebElement> expandEmailLinks = this.driverobject.findElements(By.cssSelector("[data-tooltip~=content]"));
    	//List<WebElement> expandEmailLinks = this.driver.findElements(By.cssSelector("//*[@id='content']/div/div/div/div[3]/a[2]/div/span"));
    	//List<WebElement> expandEmailLinks = (List<WebElement>) this.driver.findElements(By.xpath("//*[@id='content']/div/div/div/div[3]/a[2]/div/span"));
        expandEmailLinks.get(0).click();
        WebElement unlockLink = this.driverobject.findElement(By.linkText("VERIFY ME"));
        unlockLink.click();
    }
}
