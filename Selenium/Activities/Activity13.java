package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity13 {
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
        List<WebElement> data1 =driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[3]/td"));
        for(WebElement cell:data1){
            System.out.println(cell.getText());
        }
        WebElement data2 =driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println(data2.getText());
        driver.close();

    }
}
