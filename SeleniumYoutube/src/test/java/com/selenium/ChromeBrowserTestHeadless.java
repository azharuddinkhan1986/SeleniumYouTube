package com.selenium;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class ChromeBrowserTestHeadless {
	
	
	public static void main(String[] args) {
		
		//set chromedriver path
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		
		//Chrome options
		ChromeOptions options=new ChromeOptions();
		
		//add argument as --headless
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		
		//get width and height of the screen using java Toolkit
		java.awt.Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		
		//Dimension class in selenium is used to help to maximize the window as per requirement of screen resolution
		Dimension d = new Dimension(width,height);
		//Resize the current window to the given dimension
		driver.manage().window().setSize(d);
		//driver.manage().window().maximize();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
         try {
			FileHandler.copy(scrFile, new File(System.getProperty("user.dir")+"/Drivers/test.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		
		
	}

}
