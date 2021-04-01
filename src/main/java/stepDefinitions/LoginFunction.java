package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginFunction {
    WebDriver driver;

    @Before
    public void init() {
        System.out.println("Starting the Program");
    }

    @After
    public void exit() {
        System.out.println("Exiting the Program");

    }


    @Given("^User is already on the login webpage\\.$")
    public void user_is_already_on_the_login_webpage() throws InterruptedException {
        System.setProperty("webdriver,chrome,driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
        Thread.sleep(1000);


    }

    @When("^title of the webpage is asserted and User accept cookies$")
    public void title_of_the_webpage_is_asserted_and_User_accept_cookies() {

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Signup | Mailchimp", title);
    }


    @Then("^User enter no information on the email box\\.$")
    public void user_enter_no_information_on_the_email_box() throws InterruptedException {
        Thread.sleep(1500);

        driver.findElement(By.id("new_username")).sendKeys("Shagtanagotha");
        driver.findElement(By.id("new_password")).sendKeys("!Nyarlahotep98");
        Thread.sleep(1000);
        driver.findElement(By.id("create-account")).click();
        String email = "";
        System.out.println(email);
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys(email);
        Assert.assertEquals("", email);


    }

    @Then("^User enter account name with more then one hundred 'characters'\\.$")
    public void user_enter_account_name_with_more_then_one_hundred_characters(String characters) {

    }

    @Then("^User enter an already busy 'name'\\.$")
    public void user_enter_an_already_busy_name(String name) {

    }

    @Then("^User creates an account with no problems\\.$")
    public void user_creates_an_account_with_no_problems() {

    }


}
