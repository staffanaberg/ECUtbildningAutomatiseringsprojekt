package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;

public class LoginFunction {
    private WebDriver driver;
    private final String username = "Shagtanagotha";
    private final String password = "!Nyarlahotep98";
    private WebDriverWait wait;
    public WebElement element;

    @Before
    public void init() {
        System.setProperty("webdriver,chrome,driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
        System.out.println("Starting the Program");
    }

    @After
    public void exit() {
        System.out.println("Exiting the Program");
        driver.close();

    }


    @Given("^User is already on the login webpage\\.$")
    public void user_is_already_on_the_login_webpage() {
        String browserURL = driver.getCurrentUrl();
        Assert.assertEquals("https://login.mailchimp.com/signup/", browserURL);
    }

    @When("^title of the webpage is asserted and User accept cookies$")
    public void title_of_the_webpage_is_asserted_and_User_accept_cookies() {
        wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#onetrust-accept-btn-handler")));
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
        if (email.isBlank()) {
            System.out.println("Email is empty that is correct");
        } else {
            System.out.println("Email is not empty that is wrong");
            driver.close();
        }

    }

    @Then("^User enter Valid_username$")
    public void user_enter_Valid_username() {
        wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#new_username")));
        driver.findElement(By.cssSelector("#new_username")).sendKeys(username);
        Assert.assertEquals("Shagtanagotha", username);


    }

    @Then("^User click on Sign Up button\\.$")
    public void user_click_on_Sign_Up_button() {
        wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#create-account")));

        if (driver.findElement(By.cssSelector("#create-account")).isDisplayed()) {
            if (driver.getTitle().equals("Signup | Mailchimp"))
                driver.findElement(By.cssSelector("#create-account")).click();

            else {
                System.out.println("You are already logged in.");
                driver.close();
            }
        } else {
            System.out.println("The button was not clicked");
            driver.close();
        }


    }

    @Then("^It will display a Please enter a value for the user\\.$")
    public void it_will_display_a_Please_enter_a_value_for_the_user() {
        Assert.assertEquals("Please enter a value", driver.findElement(By.className("invalid-error")).getText());
    }

    @Then("^User inputs valid_password\\.$")
    public void user_inputs_valid_password() {
        driver.findElement(By.cssSelector("#new_password")).sendKeys(password);
        Assert.assertEquals("!Nyarlahotep98", password);
        if (password.isBlank()) {
            System.out.println("Password was not send to the login page");
            driver.close();
        } else {
            System.out.println("Valid password was sent to the login page.");
        }


    }

    @Then("^User input valid_email$")
    public void user_input_random_email() {
        // Call a method that makes a random email
        randomCharacters();


    }

    private void randomCharacters() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String randomEmail = "";
        String email = "@gmail.com";
        int length = 12;
        randomEmail = getString(characters, randomEmail, length);
        driver.findElement(By.cssSelector("#email")).sendKeys(randomEmail + email);
        Assert.assertEquals(12, randomEmail.length());
        if (email.isBlank()) {
            System.out.println("No email was sent");
            driver.close();
        } else {
            System.out.println("Email was sent.");
        }
    }

    @Then("^User enter randomUsername$")
    public void user_enter_randomUsername() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String randomUsername = "";
        int length = 150;
        randomUsername = getString(characters, randomUsername, length);
        driver.findElement(By.cssSelector("#new_username")).sendKeys(randomUsername);
        driver.findElement(By.cssSelector("#new_password")).sendKeys("!Nyarlahotep98");
        Assert.assertEquals(150, randomUsername.length());
        if (randomUsername.length() > 99) {
            System.out.println("Password is 100 characters or more.");
        } else {
            System.out.println("Password is less than 100 characters.");
        }


    }

    @Then("^It will display a Enter a value less than one hundred characters long for the user\\.$")
    public void it_will_display_a_Enter_a_value_less_than_one_hundred_characters_long_for_the_user() {
        Assert.assertEquals("Enter a value less than 100 characters long",
                driver.findElement(By.className("invalid-error")).getText());
        if (driver.findElement(By.className("invalid-error")).isDisplayed()) {
            System.out.println("Correct message is displayed\nUsername cannot be 100 characters or over");
        } else {
            System.out.println("Wrong message is displayed\nUser should be expected a error message");
            driver.close();
        }


    }

    @Then("^User enter invalid_username$")
    public void user_enter_invalid_username() {
        String invalidUsername = "Samuel";
        driver.findElement(By.cssSelector("#new_username")).sendKeys(invalidUsername);
        driver.findElement(By.cssSelector("#new_password")).sendKeys(password);
        Assert.assertEquals("Samuel", invalidUsername);
        if (username.isBlank()) {
            System.out.println("No username was snd to the login page");
            driver.close();
        } else {
            System.out.println("Busy username was selected");
        }

    }

    @Then("^It will display a Another user with this username already exists\\. Maybe it's your evil twin\\. Spooky\\. for the user\\.$")
    public void it_will_display_a_Another_user_with_this_username_already_exists_Maybe_it_s_your_evil_twin_Spooky_for_the_user() {
        Assert.assertEquals("Another user with this username already exists. Maybe it's your evil twin. Spooky.",
                driver.findElement(By.className("invalid-error")).getText());
    }

    @Then("^User input the valid_email in the box\\.$")
    public void user_input_the_valid_email_in_the_box() {
        // Method to make an E-mail random

        randomCharacters();

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
    public void it_will_display_a_Success_MailChimp_for_the_user() {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Success | Mailchimp", title);
        if (title.equals("Success | Mailchimp")) {
            System.out.println("You have successfully logged in to MailChimp ");
        } else {
            System.out.println("You did not log in to Mailchimp");
        }
    }


}