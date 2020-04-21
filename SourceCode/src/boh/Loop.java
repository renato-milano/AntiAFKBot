package boh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loop extends Thread {
	
	private WebElement element;
	private WebDriver driver;
	private String Message;
	private int seconds;
	
	public Loop(WebDriver driver,WebElement element, String Message, int Seconds) {
		
		this.element=element;
		this.driver= driver;
		this.Message= Message;
		this.seconds=Seconds;
		
	}
	
	 public void run(){
	       
		 while(true) {
     		element.clear();
     		element.sendKeys(Message);
     		WebElement button = driver.findElement(By.xpath("//*[@data-a-target='chat-send-button']"));
     		button.click();
     		try {
					Thread.sleep(seconds);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	  }
		 
	    }
	
}
