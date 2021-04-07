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

import java.util.Random;

public class LoginFunction {
    WebDriver driver;
    String username = "Shagtanagotha";

    @Before
    public void init() {
        System.out.println("Starting the Program");
    }

    @After
    public void exit() {
        System.out.println("Exiting the Program");
        driver.close();

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
        driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Signup | Mailchimp", title);

    }

    @Then("^User input the empty-email in the box\\.$")
    public void user_input_the_empty_email_in_the_box() {
        String email = "";
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        Assert.assertEquals("", email);

    }

    @Then("^User enter Valid_username$")
    public void user_enter_Valid_username() throws InterruptedException {
        driver.findElement(By.cssSelector("#new_username")).sendKeys(username);
        Thread.sleep(1000);


    }

    @Then("^User click on Sign Up button\\.$")
    public void user_click_on_Sign_Up_button() {

        driver.findElement(By.cssSelector("#create-account")).click();


    }

    @Then("^It will display a Please enter a value for the user\\.$")
    public void it_will_display_a_Please_enter_a_value_for_the_user() {
        Assert.assertEquals("Please enter a value", driver.findElement(By.className("invalid-error")).getText());
    }

    @Then("^User inputs valid_password\\.$")
    public void user_inputs_valid_password() throws Throwable {
        driver.findElement(By.cssSelector("#new_password")).sendKeys("!Nyarlahotep98");
        Thread.sleep(1000);


    }

    @Then("^User input the hejsanhopss(\\d+)@gmail\\.com in the box\\.$")
    public void user_input_the_hejsanhopss_gmail_com_in_the_box(int arg1) {
        String email = "hejsanhopss100@gmail.com";
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        Assert.assertEquals("hejsanhopss100@gmail.com", email);


    }

    @Then("^User enter randomUsername$")
    public void user_enter_randomUsername() throws Throwable {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String randomUsername = "";
        int length = 150;
        randomUsername = getString(characters, randomUsername, length);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#new_username")).sendKeys(randomUsername);
        driver.findElement(By.cssSelector("#new_password")).sendKeys("!Nyarlahotep98");
        Assert.assertEquals(150, randomUsername.length());


    }


    @Then("^It will display a Enter a value less than (\\d+) characters long for the user\\.$")
    public void it_will_display_a_Enter_a_value_less_than_characters_long_for_the_user(int arg1) {

        Assert.assertEquals("Enter a value less than 100 characters long",
                driver.findElement(By.className("invalid-error")).getText());

    }

    @Then("^User enter invalid_username$")
    public void user_enter_invalid_username() {
        driver.findElement(By.cssSelector("#new_username")).sendKeys("Samuel");
        driver.findElement(By.cssSelector("#new_password")).sendKeys("!Nyarlahotep98");

    }

    @Then("^It will display a Another user with this username already exists\\. Maybe it's your evil twin\\. Spooky\\. for the user\\.$")
    public void it_will_display_a_Another_user_with_this_username_already_exists_Maybe_it_s_your_evil_twin_Spooky_for_the_user() {
        Assert.assertEquals("Another user with this username already exists. Maybe it's your evil twin. Spooky.",
                driver.findElement(By.className("invalid-error")).getText());
    }

    @Then("^User input the valid_email in the box\\.$")
    public void user_input_the_valid_email_in_the_box() {
        String emailCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String randomEmail = "";
        String email = "@gmail.com";
        int length = 12;
        randomEmail = getString(emailCharacters, randomEmail, length);
        driver.findElement(By.cssSelector("#email")).sendKeys(randomEmail + email);
        Assert.assertEquals(12, randomEmail.length());

    }

    @Then("^User enter valid_username$")
    public void user_enter_valid_username() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String randomValidUsername = "";
        int length = 12;
        randomValidUsername = getString(characters, randomValidUsername, length);
        driver.findElement(By.cssSelector("#new_username")).sendKeys(randomValidUsername);
        driver.findElement(By.cssSelector("#new_password")).sendKeys("!Nyarlahotep98");
        Assert.assertEquals(12, randomValidUsername.length());


    }

    private String getString(String characters, String randomValidUsername, int length) {
        Random rand = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rand.nextInt(characters.length()));
        }
        for (char c : text) {
            randomValidUsername += c;
            randomValidUsername.length();
        }
        return randomValidUsername;
    }


    @Then("^It will display a Success MailChimp for the user\\.$")
    public void it_will_display_a_Success_MailChimp_for_the_user() throws Throwable {
        Thread.sleep(1000);
        String title = driver.getTitle();
        Thread.sleep(1000);
        System.out.println(title);
        Assert.assertEquals("Success | Mailchimp", title);
    }


}
