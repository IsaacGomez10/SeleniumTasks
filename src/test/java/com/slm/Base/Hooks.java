package com.slm.Base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Hooks implements ITestListener {
	private static String hubURL = "https://hub.lambdatest.com/wd/hub";

	private RemoteWebDriver driver;
	private String folderName = "";
	private String date = "";

	@Parameters({ "browsername", "testName", "os", "test-name-build" })
	@BeforeTest
	public void setUp(String browser, String testName, String os, ITestContext context, String testnamebuild)
			throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", "beta");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "isaac.21.10");
		ltOptions.put("accessKey", "N6qpy2UiaM0QyOBwvaBfgRmoGzjpI4iekS5wpDIhsMNJZ7MBO5");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("platformName", os);
		ltOptions.put("resolution", "1920x1080");
		ltOptions.put("build", testnamebuild);
		ltOptions.put("name", testName);
		ltOptions.put("selenium_version", "4.25.0");
		ltOptions.put("driver_version", "129.0.6668.22");
		ltOptions.put("console", "info");
		ltOptions.put("w3c", true);
		capabilities.setCapability("LT:Options", ltOptions);
		try {
			driver = new RemoteWebDriver(new URL(hubURL), capabilities);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		// 1. Open LambdaTest’s Selenium Playground from
		driver.get("https://www.lambdatest.com/selenium-playground");
		
		newFolder(context, testnamebuild);
	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public void Evidence(String nbEvidence) {

		File screenshotAs = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		// FileHandler fileHandler = new FileHandler();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			FileHandler.copy(screenshotAs, new File(folderName + "/" + nbEvidence + "-" + date + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void newFolder(ITestContext context, String testnamebuild) {
		date = new SimpleDateFormat("yyyy-MM-dd_HHmm-ss").format(new Date());

		String className = context.getName(); 
		folderName = testnamebuild + "/" + className + "_" + date;

		File folder = new File(folderName);
		if (!folder.exists()) {
			boolean created = folder.mkdirs();
			if (created) {
				System.out.println("Directory created: " + folder.getAbsolutePath());
			} else {
				System.out.println("Directory already exists");
			}
		}
	}
}
