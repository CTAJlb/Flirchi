package Registration;

import DataProvider.TestDataProvider;
import core.BaseTestSettings;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ui_Layer.HomePage;
import ui_Layer.UserPage;
import ui_Layer.blocks.RegistrationControls;

import java.util.Random;


public class C0002 extends BaseTestSettings {

    HomePage homePage;
    RegistrationControls registrationControls;
    UserPage userPage;


    @Test(dataProvider = "C0002", dataProviderClass = TestDataProvider.class)
    public void positiveMaleRegistration(String registrationForm, String userName, String email, String sexValue, String ageValue) {

        /** Pre conditions */
        Random r = new Random();
        long random = r.nextInt();
        userName = userName + random;
        email = "test" + random + email;


        homePage = new HomePage();
        registrationControls = new RegistrationControls();
        userPage = new UserPage();


        HomePage.open();
        Reporter.log(" 1) Переход на страницу https://flirchi.com/sign/inter?fr=1&p=1232");
        homePage.choseSearchParameters("boys");
        Reporter.log(" 2) Выбор параметр поиска 'Парни' -> 'Переход в форму регистрации'");
        registrationControls.registration(registrationForm, userName, email, sexValue, ageValue);
        Reporter.log(" 3) Заполняем поля 'Ваше Имя' , 'Email', выбираем 'Кто вы?', 'Возраст' -> Нажимаем кнопку 'Регистрация'");
        userPage.checkUserRegister(userName, sexValue);
        Reporter.log(" 4) Делаем проверку регистрации: проверка 'Имени', наличие кнопки 'Выход'");
        System.out.println("C0002 PASSED");
    }
}
