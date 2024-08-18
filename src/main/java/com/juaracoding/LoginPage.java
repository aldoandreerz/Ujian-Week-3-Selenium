package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");

        //Web Title
        String webTitle = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        System.out.println(webTitle);
        delay(1);//delay selama 1 detik

        //Web Scrapping
        WebElement logoIcon = driver.findElement(By.xpath("//div[@class='login_logo']"));
        System.out.println(logoIcon.isDisplayed());
        delay(1); //delay selama 1 detik

        //input username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        delay(1);//delay selama 1 detik

        //input password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        delay(1);//delay selama 1 detik

        //click login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        System.out.println("Login Success");
        delay(2);//delay selama 2 detik

        //ambil text pada app logo setelah login
        String txtApp = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        String txtExpected = "Swag Labs";

        //assert if untuk validasi jika login telah berhasil
        customAssertEquals(txtApp,txtExpected);
        System.out.println("Scenario Login Berhasil di Test");
        delay(2);//delay selama 2 detik





        //Close Browser
        driver.quit();
        System.out.println("Close Browser");

    }
    //function delay
    public static void delay(long detik) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //function assert equals menggunakan if
    public static void customAssertEquals(String actual, String expexted){
        System.out.println("Test Result");
        if (actual.equals(expexted)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}
