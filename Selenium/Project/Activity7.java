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

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void opensite() {
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
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
    public void clickqualification(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails"))).click();
        WebElement clicklink=driver.findElement(By.linkText("Qualifications"));
        clicklink.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addWorkExperience"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("experience_employer"))).sendKeys("IBM");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("experience_jobtitle"))).sendKeys("Test Engineer");
        driver.findElement(By.id("experience_from_date")).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("experience_from_date"))).sendKeys("2022-04-14");
        driver.findElement(By.id("experience_to_date")).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("experience_to_date"))).sendKeys("2024-02-02");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("experience_comments"))).sendKeys("Work Experience Added");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnWorkExpSave"))).click();

    }
    @AfterClass
    public void closebrowser(){
        driver.close();
    }
}
