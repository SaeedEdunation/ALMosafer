import static org.testng.Assert.assertEquals;

import java.time.LocalDate;

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
	Random rand = new Random();
	
	@BeforeTest
	public void mysetup () {
		
		driver.manage().window().maximize();
		driver.get(myWebSite);
	    WebElement ButtonForCurrncy = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		ButtonForCurrncy.click();
	
	}
	@Test (priority = 1, enabled = false)
	public void CheckTheEnglishLanguage() throws InterruptedException {
	String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
	String ExpectedLanguage= "en";
	Assert.assertEquals(ActualLanguage, ExpectedLanguage);
	
	}
	
	@Test (priority = 2,enabled = false)
	public void CheckCurrncy() {
		String ActualCurrncy = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO")).getText();
		String ExpectedCurrncy = "SAR";
		Assert.assertEquals(ActualCurrncy, ExpectedCurrncy);
		
	}
	@ Test (priority = 3, enabled = false)
	public void CheckNumber () {
		String ActualNumber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		String ExpectedNumber = "+966554400000";
		Assert.assertEquals(ActualNumber, ExpectedNumber);
	}
	@Test (priority = 4, enabled = false) 
	public void CheckQitafLogo (){
		
	Boolean ActualResult = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
	Boolean ExpectedResult = true;
	Assert.assertEquals(ActualResult, ExpectedResult);
	}
	@ Test (priority = 5 , enabled = false)
	public void CheckSearch () {
    WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
    String ActualReslut = HotelTab.getAttribute("aria-selected");
    String ExpectedRsult= "false";
    Assert.assertEquals(ActualReslut, ExpectedRsult);
    
  
}
@Test (priority = 6)
public void CheckDepatDate () {
	int   today = LocalDate.now().getDayOfMonth();
	
	int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();
	int DayAfetrTomorrow = LocalDate.now().plusDays(2).getDayOfMonth();
	//System.out.println(DayAfetrTomorrow);
	//System.out.println(Tomorrow);
	//System.out.println(today);
	
	String ActualDepature = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']")).getText();
	String ExpectedDepature = Integer.toString(Tomorrow);

	Assert.assertEquals(ActualDepature, ExpectedDepature);
	
}
@Test(priority = 7)
public void CheckReturnDate() {
	int today = LocalDate.now().getDayOfMonth();

	int DayAfterTomorrow = LocalDate.now().plusDays(2).getDayOfMonth();

	String ActualReturn = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']")).getText();
	String ExpectedReturn = Integer.toString(DayAfterTomorrow);

	Assert.assertEquals(ActualReturn, ExpectedReturn);

}
@Test(priority = 8)
public void RandomlyChangeTheLanguage() throws InterruptedException {
	String [] myWebsites = {"https://www.almosafer.com/ar","https://www.almosafer.com/en"};
	
	int randomIndex = rand.nextInt(myWebsites.length);
	driver.get(myWebsites[randomIndex]);
	
	if(driver.getCurrentUrl().equals("https://www.almosafer.com/ar")) {
		String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedLanguage = "ar";

		Assert.assertEquals(ActualLaguage, ExpectedLanguage);
	}else {
		String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedLanguage = "en";

		Assert.assertEquals(ActualLaguage, ExpectedLanguage);
	}
	

	


}
}