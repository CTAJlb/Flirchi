package DataProvider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TestDataProvider {

    @DataProvider(name = "C0001", parallel=false)
    public static Iterator<Object[]> createDataC0001() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[] {"female", "Autotest", "@e.mail", "Девушка", "20"});
        return data.iterator();
    }

    @DataProvider(name = "C0002", parallel=false)
    public static Iterator<Object[]> createDataC0002() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[] {"male", "Autotest", "@e.mail", "Парень", "20"});
        return data.iterator();
    }
}
