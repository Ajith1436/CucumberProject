package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDef {
	WebDriver driver = Hooks.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		driver.get("https://www.simplilearn.com/");

	}

	@Given("I have clicked on Login Link")
	public void i_have_clicked_on_Login_Link() {

		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();

	}

	@When("I enter username")
	public void i_enter_username() {
		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys("sreejaskurup2010@gmail.com");
	}

	@When("I enter password")
	public void i_enter_password() {
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("1Anna@2013");
	}

	@When("I clicked on login button")
	public void i_clicked_on_login_button() throws InterruptedException {
		WebElement LoginClick = driver.findElement(By.name("btn_login"));
		LoginClick.click();
		Thread.sleep(3000);
	}

	/*
	 * @Then("I should land on home page") public void i_should_land_on_home_page()
	 * { WebElement loginSuccess = driver.findElement(By.
	 * className("program-detail__course custom-program-detail__course-theme"));
	 * String loginSuccessMsg = loginSuccess.getText(); String ExploginSuccessMsg =
	 * "Automation Testing Masters Program"; Assert.assertEquals(ExploginSuccessMsg,
	 * loginSuccessMsg); }
	 */

	@Then("I should get the error message")
	public void i_should_get_the_error_message() {
		WebElement unSuccessValidate = driver.findElement(By.id("msg_box"));
		String ValidationError = unSuccessValidate.getText();
		String ExpValidationError = "The email or password you have entered is invalid.";
		Assert.assertEquals(ValidationError, ExpValidationError);
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String UserNameVal) {

		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys(UserNameVal);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String PasswordVal) {
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(PasswordVal);
	}

	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String ExpError) {
		WebElement unSuccessValidate = driver.findElement(By.id("msg_box"));
		String ValidationError = unSuccessValidate.getText();
		Assert.assertEquals(ValidationError, ExpError);
	}

}
