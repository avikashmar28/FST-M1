package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/tables");
        String title= driver.getTitle();
        System.out.println("Title:" +title);
        List<WebElement> number_of_cols =driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        System.out.println(number_of_cols.size());
        List<WebElement> number_of_rows =driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println(number_of_rows.size());
        WebElement data_value1 =driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println(data_value1.getText());
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th")).click();
        System.out.println("After Sort");
        WebElement data_value2 =driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println(data_value2.getText());
        List<WebElement> data2=driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        for(WebElement cell1:data2){
            System.out.println(cell1.getText());
        }

    }
}
