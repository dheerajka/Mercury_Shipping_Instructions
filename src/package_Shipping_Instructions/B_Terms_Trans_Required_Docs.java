package package_Shipping_Instructions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class B_Terms_Trans_Required_Docs 
{
		public WebDriver driver;
		public String baseURL = "https://kulala.sk:Mercury015@pgitrade.pg.com/MercuryDev/Home.aspx";
		
	  @Test(priority = 1)
	  public void Verify_Login()
	  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get(baseURL);
		  driver.navigate().refresh();
	  }
	  
	  @Test(priority = 2)
	  public void Terms_Transport_Info() 
	  {
		  // Implicitly wait for 10 seconds
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  // Upon login click on Shipping Instructions tab in the home page
		  driver.findElement(By.xpath("//input[@title='Shipping Instructions']")).click();
		  // Click on the Dashboard View tab
		  driver.findElement(By.xpath("//a[@id='ctl00_UserMenu_aDBView']")).click();
		  // CLick on Edit button of the Request created in the code("Involved_Parties()" method from "A_Initial_Request" class)
		  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_gvDashBoard_cell0_9_btnEditImg']")).click();
		  // Click on  "Terms / Transport Information" tab in the left menu
		  driver.findElement(By.xpath("//a[@id='aTTinfo_Shipping']")).click();
		  // Click on "INCOTERMS of the Contract" dropdown and select a value
		  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_cmbIncoterms_B-1Img']")).click();
		  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_cmbIncoterms_DDD_L_LBI4T0']")).click();
		  // Enter "IncoTerm Location Name" 
		  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_txtNamedPlace']")).sendKeys("Test");
		  // Select Mode of transport Ex: Bulk
		  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_cmbModeOfTransport_B-1Img']")).click();
		  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_cmbModeOfTransport_DDD_L_LBI2T0']")).click();
		  // Click on Save & Close
		  driver.findElement(By.xpath("//span[@class ='dx-vam' and text() = 'Save & Close']")).click();
		  // Handle Alert
		  Alert alert = driver.switchTo().alert();
		  System.out.println(alert.getText());
		  alert.accept();
	  }
	  
	  @Test(priority = 3)
	  public void Required_Docs() throws InterruptedException, IOException 
	  {
		  // Implicitly wait for 10 seconds
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  // Click on "Required Documents" tab in the left menu
		  driver.findElement(By.xpath("//tr[@id='ctl00_UserMenu_trReqDocs_Shipping']")).click();
		  // Select Type of document
		  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_cmbTypeOfDoc_B-1Img']")).click();
		  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_cmbTypeOfDoc_DDD_L_LBI2T0']")).click();
		  // Click on Browse file, select a file and click on Upload file button
		  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fulcUploadDocs']")).click();
		  Runtime.getRuntime().exec("E:\\FileUpload.exe");
		  driver.findElement(By.xpath("//span[@class = 'dx-vam' and text() = 'Add']")).click();
		  // Handle Alert
		  Alert alert = driver.switchTo().alert();
		  System.out.println(alert.getText());
		  alert.accept();
		  // Enter " Documents should arrive 'XX' number of business days prior to arrival"
		  driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_txtNumOfDays']")).sendKeys("10");
		  // Enter HTS# Required 
		  driver.findElement(By.xpath("//textarea[@id='ctl00_MainContent_txtNCMNumberReq']")).sendKeys("Test0310");
		  // CLick on Save & CLose
		  driver.findElement(By.xpath("//span[@class = 'dx-vam' and text() = 'Save & Close']")).click();
		  // Handle Alert
		  Alert alert1 = driver.switchTo().alert();
		  System.out.println(alert1.getText());
		  alert1.accept();
	  }
	  
	  @Test(priority = 4)
	  public void Description_of_Goods() 
	  {
		  // Implicitly wait for 10 seconds
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  // Click on the Dashboard View tab
		  driver.findElement(By.xpath("//a[@id='ctl00_UserMenu_aDBView']")).click();
		  // CLick on Edit button of the Request created in the code("Involved_Parties()" method from "A_Initial_Request" class)
		  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_gvDashBoard_cell0_9_btnEditImg']")).click();
		  // Click on "Description of Goods" in the left menu
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[text() = 'Description of Goods']")).click();
		  // Click on Save & Close
		  driver.findElement(By.xpath("//span[@class = 'dx-vam' and text() = 'Save & Close']")).click();
		  // Handle Alert
		  Alert alert = driver.switchTo().alert();
		  System.out.println(alert.getText());
		  alert.accept();
	  }
  }
