package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.newtours.pages.FindFlightPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;

public class BookFlightTest {
	private static WebDriver driver;
	
	@BeforeAll 
	public static void setupDriver () {
		driver = new FirefoxDriver();
		System.setProperty("webdriver.firefox.driver", "/home/indra/eclipse-workspace_learning/Seleium1/geckodriver");
		
	}
	
	@Test()
	public void registrationPage() {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goTo();
		registrationPage.enterUserDetails("selenium", "docker");
		registrationPage.enterUserCredentials("Selenmium", "docker");
		registrationPage.submit();
	}
	
	@Test()
	public void registrationConfirmation() {
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.goToFlightDetailsPage();
	}
	
	@Test( )
	public void flightDetailsPage() {
		FlightDetailPage flightDetailPage = new FlightDetailPage (driver);
		flightDetailPage.selectPassegers("2");
		flightDetailPage.goToFindFlightPage();
	}
	
	@Test()
	public void findFlightPage() {
		FindFlightPage findFlightPage = new FindFlightPage(driver);
		findFlightPage.submitFindFlightPage();
		findFlightPage.goToOrderConfirmationPage();
	}
	
	@Test()
	public void flightConfirmationPage() {
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		flightConfirmationPage.printConfirmation();
	}
	
	@AfterAll()
	public static void CrearAll () {
		driver = null;
		
	}
}
