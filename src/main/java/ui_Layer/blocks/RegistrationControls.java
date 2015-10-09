package ui_Layer.blocks;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_Layer.PageFactorySettings;



public class RegistrationControls extends PageFactorySettings {


    /** Форма регистрации Male*/

    @FindBy(css = "#form-signup-m > #field-name > #form-signup-name")
    private WebElement mNameField;

    @FindBy(css = "#form-signup-m > #field-email > #form-signup-email")
    private WebElement mEmailField;

    @FindBy(css = "#form-signup-m > div.land-form-row > #field-gender > #field-gender-select" )
    private WebElement mSexSelect;

    @FindBy(css = "#form-signup-m > div.land-form-row > #field-age > #field-age-select" )
    private WebElement mAgeSelect;

    @FindBy(xpath = ".//*[@id='submit_sign_up_m']")
    private WebElement mRegisterBtn;

    /** Форма регистрации Female*/

    @FindBy(css = "#form-signup-f > #field-name > #form-signup-name")
    private WebElement fNameField;

    @FindBy(css = "#form-signup-f > #field-email > #form-signup-email")
    private WebElement fEmailField;

    @FindBy(css = "#form-signup-f > div.land-form-row > #field-gender > #field-gender-select" )
    private WebElement fSexSelect;

    @FindBy(css = "#form-signup-f > div.land-form-row > #field-age > #field-age-select" )
    private WebElement fAgeSelect;

    @FindBy(xpath = ".//*[@id='submit_sign_up_f']")
    private WebElement fRegisterBtn;


    private WebDriverWait wait = new WebDriverWait(Driver.get(), 35);


    public void setMaleSexSelect(String value) {
        Select select = new Select(this.mSexSelect);
        //        System.out.println(sexSelect.getText());
        select.selectByVisibleText(value);
    }

    public void setFemaleSexSelect(String value) {
        Select select = new Select(this.fSexSelect);
//        System.out.println(fSexSelect.getText());
        select.selectByVisibleText(value);
    }

    public void setMaleAgeSelect(String value) {
        Select select = new Select(this.mAgeSelect);
        select.selectByValue(value);
    }
    public void setFemaleAgeSelect(String value) {
        Select select = new Select(this.fAgeSelect);
        //        System.out.println(sexSelect.getText());
        select.selectByValue(value);
    }

    public void registration(String registrationForm, String userName, String email, String sexValue, String ageValue) {
        switch (registrationForm) {
            case "female" :
                wait.until(ExpectedConditions.visibilityOf(fRegisterBtn));
                fNameField.sendKeys(userName);
                fEmailField.sendKeys(email);
                setFemaleSexSelect(sexValue);
                setFemaleAgeSelect(ageValue);
                fRegisterBtn.click();
                break;
            case "male" :
                wait.until(ExpectedConditions.visibilityOf(mRegisterBtn));
                mNameField.sendKeys(userName);
                mEmailField.sendKeys(email);
                setMaleSexSelect(sexValue);
                setMaleAgeSelect(ageValue);
                mRegisterBtn.click();
                break;
            default:
                throw new AssertionError("unsupported Form");
        }




        }

    }


