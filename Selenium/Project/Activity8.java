package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
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
    public void applyleave(){
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Apply Leave"))).click();
        WebElement drop1=wait.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_txtLeaveType")));
        Select selectdrop=new Select(drop1);
        selectdrop.selectByIndex(1);

        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("applyleave_txtFromDate"))).sendKeys("2022-04-14");
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("applyleave_txtToDate"))).sendKeys("2022-04-16", Keys.TAB);




        WebElement drop2=wait.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_partialDays")));
        Select drop2select=new Select(drop2);
        drop2select.selectByIndex(1);


        WebElement drop5=wait.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_firstDuration_duration")));
        Select drop5select=new Select(drop5);
        drop5select.selectByIndex(1);


        WebElement drop3=wait.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_firstDuration_time_from")));
        Select drop3select=new Select(drop3);
        drop3select.selectByValue("09:00");


        WebElement drop4=wait.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_firstDuration_time_to")));
        Select drop4select=new Select(drop4);
        drop4select.selectByValue("15:00");



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("applyleave_txtComment"))).sendKeys("Leave Applied");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("applyBtn"))).click();
    }
    @Test(priority = 4)
    public void leaveapproval(){
        String Approvalstatus=driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText();
        System.out.println("Approval status is:" +Approvalstatus);
    }
    @AfterClass
    public void closebrowser(){
        driver.close();
    }
}
