package ui_Layer;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserPage extends PageFactorySettings {

    @FindBy(css = "#exit-link > a")
    private WebElement logOutBtn;

    @FindBy(xpath = "//h3[@class='prof-name']")
    private WebElement userName;

    @FindBy(xpath = "//div[text()='Пол']/../div[@class='prof-block-description']")
    private WebElement sexName;



    private WebDriverWait wait = new WebDriverWait(Driver.get(), 35);




    public void clickLogOutBtn(){
        wait.until(ExpectedConditions.visibilityOf(logOutBtn)).click();
    }

    public void checkUserRegister(String expUsername, String expSex) {
//        System.out.println(userName.getText());
        Assert.assertEquals(userName.getText(), expUsername, "UserName was not as expected");
        Assert.assertEquals(sexName.getText(), expSex, "State was not as expected");
        Assert.assertTrue(logOutBtn.isDisplayed());
    }


}
