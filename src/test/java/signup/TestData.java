package signup;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "signup-provider")
    public static Object[][] setData()
    {
        return new Object[][]{
                {"Mohamed","Ali","01224570307","mohamedali@gmail.com","Mok2411"}
        };

    }
    @DataProvider(name = "signup-InvalidData")
    public static Object[][] setData2()
    {
        return new Object[][]{
                {"amr","Ali","","mohamedali@gmail.com","12345678"}
        };

    }
}
