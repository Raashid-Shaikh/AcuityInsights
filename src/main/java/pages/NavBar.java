package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class NavBar extends TestBase{

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	
	
	public NavBar() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="go812842568")
	WebElement iframe;
	
	@FindBy(xpath="//div[@id='interactive-close-button']//svg")
	WebElement closeFrame;
	
	@FindBy(id="mega-menu-item-7615")
	WebElement products;
	
	@FindBy(id="mega-menu-item-16221")
	WebElement services;
	
	@FindBy(id="mega-menu-item-7631")
	WebElement solutions;
	
	@FindBy(id="mega-menu-item-16228")
	WebElement resources;
	
	@FindBy(id="mega-menu-item-7630")
	WebElement aboutUs;
	
	@FindBy(xpath="//div[@id='search-popup']//input")
	WebElement searchBox;
	
	@FindBy(id="//img[@class='--search']")
	WebElement searchClick;
	
	@FindBy(xpath="//div[@class='post-info']//a")
	List<WebElement> searchResults;
	
	@FindBy(id="dropdownMenuButton")
	WebElement login;
	
	@FindBy(xpath="//a[@class='dropdown-item'][1]")
	WebElement applicantButton;
	
	@FindBy(xpath="//button[@class='button']")
	WebElement SignInButton;
	
	@FindBy(xpath="//div[@class='form-field'][1]//span")
	WebElement errorEmail;
	
	@FindBy(xpath="//div[@class='form-field'][2]//span")
	WebElement errorPassword;
	
	
/*
	public void handleFrame() {
		wait.until(ExpectedConditions.visibilityOf(iframe));
		if(iframe.isDisplayed()){
			closeFrame.click();
			driver.switchTo().defaultContent();
		
		}
	}
	*/
	
	public void clickOnNav() {
		
		wait.until(ExpectedConditions.visibilityOf(products));
		products.click();
		
		wait.until(ExpectedConditions.visibilityOf(services));
		services.click();
		
		wait.until(ExpectedConditions.visibilityOf(solutions));
		solutions.click();
		
		wait.until(ExpectedConditions.visibilityOf(resources));
		resources.click();
		
		wait.until(ExpectedConditions.visibilityOf(aboutUs));
		aboutUs.click();
		
		login.click();
		
	}
	
	
	public void searchNav() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.click();
		searchBox.sendKeys("one45");
		searchBox.sendKeys(Keys.ENTER);
		//searchClick.click();
		Thread.sleep(4000);
		System.out.println("Title for first 10 Search Results of one45 are :");
		
		/*
		for(int i=0;i<10; i++) {
			System.out.println(searchResults.get(i).getText());
		}
		*/
		
		int count = 0;
		for(WebElement i: searchResults) {
			System.out.println(i.getText() + '\n');
			count++;
			if(count == 10) {
				break;
			}
		}	
	}
	
	public void login() {
		
		login.click();
		wait.until(ExpectedConditions.visibilityOf(applicantButton));
		applicantButton.click();
		String currentWindow = driver.getWindowHandle();
		System.out.println(currentWindow);
		
		for(String windowSwitch: driver.getWindowHandles()) {
			driver.switchTo().window(windowSwitch);
		}
		
		wait.until(ExpectedConditions.visibilityOf(SignInButton));
		SignInButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		/*for(WebElement i: errorEmail) {
			String actualError = i.getText();
			System.out.println(actualError);
		}*/
			
	}
	
	public String validateEmailError() {
		String actualError = errorEmail.getText();
		System.out.println(actualError);
		return actualError;
	}
	
	public String validatePassError() {
		String actualError = errorPassword.getText();
		System.out.println(actualError);
		return actualError;
	}
	
	
}

