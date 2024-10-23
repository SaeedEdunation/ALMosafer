import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTest {
	
	WebDriver driver= new ChromeDriver();
	
	String myWebSite = "https://www.almosafer.com/en";

	
	@BeforeTest
	public void mysetup () {
		
		driver.manage().window().maximize();
		driver.get(myWebSite);
	    WebElement ButtonForCurrncy = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		ButtonForCurrncy.click();
	
	}
	@Test (priority = 1)
	public void CheckTheEnglishLanguage() throws InterruptedException {
	String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
	String ExpectedLanguage= "en";
	Assert.assertEquals(ActualLanguage, ExpectedLanguage);
	
	}
	
	@Test (priority = 2)
	public void CheckCurrncy() {
		String ActualCurrncy = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO")).getText();
		String ExpectedCurrncy = "SAR";
		Assert.assertEquals(ActualCurrncy, ExpectedCurrncy);
		
	}
	@ Test (priority = 3)
	public void CheckNumber () {
		String ActualNumber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		String ExpectedNumber = "+966554400000";
		Assert.assertEquals(ActualNumber, ExpectedNumber);
	}
	@Test (priority = 4) 
	public void CheckQitafLogo (){
		
	Boolean ActualResult = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
	Boolean ExpectedResult = true;
	Assert.assertEquals(ActualResult, ExpectedResult);
	}
	@ Test (priority = 5)
	public void CheckSearch () {
	Boolean  ActualResult = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).isDisplayed();
	Boolean ExpectedResult= false;
	Assert.assertEquals(ActualResult, ExpectedResult);
	
	}
	}