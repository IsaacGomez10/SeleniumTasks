package com.slm.Scenarios;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.slm.Base.Hooks;
import com.slm.Locatrors.LocatorsScenario1;

public class TestScenario1 extends Hooks {
	LocatorsScenario1 loc = new LocatorsScenario1();

	WebElement elmLinkSimpleForm = null;

	WebElement elmInputEntMsg = null;

	WebElement elmBtnGetCheckVal = null;

	@Test
	public void scenario1() {
		Evidence("Index-page");
		// 2. Click “Simple Form Demo” under Input Forms.
		elmLinkSimpleForm = getDriver().findElement(loc.linkSumpleForm);
		elmLinkSimpleForm.click();

		// 3. Validate that the URL contains “simple-form-demo”.
		String currentUrl = getDriver().getCurrentUrl();
		if (currentUrl.contains("simple-form-demo")) {
			System.out.println("The current url contains 'simple-form-demo'");
			Evidence("Simple-form");
		} else {
			Evidence("Simple-form-notfound");
			fail("The current url not contains 'simple-form-demo'");
		}

		// 4. Create a variable for a string value E.g: “Welcome to LambdaTest”.
		String value = "Welcome to LambdaTest";

		// 5. Use this variable to enter values in the “Enter Message” text box.
		elmInputEntMsg = getDriver().findElement(loc.inpEnterMesage);
		elmInputEntMsg.clear();
		elmInputEntMsg.sendKeys(value);
		Evidence("send-message");
		// 6. Click “Get Checked Value”.
		elmBtnGetCheckVal = getDriver().findElement(loc.btnGetCheckedVal);
		elmBtnGetCheckVal.click();
		
		// 7. Validate whether the same text message is displayed in the right-hand
		// panel under the “Your Message:” section.
		String getMessage = getDriver().findElement(loc.pMessage).getText();
		Evidence("Simple-form-final");
		Assert.assertEquals(getMessage, value);

	}
}
