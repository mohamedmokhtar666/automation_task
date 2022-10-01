package signup;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignUpPage;

import static org.testng.Assert.assertEquals;

public class SignupTest extends BaseTest {

    @Test (dataProviderClass =TestData.class,dataProvider = "signup-provider",priority = 1)
    public void signupTest_Partially(String firstName,String lastName,String phone,String email,String password )
    {
        var signup=signUpPage.signUpProcess_PartiallyAutomated(firstName,lastName,phone,email,password);
        var login=signup.setLogin(email,password);
        assertEquals(login.getText(),firstName,"Login is Not Successful");
    }


    @Test (dataProviderClass =TestData.class,dataProvider = "signup-InvalidData",priority = 2)
    public void signupTest_InvalidData(String firstName,String lastName,String phone,String email,String password )
    {
        var signup=signUpPage.signUpProcess_PartiallyAutomated(firstName,lastName,phone,email,password);
        var login=signup.setLogin(email,password);
        assertEquals(login.getText(),firstName,"Login is Not Successful");
    }


    @Test (dataProviderClass =TestData.class,dataProvider = "signup-provider",priority = 3)
    public void signupTest_Fully(String firstName,String lastName,String phone,String email,String password )
    {
        var signup=signUpPage.signUpProcess_FullyAutomated(firstName,lastName,phone,email,password);
        var login=signup.setLogin(email,password);
        assertEquals(login.getText(),firstName,"Login is Not Successful");
    }




}
