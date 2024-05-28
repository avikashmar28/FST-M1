package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        String title= driver.getTitle();
        System.out.println("Title:" +title);
        driver.findElement(By.id("toggleCheckbox")).click();
        WebElement dynamiccheck=driver.findElement(By.id("dynamicCheckbox"));
        wait.until(ExpectedConditions.invisibilityOf(dynamiccheck));
        boolean b1=dynamiccheck.isDisplayed();
        if(b1==false){
            System.out.println("Checkbox not visible");
        }
        else{
            System.out.println("Checknox is visible");
        }
        driver.findElement(By.id("toggleCheckbox")).click();
        WebElement dynamiccheck1=driver.findElement(By.id("dynamicCheckbox"));
        wait.until(ExpectedConditions.visibilityOf(dynamiccheck1));
        boolean b2=dynamiccheck1.isDisplayed();
        if(b2==true){
            System.out.println("Checkbox is visible");
        }
        driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input")).click();
        //driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/following-sibling::input")).click();
        driver.close();
    }
}
