package package_Shipping_Instructions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class A_Initial_Request 
{
	public WebDriver driver;
	public String baseURL = "https://kulala.sk:Mercury015@pgitrade.pg.com/MercuryDev/Home.aspx"; 
	
  @Test(priority = 1)
  public void Verify_Login() 
  {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
	  driver = new ChromeDriver();
	  //driver = new InternetExplorerDriver();
	  driver.manage().window().maximize();
	  driver.get(baseURL);
	  driver.navigate().refresh();
  }
  
  @Test(priority = 2)
  public void Initial_Request() throws InterruptedException
  {
	  // IMPORTANT NOTE : IF REQUIRED ONE NEEDS TO CHANGE "SHIP TO CODE" AT "Enter "ship to code"" code segment.
	  // Upon login click on Shipping Instructions tab in the home page
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@title='Shipping Instructions']")).click();
	  // Click on "New Shipping Instructions" tab in the top left corner of the page
	  driver.findElement(By.xpath("//a[@id='ctl00_UserMenu_aCreateRequest_shipping']")).click();
	  // Select a country from "Ship From Country" dropdown 
	  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_cmbShipFromCountry_I']")).click();
	  driver.findElement(By.xpath("//td[text() = 'Vietnam']")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  // Select a country from "Ship To Country" ropdown
	  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_cmbShipToCountry_I']")).click();
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_cmbShipToCountry_DDD_L_LBI83T0']")).click();
	  Thread.sleep(5000);
	  // Enter "Ship to code"
	  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_txtShipToCode']")).sendKeys("12310");
	  // Select a Category
	  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_txtCategoryName_I']")).click();
	  driver.findElement(By.xpath("//td[text() = 'Chemicals']")).click();
	  Thread.sleep(5000);
	  // Click on Submit button
	  driver.findElement(By.xpath("//span[@class = 'dx-vam' and text() = 'Submit']")).click();
	  // Handle Alert
	  Alert alert = driver.switchTo().alert();
	  System.out.println(alert.getText());
	  alert.accept();
	  Thread.sleep(3000);
    }
  
  @Test(priority = 3)
  public void Involved_parties() throws InterruptedException
  {
	  // Select "Same as Requestor" dropdown from SI Primary Contact layer
	  driver.findElement(By.xpath("//span[@id='ctl00_MainContent_chkSameAsRequestor_S_D']")).click();
	  Thread.sleep(3000);	  
	  // Enter required fields in "Information about the SELLER" layer
	  // Select "Seller Type" 
	  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_pnlSellerCallback_cmbSellerType_I']")).click();
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlSellerCallback_cmbSellerType_DDD_L_LBI1T0']")).click();
	  // Enter Name
	  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_pnlSellerCallback_txtSellerName_B-1Img']")).click();
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlSellerCallback_txtSellerName_DDD_L_LBI3T0']")).click();
	  //driver.findElement(By.xpath("//input[@id='ctl00_MainContent_pnlSellerCallback_txtSellerName_I']")).sendKeys(Keys.ENTER);
	  Thread.sleep(10000);
	  // Enter required fields in "Information about the SHIP FROM (SHIPPER)" layer
	  // Select "Shipper Type"
	  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_pnlShipperCallback_cmbShipperType_I']")).click();
	  //Thread.sleep(10000);
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlShipperCallback_cmbShipperType_DDD_L_LBI1T0']")).click();
	  // Select Name
	  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_pnlShipperCallback_txtShipperName_B-1Img']")).click();
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlShipperCallback_txtShipperName_DDD_L_LBI3T0']")).click();
	  Thread.sleep(10000);
	  // Enter required fields in "Information about the SOLD TO / BUYER" layer
	  // Select "Sold to type"
	  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_pnlSoldToCallback_cmbSoldToType_I']")).click();
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlSoldToCallback_cmbSoldToType_DDD_L_LBI1T0']")).click();
	  // Select Name
	  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_pnlSoldToCallback_txtSoldToName_B-1Img']")).click();
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlSoldToCallback_txtSoldToName_DDD_L_LBI1T0']")).click();
	  Thread.sleep(10000);
	  // Enter required fields in "Information about the Destination (Ship To)" layer
	  // Select Destination Type"
	  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_pnlDestCallback_cmbDestinationType_I']")).click();
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlDestCallback_cmbDestinationType_DDD_L_LBI1T0']")).click();
	  Thread.sleep(10000);
	  // Select Name
	  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_pnlDestCallback_txtShipToName_B-1Img']")).click();
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlDestCallback_txtShipToName_DDD_L_LBI1T0']")).click();
	  Thread.sleep(10000);
	  // Enter required fields in "Information about the CUSTOMS BROKER/NOTIFY PARTY" layer
	  // Enter Name
	  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_pnlCustCallback_cmbBrokerName_B-1Img']")).click();
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlCustCallback_cmbBrokerName_DDD_L_LBI1T0']")).click();
	  Thread.sleep(10000);
	  //Enter required fields in the "Information about the 3PL" layer
	  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_pnl3PLCallback_cmb3PLName_B-1Img']")).click();
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnl3PLCallback_cmb3PLName_DDD_L_LBI1T0']")).click();
	  Thread.sleep(10000);
	  // Enter required fields in "Information about the FREIGHT FORWARDER" layer
	  // Select Name
	  driver.findElement(By.xpath("//img[@id='ctl00_MainContent_pnlFFCallback_cmbFFName_B-1Img']")).click();
	  driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlFFCallback_cmbFFName_DDD_L_LBI1T0']")).click();
	  Thread.sleep(10000);
	  // Click on "Same as Sold To" in the "Information about the BILL TO PARTY" layer
	  driver.findElement(By.xpath("//span[@id='ctl00_MainContent_chkSameAsSoldto_S_D']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_txtBPartyAttention']")).sendKeys("0369");
	  Thread.sleep(3000);
	  // Check the "Same as Destination to" checkbox in the Information about the "CONSIGNEE / OTHER CONTACT PARTY I" layer	  
	  driver.findElement(By.xpath("//span[@id='ctl00_MainContent_chkSameAsShipto_S_D']")).click();
	  Thread.sleep(10000);
	  // Click on Save and Close
	  driver.findElement(By.xpath("//span[@class = 'dx-vam' and text() = 'Save & Close']")).click();
	  // Handle ALert
	  Alert alert = driver.switchTo().alert();
	  System.out.println(alert.getText());
	  alert.accept();
	  driver.close();
  }
  
}
