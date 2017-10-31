package www.ozzie.selenium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class JUnitDDT {
	private static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer ();
	
	
	private String height;
	private String weight;
	private String bmi;
	private String bmiCategory;
	
	//Test Comment
	@Parameters
	public static Collection testData(){
		return Arrays.asList(
				new Object[][]{
					{"160", "45", "17.6", "Underweight"	},
					{"168", "70", "24.8", "Normal"	},
					{"181", "89", "27.2", "Overweight"	},
					{"178", "100", "31.6", "Obesity"	}
					}
				);
		}
	public JUnitDDT(String height, String weight, String bmi, String bmiCategory)
	{
		this.height=height;
		this.weight=weight;
		this.bmi=bmi;
		this.bmiCategory=bmiCategory;
		
	}
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/WS/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/chromeDriver");
		driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	@Test
	public void testBMICalculator() throws Exception{
		WebElement heightField = driver.findElement(By.name("heightCMS"));
		heightField.clear();
		heightField.sendKeys(height);
		
		WebElement weightField = driver.findElement(By.name("weightKg"));
		weightField.clear();
		weightField.sendKeys(height);
	
		WebElement calculateButton = driver.findElement(By.id("Calculate"));
		calculateButton.click();
		
	
	try{
		WebElement bmiLabel = driver.findElement(By.name("bmi"));
		assertEquals(bmi, bmiLabel.getAttribute("value"));
		
		WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
		assertEquals(bmiCategory,bmiCategoryLabel.getAttribute("value"));
		
		} catch (Error e){
			verificationErrors.append(e.toString());
			System.err.println("Assertion Fail " + verificationErrors.toString());
		}
}

@After
	
	public void teardown(){
		driver.quit();
	
	String verificationErrorString = verificationErrors.toString();
	if(!"".equals(verificationErrorString)){
		fail(verificationErrorString);
	}
	
}
	
}//End of class JUnitDDT
