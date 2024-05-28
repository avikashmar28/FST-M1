package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        String thirdheadertext=driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("3rd Header:" +thirdheadertext);
        String fifthheadercolor=driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
        //String fifthheadercolor=driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color");
        System.out.println("5th header color:" +fifthheadercolor);
        String greybuttontext=driver.findElement(By.xpath("//button[@class='ui grey button']")).getText();
        System.out.println("Grey Button text:" +greybuttontext);
        String violetbuttonclass=driver.findElement(By.xpath("//button[@class='ui violet button']")).getAttribute("class");
        System.out.println("Violet button class Name:" +violetbuttonclass);
        driver.close();
    }
}
