package package_Shipping_Instructions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class C_Origin_Approver 
	{
		public WebDriver driver;
		public String baseURL = "https://nemana.vk:Vertex14@pgitrade.pg.com/MercuryDev/Home.aspx";
		
	  @Test(priority = 1)
	  public void Verify_Login()
	  {
		  //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get(baseURL);
		  driver.navigate().refresh();
	  }
    @Test(priority = 2)
  public void Origin_Approver() 
    {
    	  // Implicitly wait for 10 seconds
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
    	  // Upon login click on Shipping Instructions tab in the home page
		  driver.findElement(By.xpath("//input[@title='Shipping Instructions']")).click();
		  // Click on the Dashboard View tab
		  driver.findElement(By.xpath("//a[@id='ctl00_UserMenu_aDBView']")).click();
		  // Click on Edit button of the Request that is successfully submitted for approval
		  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_gvDashBoard_cell0_9_btnEditImg']")).click();
		  // Click on "Accept By I-Trade Origin" button in the "Involved Parties" page
		  driver.findElement(By.xpath("//span[@class = 'dx-vam' and text() = 'Accept By I-Trade Origin']")).click();
		  driver.findElement(By.xpath("//textarea[@id='ctl00_MainContent_RevisionPopup_RevisionPopupPanel_memRevisionComments']")).sendKeys("Test Comments");
		  // Click on Save
		  driver.findElement(By.xpath("//span[@class='dx-vam' and text() = 'Save']")).click();
		  // Handle Alert
		  Alert alert = driver.switchTo().alert();
		  System.out.println(alert.getText());
		  alert.accept();
		  driver.close();
    }
}
