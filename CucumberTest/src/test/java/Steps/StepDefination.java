package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination {
	
	WebDriver driver;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/ "); 
	}

	@When("user enters {string} into username field")
	public void user_enters_into_username_field(String username) {
		WebElement email =driver.findElement(By.id("username"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(username);
		System.out.println("username is entered");
	 
	}

	@When("user enters {string} into password field")
	public void user_enters_into_password_field(String password) {
		WebElement password1 = driver.findElement(By.id("password"));		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(password1));
		password1.clear();
		password1.sendKeys(password);
		System.out.println("password is entered");
	    
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		WebElement login = driver.findElement(By.id("Login"));
	    login.click();
	   
	}

	@Then("verify page title {string}")
	public void verify_page_title(String expected) {
		String actual = driver.getTitle();
        //System.out.println("actual="+actual);
        Assert.assertEquals("Home Page ~ Salesforce - Devloper Edition", expected);
        driver.quit();
	    
	}
	@Then("verify the error message {string}")
	public void verify_the_error_message(String expected) {
		String actual = driver.getTitle();
        //System.out.println("actual="+actual);
        Assert.assertEquals("Please enter your password.", expected);
        driver.quit();
	}
	@When("user click on check remember me button")
	public void user_click_on_check_remember_me_button() {
		WebElement checkBox = driver.findElement(By.id("rememberUn"));
 		if(!checkBox.isSelected())
 		{
 			checkBox.click();
 		}	
	    
	}
	@Then("user click on usermenu dropdown button")
	public void user_click_on_usermenu_dropdown_button() {
        driver.findElement(By.id("userNavLabel")).click();
	    
	}
	@Then("user click on logout button")
	public void user_click_on_logout_button() {
		 WebElement logout = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
	 		logout.click();
	   
	}
	@Then("Validate the user name displayed in user name field")
	public void validate_the_user_name_displayed_in_user_name_field() {
		String remberme = driver.getCurrentUrl();
		//System.out.println("Remeber Me : " + remberme);
		Assert.assertEquals("https://tekarch4-dev-ed.my.salesforce.com/secur/logout.jsp",remberme);
		driver.quit();
	}
	@When("user click on forget password")
	public void user_click_on_forget_password() {
		WebElement forgotpassword = driver.findElement(By.id("forgot_password_link"));
		forgotpassword.click();
	}
	@When("Provide {string} in salesforce forgot password page")
	public void provide_in_salesforce_forgot_password_page(String username) {
		WebElement email = driver.findElement(By.id("un"));
		email.sendKeys(username);
	    
	}
	@When("click on contiue button")
	public void click_on_contiue_button() {
		WebElement submit = driver.findElement(By.name("continue"));
		submit.click();
		
	}
	
	@Then("error message should be displayed")
	public void error_message_should_be_displayed() {
		String error = driver.getTitle();
		System.out.println("Error : " + error);
		Assert.assertEquals("Login | Salesforce", error);
		driver.quit();
	}
	@Then("Password reset message page is displayed")
	public void password_reset_message_page_is_displayed() {
		String  Continue = driver.getTitle();
		//System.out.println("continue :"+ Continue );
		Assert.assertTrue(Continue.contains("Check Your Email | Salesforce"));
		driver.quit();  
	}


}
