package ui_Layer;

import core.Driver;
import org.testng.Assert;
import ui_Layer.blocks.PersonState;

import static core.Utils.getCurrentURL;


public class HomePage extends PageFactorySettings {

    PersonState personState;


    public static HomePage open() {
        Driver.get().get(System.getProperty("test.baseURL"));
        Assert.assertEquals(getCurrentURL(), System.getProperty("test.baseURL"), "Current URL is not as expected");
        return new HomePage();
    }

    public void choseSearchParameters(String state){
        personState = new PersonState();
        personState.chosePersonProperties(state);


    }

}
