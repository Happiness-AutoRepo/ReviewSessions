package stepdefs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CSVReportValidationSteps {

	WebDriver driver;
	
	Map<Integer, Map<String, String>> UIDataMap = new HashMap<>();
	
	@Given("User is on the applicants report page")
	public void user_is_on_the_applicants_report_page() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8");
	}
	
	@Given("User can read applicants data from table")
	public void user_can_read_applicants_data_from_table() {
	    
		Select perPage = new Select(driver.findElement(By.id("recPerPage")));
		perPage.selectByVisibleText("100");
	}
	
	@And(".csv report is generated")
	public void csv_report_is_generated() {
	    
	}

	@Then("Data in UI and csv report should match")
	public void data_in_UI_and_csv_report_should_match() {
	    
	}
}
