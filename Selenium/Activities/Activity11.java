package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        String title= driver.getTitle();
        System.out.println("Title:" +title);
        boolean checkboxvisi=driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
        System.out.println(checkboxvisi);
        if(checkboxvisi==false){
            driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        }
        boolean checkboxvisi1=driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
        System.out.println(checkboxvisi1);
        driver.close();
    }
}
