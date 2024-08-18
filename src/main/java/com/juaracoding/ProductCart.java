package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ProductCart {
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

        //ambil text nama product
        String productName = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Fleece Jacket']")).getText();
        System.out.println(productName);
        delay(1);//delay selama 1 detik

        //click pada button Add to cart
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        System.out.println("1 product in cart");
        delay(1);//delay selama 1 detik

        //menambahkan product to cart
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
        String totalProduct = driver.findElement(By.xpath("//div[@class='cart_quantity']")).getText();
        String expectedTotal = "1";

        //assert if untuk validasi jika jumlah product yang ditambahkan sesuai
        customAssertEquals(totalProduct,expectedTotal);
        System.out.println("produk berhasil ditambahkan");
        delay(1);//delay selama 1 detik



        //Close Browser
        driver.quit();
        System.out.println("Close Browser");
    }
    public static void delay(long detik) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void customAssertEquals(String actual, String expexted){
        System.out.println("Test Result");
        if (actual.equals(expexted)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}
