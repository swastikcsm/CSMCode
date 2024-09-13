package Annotation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import net.sourceforge.tess4j.TesseractException;


public class BrowserFactory 
{
	public  static WebDriver driver ;

	
	public  static WebDriver setupHos() throws InterruptedException, Exception, TesseractException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("http://192.168.10.46/bsky_tms_testI/#/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("21173025");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin@123");
		Thread.sleep(20000);
		return CaptchacodeForHos();
	}
	public  static WebDriver setupAuth() throws InterruptedException, Exception, TesseractException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("http://192.168.10.46/bsky_portal_testI/#/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='userInput']")).sendKeys("karaputdc");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("Admin@123");
		Thread.sleep(20000);
		//Captcha Code
		return CaptchacodeForAuth();
	}
	public  static WebDriver setupAuth2() throws InterruptedException, Exception, TesseractException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("http://192.168.10.46/bsky_portal_testI/#/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='userInput']")).sendKeys("anuguldc");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("Admin@123");
		Thread.sleep(20000);
		//Captcha Code
		return CaptchacodeForAuth();
	}
	public  static WebDriver setupChildHos() throws InterruptedException, Exception, TesseractException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("http://192.168.10.46/bsky_tms_testI/#/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("21162002");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin@123");
		Thread.sleep(20000);
		//Captcha Code
		return CaptchacodeForHos();
	}
	public  static WebDriver setupAsThirdHos() throws InterruptedException, Exception, TesseractException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("http://192.168.10.46/bsky_tms_testI/#/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("21177033");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin@123");
		Thread.sleep(20000);
		return CaptchacodeForHos();
	}
	
////////////////FOR CAPTCHA CODE////////////////////////////////////////////////////////
	public static WebDriver CaptchacodeForHos() throws InterruptedException{
		WebElement Question = driver.findElement(By.xpath("//h2[@id='loginCaptchaImg']"));
		String str = Question.getText();
		System.out.println(str);
		// 9 + 1
		// 1 2 3 4 5
		String S1 = str.substring(0, 1);
		System.out.println(S1);
		String S2 = str.substring(4, 5);
		System.out.println(S2);
		String S3 = str.substring(2, 3);
		System.out.println(S3);

		Integer i1 = Integer.valueOf(S1);
		Integer i2 = Integer.valueOf(S2);
		String operator = String.valueOf(S3);
		int result = 0;
		Thread.sleep(2000);

		if (operator == null) {
			System.out.println("Operator is null. Please provide a valid operator.");
			return driver;//changed here
		}

		switch (operator) {

		case "+":
			result = i1 + i2;
			break;

		case "-":
			result = i1 - i2;
			break;
		case "*":
			result = i1 * i2;
			break;
		case "/":
			result = i1 / i2;
			break;
		default:
			System.out.println("Invalid opertor");
		}
		System.out.println("Result: " + result);
		WebElement Captcha = driver.findElement(By.xpath("//*[@id=\"captcha\"]"));
		Thread.sleep(4000);
		String ans = String.valueOf(result);
		Captcha.sendKeys(ans);
		Thread.sleep(2000);
		WebElement Login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
		Login.click();
		return driver;
		// Captchacode end
	}
	public static WebDriver CaptchacodeForAuth() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement Question = driver.findElement(By.xpath("//div[@id='loginCaptchaImg']"));
		String str = Question.getText();
		System.out.println(str);
		// 9 + 1
		// 1 2 3 4 5
		String S1 = str.substring(0, 1);
		System.out.println(S1);
		String S2 = str.substring(4, 5);
		System.out.println(S2);
		String S3 = str.substring(2, 3);
		System.out.println(S3);

		Integer i1 = Integer.valueOf(S1);
		Integer i2 = Integer.valueOf(S2);
		String operator = String.valueOf(S3);
		int result = 0;
		Thread.sleep(2000);

		if (operator == null) {
			System.out.println("Operator is null. Please provide a valid operator.");
			return driver;
		}

		switch (operator) {

		case "+":
			result = i1 + i2;
			break;

		case "-":
			result = i1 - i2;
			break;
		case "*":
			result = i1 * i2;
			break;
		case "/":
			result = i1 / i2;
			break;
		default:
			System.out.println("Invalid opertor");
		}
		System.out.println("Result: " + result);
		WebElement Entercaptcha1 = driver.findElement(By.xpath("//input[@id='txtLoginCaptcha']"));
		Thread.sleep(4000);
		String ans = String.valueOf(result);
		Entercaptcha1.sendKeys(ans);
		Thread.sleep(2000);
		WebElement AuthorityLoginbtn = driver.findElement(By.xpath("//a[@id='loginBtn']"));
		AuthorityLoginbtn.click();
		return driver;
	}
}


