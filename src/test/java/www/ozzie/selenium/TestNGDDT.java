package www.ozzie.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

public class TestNGDDT {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@DataProvider
	public Object[][] testData() {
		return new Object[][] {

				new Object[] { "160", "45", "17.6", "Underweight" }, new Object[] { "168", "70", "24.8", "Normal" },
				new Object[] { "181", "89", "27.2", "Overweight" }, new Object[] { "178", "100", "31.6", "Obesity" }, };

	}

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/WS/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/chromeDriver");
		driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

@Test(dataProvider = "testData")
public void testBMICalculator(String height, String weight, String bmi, String category){
	try{
	WebElement heightField =driver.findElement(By.name("heightCMS"));
	heightField.clear();
	heightField.sendKeys(height);
	
	WebElement weightField = driver.findElement(By.name("weightKg"));
	weightField.clear();
	weightField.sendKeys(weight);
	
	WebElement calculateButton = driver.findElement(By.id("Calculate"));
	calculateButton.click();
	
	WebElement bmiLabel = driver.findElement(By.name("bmi"));
	assertEquals(bmiLabel.getAttribute("value"),bmi);
	
	WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
	assertEquals(bmiCategoryLabel.getAttribute("value"), category);
	
	
	}catch(Error e){
		verificationErrors.append(e.toString());
	}
}
	/*@AfterTest
	
	public void teardown(){
		driver.quit();
	
	String verificationErrorString = verificationErrors.toString();
	if(!"".equals(verificationErrorString)){
		fail(verificationErrorString);
	}
	
}*/


}







