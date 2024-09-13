package PageObeject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration of hospital login object by locators
	@FindBy(xpath ="//input[@id='name']" )
	protected	WebElement Hosuserid;
	@FindBy(xpath = "//input[@id='password']" )
	protected	WebElement Hospassword;
	@FindBy(xpath = "//input[@placeholder='Captcha']")
	protected WebElement Entercaptcha;
	@FindBy(xpath = "//input[@id='btnLogin']")
	protected	 WebElement HosLoginBtn;
	
	//Declaration of Authority LOGIN
	@FindBy(xpath ="//input[@id='userInput']" )
	protected	WebElement Authorityuserid;
	@FindBy(xpath ="//input[@id='inputPassword']" )
	protected	WebElement AuthorityPWD;
	@FindBy(xpath ="//a[@id='loginBtn']" )
	protected	WebElement AuthorityLoginbtn;
	@FindBy(xpath = "//input[@id='txtLoginCaptcha']")
	protected WebElement Entercaptcha1;
	
	//Initialization of object through constructor
	WebDriver driver;
    public LoginPage(WebDriver Driver)
	{
	this.driver=Driver;
	PageFactory.initElements(Driver, this);
	}
	//Utilization of object or you can say function of object 
    public void enterHosUserId(String uid) throws InterruptedException {
    	Hosuserid.sendKeys(uid);
    	Thread.sleep(5000);
    }
    public void enterHosPassword(String pwd) throws Exception {
    	Hospassword.sendKeys(pwd);
    	Thread.sleep(5000);
    }
    public void clickonHosLoginButton() throws Exception {
    	HosLoginBtn.click();
    	Thread.sleep(2000);	
     }
    //Utilization Of Auth Object
    public void enterAuthUserId(String uid) throws InterruptedException {
    	Authorityuserid.sendKeys(uid);
    	Thread.sleep(5000);
    }
    public void enterAuthPassword(String pwd) throws Exception {
    	AuthorityPWD.sendKeys(pwd);
    	Thread.sleep(5000);
    }
    public void clickonAuthLoginButton() throws Exception {
    	AuthorityLoginbtn.click();
    	Thread.sleep(2000);	
     }
    
    //For Captcha
    public void EnterCaptcha(WebDriver driver) throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * driver.get("http://192.168.10.46/bsky_tms_testI/#/login");
		 * 
		 * driver.findElement(By.xpath("//input[@id='name']"));
		 * driver.findElement(By.xpath("//input[@id='password']"));
		 * 
		 * Thread.sleep(5000);
		 */
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
			return;
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
	}
    public void EnterCaptcha1(WebDriver driver) throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
			return;
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
		//WebElement Captcha = driver.findElement(By.xpath("//input[@id='txtLoginCaptcha']"));
		Thread.sleep(4000);
		String ans = String.valueOf(result);
		Entercaptcha1.sendKeys(ans);
		Thread.sleep(2000);
		//WebElement Login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
		AuthorityLoginbtn.click();
	}
}
