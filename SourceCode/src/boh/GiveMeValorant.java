package boh;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GiveMeValorant {

	public static void main(String[] args) throws InterruptedException {
		
		JFrame window= new JFrame("Twitch Message Spammer");
		JPanel Infopanel= new JPanel(new GridLayout(0,2));
		
		JTextField Streamer= new JTextField();
		JTextField Message= new JTextField();
		JLabel StreamerLabel= new JLabel("Link Canale");
		JLabel MessageLabel= new JLabel("Messaggio da Inviare");
		JTextField Time= new JTextField();
		JLabel TimeLabel= new JLabel("Time (secondi)");
		JButton avvia= new JButton();
		JButton continua= new JButton();
		JLabel Label= new JLabel("");
		avvia.setText("Avvia");
		continua.setText("Continua");
		
		Infopanel.add(StreamerLabel);
		Infopanel.add(Streamer);
		Infopanel.add(MessageLabel);
		Infopanel.add(Message);
		Infopanel.add(TimeLabel);
		Infopanel.add(Time);
		Infopanel.add(Label);
	    Infopanel.add(avvia);
		
		Infopanel.setSize(new Dimension(100,100));
		
		window.add(Infopanel);
		window.setSize(new Dimension(400, 200));
		window.setVisible(true);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		avvia.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  String currentDir = System.getProperty("user.dir");
					
			    	System.setProperty("webdriver.chrome.driver",currentDir+"\\driver\\chromedriver.exe");
			    	
					WebDriver driver = new ChromeDriver();
					
					System.out.println("ANTI AFK BY R.M. MADE FOR VALORANT KEY.");
					
					System.out.print("Inserisci il Link dello Streamer che vuoi guradare: ");
			        String baseUrl = Streamer.getText();
			        String chatMessage = Message.getText();
			        System.out.println("Apertura Twitch...");
			       
			        driver.get("https://www.twitch.tv");
			        
			        Infopanel.setVisible(false);
			        Infopanel.removeAll();
			        Infopanel.setLayout(new FlowLayout());
			        Infopanel.add(new JLabel("Accedi su Twitch e "));
			        Infopanel.add(continua);
			        Infopanel.setVisible(true);
			        continua.addActionListener(new ActionListener()
					{
						  public void actionPerformed(ActionEvent e)
						  {
							  System.out.println("Tutt appost. GLHF");
						        
						        driver.get(baseUrl);
						        
						        try {
									Thread.sleep(10000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						        
						        WebElement element   = driver.findElement(By.xpath("//*[@data-a-target='chat-input']"));
						        
						        try {
									Thread.sleep(10000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						        element.click();
						        
						        try {
									Thread.sleep(2000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						        
						        WebElement element2= driver.findElement(By.xpath("//*[@class='tw-align-items-center tw-align-middle tw-border-bottom-left-radius-large tw-border-bottom-right-radius-large tw-border-top-left-radius-large tw-border-top-right-radius-large tw-core-button tw-core-button--large tw-core-button--primary tw-full-width tw-inline-flex tw-interactive tw-justify-content-center tw-overflow-hidden tw-relative']"));
						        element2.click();
						        
						        int seconds= Integer.parseInt(Time.getText())*1000;
						        window.setState(JFrame.ICONIFIED);
						        
						       Loop loop= new Loop(driver,element,chatMessage,seconds);
						       loop.start();
						       
						       Infopanel.setVisible(false);
						       Infopanel.removeAll();
						       Infopanel.add(new JLabel("Chiudi la finestra per interrompere lo Spam, GLHF. - Ren"));
						       Infopanel.setVisible(true);
			        
			  }
			});
			        
			
		 
        		
	}

});}}
