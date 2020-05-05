import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginRegistration {
	static WebDriver driver;
	static WebDriverManager manager;
	String url="http://newtours.demoaut.com/";
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		String driver_version = manager.chromedriver().getDownloadedVersion();
		System.out.println("The Browser Version: "+driver_version);
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
			
	}
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> data = ExcelUtils.readExcell();
		return data.iterator();
	}
	@Test(dataProvider = "getTestData")
	public void getData(String FirstName,String LastName,String Phone,String Email,String Address1, 
			String Address2, String City,String State,String Postcode, String Country){
		
		driver.get(url);
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys(FirstName);;
		driver.findElement(By.name("lastName")).sendKeys(LastName);
		driver.findElement(By.name("phone")).sendKeys(Phone);
		driver.findElement(By.id("userName")).sendKeys(Email);
		driver.findElement(By.name("address1")).sendKeys(Address1);
		driver.findElement(By.name("address2")).sendKeys(Address2);
		driver.findElement(By.name("city")).sendKeys(City);
		driver.findElement(By.name("state")).sendKeys(State);
		driver.findElement(By.name("postalCode")).sendKeys(Postcode);
		driver.findElement(By.name("country")).sendKeys(Country);
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
