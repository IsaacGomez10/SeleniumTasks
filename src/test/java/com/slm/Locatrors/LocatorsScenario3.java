package com.slm.Locatrors;

import org.openqa.selenium.By;

public class LocatorsScenario3 {
	public By linkInputFormSmt = By.linkText("Input Form Submit");

	public By inpName = By.id("name");
	public By inpEmail = By.id("inputEmail4");
	public By inpPassword = By.id("inputPassword4");
	public By inpCompany = By.id("company");
	public By inpWebSite = By.id("websitename");
	public By slcCountry = By.cssSelector("select[name='country']");
	public By inpCity = By.id("inputCity");
	public By inpAdress1 = By.id("inputAddress1");
	public By inpAdress2 = By.id("inputAddress2");
	public By inpState = By.id("inputState");
	public By inpZip = By.id("inputZip");
	
	public By msgSuccess = By.cssSelector("p.success-msg.hidden");
	
	public By btnSubmit = By.xpath("//button[text()='Submit']");

}
