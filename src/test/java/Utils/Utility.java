package Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility
{
	WebDriver driver;

		//Select Class
		public void selectbyvisibletext(WebElement element , String text)
		{
			Select select=new Select(element);
			select.selectByVisibleText(text);
		}
		public boolean isdisplayed(By locator) {
			return findElement(locator).isDisplayed();
		}
		
		//Actions Class
		public void movetoelement(WebDriver driver , WebElement element)
		{
			Actions actions=new Actions(driver);
			actions.moveToElement(element).perform();
		}
		
		public void clickonelement(WebDriver driver , WebElement element)
		{
			Actions actions=new Actions(driver);
			actions.moveToElement(element).click().perform();
		}
		
		//Alert Interface
		public void alertaccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		public void alertdismiss(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();;
		}
		
		//Robot Class
		public void robotenter() throws AWTException
		{
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		
		//ChromeOptions Class
		public void headless()
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
		}
		
		//JavascriptExecutor Interface
		public void javascriptclick(WebDriver driver , WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", element);
		}
		
		public void javascriptenter(WebDriver driver , WebElement element , String value)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript(value, element);
		}
		
		//WebDriverWait Class
		public void webdriverwaittitleis(WebDriver driver , String title)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs(title));
		}
		
		public void webdriverwaittitlecontains(WebDriver driver , String title)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleContains(title));
		}
		
		public void webdriverwaitvisibilityof(WebDriver driver , WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public void webdriverwaitvisibilitybylocator(WebDriver driver , By locator)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		
		public void webdriverwaitstaleness(WebDriver driver , WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.stalenessOf(element));
		}

		//WebDriver Interface
		public void gettitle(WebDriver driver , String expectedTitle)
	{
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);	
	}
	
		//validation
		public WebElement findElement(WebElement element) //done later
		{
			return driver.findElement((By) element);
		}
		public WebElement findElement(By locator) 
		{
			return driver.findElement(locator);
		}
		public void click(By locator)
		{
			findElement(locator).click();
		}
		
    public boolean isAlphanumeric(By textboxLocator) 
    {
	WebElement textBox = findElement(textboxLocator);
	String text = textBox.getAttribute("value");
	return text.matches("^[a-zA-Z0-9]+$");
    }

    public boolean isNumericOnly(By textboxLocator) 
    {
	WebElement textBox = findElement(textboxLocator);
	String text = textBox.getAttribute("value");
	return text.matches("^[0-9]+$");
    }

    public boolean isAlphabetOnly(By textboxLocator)
    {
	WebElement textBox = findElement(textboxLocator);
	String text = textBox.getAttribute("value");
	return text.matches("^[a-zA-Z]+$");
     }

    public boolean containsSqlCharacters(By textboxLocator) 
    {
	WebElement textBox = findElement(textboxLocator);
	String text = textBox.getAttribute("value");
	return text.matches(".*[;:'\"\\\\].*");
    }

    public boolean containsSpecialCharacters(By textboxLocator) 
    {
	WebElement textBox = findElement(textboxLocator);
	String text = textBox.getAttribute("value");
	return !text.matches("^[a-zA-Z0-9]+$");
    }

    public boolean isTextLengthWithinLimit(By textBoxLocator, int maxLength) 
    {
	WebElement textBox = findElement(textBoxLocator);
	String text = textBox.getAttribute("value");
	return text.length() <= maxLength;
    }

    public boolean doesTextBoxStartWithWhitespace(By textBoxLocator) 
    {
	WebElement textBox = findElement(textBoxLocator);
	String text = textBox.getAttribute("value");
	return text.matches("^\\s.*");
    }

    public boolean doesTextBoxContainWhitespaceInMiddle(By textBoxLocator) 
    {
	WebElement textBox = findElement(textBoxLocator);
	String text = textBox.getAttribute("value");
	return text.matches(".*\\s+.*");
    }
    
	public void ScrolltoDown (WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		//js.executeScript("window.scrollBy(0,-1000)");
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void ScrollToUp ( WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("window.scrollBy(0,-1000)");
	}

	public void clearTextbox(By textboxLocator) {
		WebElement textBox = findElement(textboxLocator);
		textBox.clear();
	}

	public void sendKeys(By locator, String text) {
		findElement(locator).sendKeys(text);
	}

	public String getText(By locator) {
		return findElement(locator).getText();
	}
	
	public void selectDropdownOptionByValue(By dropdownLocator, String optionValue) {
		WebElement dropdownElement = findElement(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue(optionValue);
	}

	public void selectDropdownByVisibleText(WebElement element, String visibleText) {
		WebElement dropdownElement = findElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(visibleText);
	}
	public void selectDropdownByVisibleText(By dropdownLocator, String visibleText) {
		WebElement dropdownElement = findElement(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(visibleText);
	}
	public void waitForElementVisible(By locator, Duration timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void OTPValidation(WebElement locator, Duration timeoutInSeconds) 
	{
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds); // Adjust the timeout as needed
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return locator.getAttribute("value").length() == 6;
			}
		});
	}
	
public static void waitForOTPInput(WebDriver driver, WebElement locator, Duration timeout) {
		 WebDriverWait wait = new WebDriverWait(driver, timeout);
	        wait.until(new ExpectedCondition<Boolean>() {
	            @Override
	            public Boolean apply(WebDriver driver) {
	                String otpValue = locator.getAttribute("value");
	                return otpValue != null && otpValue.length() == 6;
	            }
	    }  );    
	 }

	//choose file done by robot class
		public  void choseFile(String Data) throws AWTException, InterruptedException {

			StringSelection ss = new StringSelection(Data);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); //copy the above string to clip board     
			Robot robot;
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(2000); 
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL); //paste the copied string into the dialog box
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);



			}
			
	
		
}	

