package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) throws Exception {
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/ajax");
        String title= driver.getTitle();
        System.out.println("Title:" +title);
        driver.findElement(By.xpath("//div[@id='ajax-content']/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
        String textfinal=driver.findElement(By.xpath("//div[@id='ajax-content']/h1")).getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
        System.out.println(textfinal);
        String textfinal1=driver.findElement(By.xpath("//div[@id='ajax-content']/h3")).getText();
        System.out.println(textfinal1);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        String textfinal2=driver.findElement(By.xpath("//div[@id='ajax-content']/h3")).getText();
        System.out.println(textfinal2);
        driver.close();
    }
}
