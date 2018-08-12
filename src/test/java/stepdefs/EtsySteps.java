package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.EtsyPage;

public class EtsySteps {
	
	private WebDriver driver;
	private EtsyPage etsyPage;
	private String keyword;
	
	@Given("User is on Etsy homepage")
	public void user_is_on_Etsy_homepage() {
		
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    
	    driver.get("https://etsy.com");
	    Assert.assertEquals(driver.getTitle(), "Etsy.com | Shop for anything from creative people everywhere");
	}

	@When("User searches for {string}")
	public void user_searches_for(String keyword) {
	    
		this.keyword = keyword;
		etsyPage = new EtsyPage(driver);
		etsyPage.searchBox.sendKeys(keyword + Keys.ENTER);
		System.out.println("Searching for " + keyword);
	}

	@Then("Search results should be displayed")
	public void search_results_should_be_displayed() {
		
		Assert.assertTrue(driver.getTitle().toLowerCase().contains(keyword));
		driver.quit();
	}
}
