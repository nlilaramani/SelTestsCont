package org.nl.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;


public class ChromeTest {

    WebDriver driver;


    @Before
    public void setup() {
        //driver = new ChromeDriver();
        ChromeOptions options=new ChromeOptions();
        try {
            driver = new RemoteWebDriver(new URL("http://chromeremote:4444"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void test() {
        // Your test logic here

        assertTrue(1==1);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Openshift");
        driver.findElement(By.name("q")).submit();
        String title=driver.getTitle();
        assertTrue(title.contains("Openshift"));
    }

}
