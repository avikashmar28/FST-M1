package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void opensite() {
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void login(){
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }
    @Test(priority = 2)
    public void homepagetitle(){
        String title=driver.getTitle();
        System.out.println("Title:" +title);

    }
    @Test(priority = 3)
    public void myinfo(){
        int count=0;
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Emergency Contacts"))).click();
        List<WebElement> contacts=driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println(contacts.size());
        //List<WebElement> contacts=driver.findElements(By.xpath("//table[@id="emgcontact_list"]/thead/tr/"));
        List<WebElement> cells=driver.findElements(By.xpath("//table/tbody/tr/td[5]"));
        for(WebElement web:contacts){
            System.out.println("Mobile numbers are:" +cells.get(count).getText());
            count++;
        }
    }
    @AfterClass
    public void closebrowser(){
        driver.close();
    }
}
