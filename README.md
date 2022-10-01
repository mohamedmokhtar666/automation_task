# automation_task_target
automated task for signup and login for website phptravels.

# How to use?  
tools and libraries
 IntelliJ,
 Selenium,
 TestNG,
 Page Object Model(pom),
 Maven project,
 Java programming,
 WebDriverManager.
 Steps:
 general scanerio: 
 1-open browser.
 2-open website.
 3-open signup page.
 4-enter data fields to signup and click signup.
 5-open login page to enter fields to login.
 6-go to home page to appear message (Hi, name account Welcome back).
Create Maven project and put dependenices in pom.xml (maven.compiler.source>17, org.seleniumhq.selenium,org.testng,webdrivermanager).
=======================================================================================================================================================================
# First Part:
create in src main package called pages inside it three classes they SignupPage,LoginPage and HomePage.
firstly class signupPage create method signUpProcess_PartiallyAutomated to automate signup define locate elements and enter fields ,interact with fields than click manully captcha to continue sigup and then go next page LogingPage to enter  the same account and password  and  click login button then go to next page HomePage
to verify login successful.
secondly create method signUpProcess_FullyAutomated the same steps in pervious method but, fully automated without any human interact.

# Second Part:
in the src Test create two packages base inside it BaseTest class to set configuration using annotation (BeforeClass,BeforeMethod,AfterMethod,AfterClass)
second class SignupTest to test scanerios ,create three test cases to verify signup and login.
first test case use data provider from another class  to set valid data in method signUpProcess_PartiallyAutomated and make assertion if login successful or not.
second test case  use data provider from another class  to set invalid data in method signUpProcess_PartiallyAutomated and make assertion if login successful or not.
third test case  use data provider from another class  to set valid data in method signUpProcess_FullyAutomated  and make assertion if login successful or not.

# Finally:
create testing.xml to run all test cases and generate test report, after running three test cases test results as below:
first test case passed and verify login successful.
second test case faild due to invalid date in enter phone field empty.
third test case faild due to can not handle captcha fully automation.
and create screenshots for test cases failure in resources directory and testng report.

=======================================================================================================================================================================

# General Describtion chanllages: after read task  sceanerio for singup find problem during process signup is repatcha (Im not robot) that repatcha is not automated and not recommanded for automation due to using make sure is not robot, but after search  there are find three solutions for captcha in selenium are:
 1-By disabling the Captcha in the testing environment:
 Disabling Captcha in the test environment would ensure that while testing a web application, the Captcha task is not required. While using Google’s open-source Captcha widget – reCAPTCHA v2, put in the Site Key and the Secret Key, (known as the test keys).  As a result, all verification requests will pass, and automated UI testing can be conducted seamlessly.
 =====================================================================================================================================================================
 2-Adding a hook to click the Captcha checkbox:
 By adding a hook to the code, users can bypass the Captcha while performing Automation Testing. The Captcha recognizes a bot clicking the checkbox element by the fact that it takes less time for the bot to click as compared to humans. Therefore, testers need to induce WebDriverWait, so that the element is clicked only when it becomes clickable. This bypasses the Captcha.
=======================================================================================================================================================================
 3-By adding a delay to the Webdriver and manually solve Captcha while testing:
 Firstly, this method is not completely automated and requires human intervention to solve the Captcha. Call it a semi-automated test. 
In this method, a delay of 10-20s is introduced to freeze the captcha screen, so that the page does not suffer from the race condition, which generally happens while using automation testing on a web page with a Captcha element.
======================================================================================================================================================================
After experiment second solution can  not interact with captcha because after click captcha appear captcha images to interact with images i need Captcha Solving APIs that use real human operators to solve captchas.  I don’t recommend one in particular.
After experiment third solution can interact with captcha manully using delay and then continue automation task.



