package core;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import static core.Utils.isElementPresent;

public class BaseTestSettings {
    @BeforeSuite
    protected void init() {
        Driver.init();
    }

    @BeforeClass
    protected void checkUnLogin() {
        if(true == isElementPresent(By.cssSelector("#exit-link > a"))) {
            Driver.get().findElement(By.cssSelector("#exit-link > a")).click();
            System.out.println("Logout");
        }
    }


    @AfterSuite
    protected void cleanup() {
        Driver.tearDown();
    }
}
