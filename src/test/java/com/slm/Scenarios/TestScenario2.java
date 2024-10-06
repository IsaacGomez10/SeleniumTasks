package com.slm.Scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.slm.Base.Hooks;
import com.slm.Locatrors.LocatorsScenario2;

public class TestScenario2 extends Hooks {
	LocatorsScenario2 loc = new LocatorsScenario2();

	WebElement elmLinkDragAndDrop = null;

	WebElement elmSliderDefault15 = null;

	WebElement elmOutputDefault15 = null;

	@Test
	public void scenario2() {
		Evidence("Index-drag-drop");
		// 2. click “Drag & Drop Sliders” under “Progress Bars & Sliders”.
		elmLinkDragAndDrop = getDriver().findElement(loc.linkDragAndDropSl);
		elmLinkDragAndDrop.click();
		
		elmSliderDefault15 = getDriver().findElement(loc.sldDefault15);
		String valueCurrentRange = elmSliderDefault15.getAttribute("value");
		System.out.println("The current range is: " + valueCurrentRange);
		Evidence("default-15");

		// slideAction(elmSliderDefault15, Integer.parseInt(valueCurrentRange), 95);
		slideJse(elmSliderDefault15, 95);

		// Verifica el cambio (opcional)
		String newRange = elmSliderDefault15.getAttribute("value");
		System.out.println("Nuevo valor del input: " + newRange);
		Evidence("new-range");
		Assert.assertEquals(newRange, "95");

	}

	public void slideAction(WebElement element, int currentValue, int targetValue) {
		Actions action = new Actions(getDriver());
		while (currentValue < targetValue) {
			action.clickAndHold(element).moveByOffset(1, 0).release().perform();
			currentValue = Integer.parseInt(element.getAttribute("value"));
		}
	}

	public void slideJse(WebElement element, int newRange) {
		// Usa JavascriptExecutor para cambiar el valor
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].value = arguments[1];", element, newRange);
	}
}
