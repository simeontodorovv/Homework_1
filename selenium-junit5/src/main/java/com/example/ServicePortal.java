
package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ServicePortal {

    private WebDriver driver;

    public ServicePortal(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement myProfile() {return driver.findElement(By.xpath("//header[@class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation4 MuiAppBar-root MuiAppBar-colorPrimary MuiAppBar-positionStatic css-101k3ct-MuiPaper-root-MuiAppBar-root']//button[2]"));}
    public WebElement logOut() {return driver.findElement(By.xpath("//li[@role='menuitem']//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-1y3ghvl-MuiTypography-root'][normalize-space()='Logout']"));}

    public void LogOut() {
        myProfile().click();
        logOut().click();
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
