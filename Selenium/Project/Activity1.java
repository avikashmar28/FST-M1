package projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeClass
    public void opensite(){
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void gettitle(){
        String title=driver.getTitle();
        System.out.println(title);
        if(title.equalsIgnoreCase("OrangeHRM")){
            driver.close();
        }
    }

}
