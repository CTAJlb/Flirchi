package ui_Layer.blocks;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui_Layer.PageFactorySettings;


public class PersonState extends PageFactorySettings {

    /** 1-е окно выбора пола*/

    /** Кнопка "Девушки"*/
    @FindBy(xpath = "//*[@id='slide-1']/div[2]/div[1]")
    private WebElement girlsBtn;

    /** Кнопка "Парни"*/
    @FindBy(xpath = "//*[@id='slide-1']/div[2]/div[2]")
    private WebElement boysBtn;

    /** 2-е окно выбора цвета волос*/

    @FindBy(xpath = "//div[@id='slide-2'][@class='inter-slide f visible']/div[2]/div[2]")
    private WebElement gBrightHairColorBtn;

    @FindBy(xpath = "//div[@id='slide-2'][@class='inter-slide m visible']/div[2]/div[2]")
    private WebElement bDarkHairColorBtn;

    /** 3-е окно выбора цвета глаз*/

    @FindBy(xpath = "//div[@id='slide-3'][@class='inter-slide f visible']/div[2]/div[1]")
    private WebElement gDarkEyeColorBtn;

    @FindBy(xpath = "//div[@id='slide-3'][@class='inter-slide m visible']/div[2]/div[2]")
    private WebElement bBrightEyeColorBtn;

    /** 4-е окно выбора фигуры*/

     @FindBy(xpath = "//div[@id='slide-4'][@class='inter-slide f visible']/div[2]/div[2]")
     private WebElement gShapelyFormBtn;

    @FindBy(xpath = "//div[@id='slide-4'][@class='inter-slide m visible']//div[2]//div[2]")
    private WebElement bSportFormBtn;






    public WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    public void chosePersonProperties(String state) {
        Assert.assertTrue(girlsBtn.isDisplayed() && boysBtn.isDisplayed());
        switch (state) {
            case "girls":
                girlsBtn.click();
                wait.until(ExpectedConditions.visibilityOf(gBrightHairColorBtn)).click();
                wait.until(ExpectedConditions.visibilityOf(gDarkEyeColorBtn)).click();
                wait.until(ExpectedConditions.visibilityOf(gShapelyFormBtn)).click();
                break;
            case "boys":
                boysBtn.click();
                wait.until(ExpectedConditions.visibilityOf(bDarkHairColorBtn)).click();
                wait.until(ExpectedConditions.visibilityOf(bBrightEyeColorBtn)).click();
                wait.until(ExpectedConditions.visibilityOf(bSportFormBtn)).click();
                break;
            default:
                throw new AssertionError("unsupported State identifier");
        }

    }
}
