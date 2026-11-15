
package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AppTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:5173");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TitleAndLoginButtonTest() {

        LoginPage loginPage = new LoginPage(driver);
        assertEquals("City Services Portal", loginPage.getTitle());
        assertEquals("Login", loginPage.loginButton().getText());

    }

    @Test
    public void verifyAllRoles() {

        LoginPage loginPage = new LoginPage(driver);
        ServicePortal servicePortal = new ServicePortal(driver);

        for (int i = 0; i < 5; i++) {
            loginPage.roleButton(i).click();
            loginPage.Login();
            assertTrue(servicePortal.myProfile().isDisplayed());
            servicePortal.LogOut();
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
