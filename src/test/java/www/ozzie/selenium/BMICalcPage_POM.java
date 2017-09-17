package www.ozzie.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BMICalcPage_POM {
	public WebElement heightCMS;
	public WebElement weightKg;
	public WebElement Calculate;
	public WebElement bmi;
	public WebElement bmi_category;
	
	public BMICalcPage_POM(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	

}
