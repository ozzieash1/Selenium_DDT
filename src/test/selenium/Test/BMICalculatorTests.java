import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import www.ozzie.selenium.BMICalcPage_POM;



public class BMICalculatorTests {
	//Test comments

	@Test

	public void testBMICalculation(){
	
	System.setProperty("webdriver.chrome.driver", "C:/WS/chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/chromeDriver");
	driver = new ChromeDriver();
	driver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	BMICalcPage_POM bMICalcPage_POM = new BMICalcPage_POM(driver);
	
	bMICalcPage_POM.heightCMS.sendKeys("181");
	bMICalcPage_POM.weightKg.sendKeys("80");
	bMICalcPage_POM.Calculate.click();
	
	assertEquals("24.4", bMICalcPage_POM.bmi_category.getAttribute("value"))
	driver.close();
	

}
}
