package iframe;

import org.testng.annotations.Test;

import javafx.scene.layout.Priority;
import utility.Utility1;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class TestIframe {

	Utility1 obj4;
	WebDriver driver;
	
    String url="https://www.w3schools.com/html/html_iframe.asp";
    String browser="chrome";
    
    By iframeenter=By.xpath("//*[@id='main']/div[3]/iframe");
    By iframecssmenuclick=By.xpath("//*[@id='topnav']/div/div/a[4]");
    
    By parentcssmenuclick=By.xpath("//*[@id='topnav']/div/div/a[4]");
    		
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		
		obj4=new Utility1();
		driver=obj4.launchBrowser(url,browser);
		Thread.sleep(2000);	
	}

	@Test(priority=1)
	public void iframeVerification() throws InterruptedException {
		
		//get into iframe
		
		//WebElement iframeelement=driver.findElement(iframeenter);
	    //driver.switchTo().frame(iframeelement);
		obj4.iframeEnter(iframeenter);
	    Thread.sleep(2000);
	    
	    
	    // click css menu in iframe
	    obj4.click(iframecssmenuclick);
	    Thread.sleep(2000);
	    
	    
	    //exit from current frame and switch to parent frame
	    
	    //driver.switchTo().parentFrame();
	    //driver.switchTo().defaultContent();
	    obj4.iframeExit();
	    
	    
	    //click css menu in parent frame
	    obj4.click(parentcssmenuclick);
	    Thread.sleep(2000);
	    
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
