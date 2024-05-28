package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/login-form");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@class='ui button']")).click();
        String text=driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
        System.out.println("Message: " +text);
        driver.quit();
    }
}
