package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {
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
    public void myinfoedit(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_txtEmpFirstName"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_txtEmpFirstName"))).sendKeys("Avik");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_txtEmpLastName"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_txtEmpLastName"))).sendKeys("Ash");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_optGender_1"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_DOB"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_DOB"))).sendKeys("1993-06-28");
        WebElement dropdown=driver.findElement(By.id("personal_cmbNation"));
        Select singleSelect = new Select(dropdown);
        singleSelect.selectByVisibleText("French");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave"))).click();

    }
    @AfterClass
    public void closebrowser(){
        driver.close();
    }
}
