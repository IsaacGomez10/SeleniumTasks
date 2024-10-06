package com.slm.Scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.slm.Base.Hooks;
import com.slm.Locatrors.LocatorsScenario3;

public class TestScenario3 extends Hooks {
	LocatorsScenario3 loc = new LocatorsScenario3();

	WebElement elmLinkInputSimpleForm = null;

	WebElement elmInpName = null;
	WebElement elmInpEmail = null;
	WebElement elmInpPassword = null;
	WebElement elmInpCompany = null;
	WebElement elmInpWebSite = null;
	WebElement elmSlcCountry = null;
	WebElement elmInpCity = null;
	WebElement elmInpAdress1 = null;
	WebElement elmInpAdress2 = null;
	WebElement elmInpState = null;
	WebElement elmInpZip = null;

	WebElement elmBtnSubmit = null;

	@Test
	public void scenario3() {
		Evidence("Index-input-form-submit");
		// 1.click “Input Form Submit” under “Input Forms”.
		elmLinkInputSimpleForm = getDriver().findElement(loc.linkInputFormSmt);
		elmLinkInputSimpleForm.click();

		Evidence("Start-without-fill");
		System.out.println("*** ---> Start without fill files");
		elmInpName = getDriver().findElement(loc.inpName);

		elmBtnSubmit = getDriver().findElement(loc.btnSubmit);
		elmBtnSubmit.click();
		
		// Usar JavascriptExecutor para obtener el mensaje de validación
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", elmInpName);
		// Imprimir el mensaje de validación
		System.out.println("*** Validation Message: " + validationMessage);
		Evidence("msg-input");
		Assert.assertEquals(validationMessage, "Please fill out this field.");

		System.out.println("*** ---> Start to fill files");
		elmInpEmail = getDriver().findElement(loc.inpEmail);
		elmInpPassword = getDriver().findElement(loc.inpPassword);
		elmInpCompany = getDriver().findElement(loc.inpCompany);
		elmInpWebSite = getDriver().findElement(loc.inpWebSite);
		elmSlcCountry = getDriver().findElement(loc.slcCountry);
		elmInpCity = getDriver().findElement(loc.inpCity);
		elmInpAdress1 = getDriver().findElement(loc.inpAdress1);
		elmInpAdress2 = getDriver().findElement(loc.inpAdress2);
		elmInpState = getDriver().findElement(loc.inpState);
		elmInpZip = getDriver().findElement(loc.inpZip);
		
		Evidence("Start-to-fill-files");
		
		elmInpName.sendKeys("Isaac");
		elmInpEmail.sendKeys("prueba@email.com");
		elmInpPassword.sendKeys("123456");
		elmInpCompany.sendKeys("TestTest SAS");
		elmInpWebSite.sendKeys("MyWebPage.com");

		Select slcCountry = new Select(elmSlcCountry);
		slcCountry.selectByVisibleText("United States");

		elmInpCity.sendKeys("New York");
		elmInpAdress1.sendKeys("street 28");
		elmInpAdress2.sendKeys("avenue 78");
		elmInpState.sendKeys("Florida");
		elmInpZip.sendKeys("1932032");
		
		Evidence("filling-files");
		elmBtnSubmit.click();

		String msg = getDriver().findElement(loc.msgSuccess).getText();
		Assert.assertEquals(msg, "Thanks for contacting us, we will get back to you shortly.");
		Evidence("msg-success");
		System.out.println("*** " + msg);

	}
}
