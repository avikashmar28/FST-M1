package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity1 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://v1.training-support.net/");
        String title= driver.getTitle();
        System.out.println("Title:" +title);
        WebElement web1=driver.findElement(By.id("about-link"));
        web1.click();
        String title1=driver.getTitle();
        System.out.println("Title:" +title1);
        driver.close();
    }
}
