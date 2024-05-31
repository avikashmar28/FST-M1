package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        String title= driver.getTitle();
        System.out.println("Title:" +title);
        boolean b1=driver.findElement(By.id("input-text")).isEnabled();
        if(b1==false){
            System.out.println(b1);

        }
        driver.findElement(By.id("toggleInput")).click();
        boolean b2=driver.findElement(By.id("input-text")).isEnabled();
        System.out.println(b2);

    }
}
