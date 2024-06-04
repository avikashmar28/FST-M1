package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void opensite(){
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().window().maximize();
    }
    @Test
    public void getimageurl(){
        String imageURL=driver.findElement(By.xpath("//div[@id='divLogo']/img")).getAttribute("src").toString();
        System.out.println(imageURL);

    }
    @AfterClass
    public void closebrowser(){
        driver.close();
    }
}
