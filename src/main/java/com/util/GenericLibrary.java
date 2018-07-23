package com.util;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class GenericLibrary {

	public static void click(WebDriver driver, WebElement element) {
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
		catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			element.click();
		}
	}

	public static void switchToNewWindow(WebDriver driver) {
		Set s = driver.getWindowHandles();
		Iterator itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		driver.switchTo().window(w2);
	}

	public static void switchToOldWindow(WebDriver driver) {
		Set s = driver.getWindowHandles();
		Iterator itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		driver.switchTo().window(w1);
	}

	public static void switchToParentWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForAlertPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitForListOfElementsVisibility(WebDriver driver, List<WebElement> list) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}

	public static void setWindowSize(WebDriver driver, int Dimension1, int dimension2) {
		driver.manage().window().setSize(new Dimension(Dimension1, dimension2));

	}

	public static void pressKeyDown(WebElement element) {
		element.sendKeys(Keys.DOWN);
	}

	public void pressKeyEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	public static void pressKeyUp(WebElement element) {
		element.sendKeys(Keys.UP);
	}

	public static void moveToTab(WebElement element) {
		element.sendKeys(Keys.chord(Keys.ALT, Keys.TAB));
	}

	public static void keyboardEvents(WebElement webelement, Keys key, String alphabet) {
		webelement.sendKeys(Keys.chord(key, alphabet));

	}

	public static void clickMultipleElements(WebDriver driver, WebElement someElement,
			WebElement someOtherElement) {
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(someElement)
		.click(someOtherElement).keyUp(Keys.CONTROL).build().perform();
	}

	public static void highlightelement(WebDriver driver, WebElement element) {
		for (int i = 0; i < 4; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute(‘style’, arguments[1]);",
					element, "color: solid red; border: 6px solid yellow;");
			js.executeScript(
					"arguments[0].setAttribute(‘style’, arguments[1]);",
					element, "");
		}
	}

	public static boolean checkAlert_Accept(WebDriver driver) {
		try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			System.out.println(str);
			a.accept();
			return true;

		} catch (Exception e) {
			System.out.println("no alert");
			return false;
		}
	}

	public static boolean checkAlert_Dismiss(WebDriver driver) {
		try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			System.out.println(str);
			a.dismiss();
			return true;
		} catch (Exception e) {
			System.out.println("no alert ");
			return false;
		}
	}

	public static void checkbox_Checking(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			System.out.println("Checkbox is already checked");
		} else {
			checkbox.click();
			System.out.println("Checked the checkbox");
		}
	}

	public static void radiobutton_Select(WebElement Radio) {
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			System.out.println("RadioButton is already checked");
		} else {
			Radio.click();
			System.out.println("Selected the Radiobutton");
		}
	}

	// Unchecking
	public static void checkbox_Unchecking(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			checkbox.click();
			System.out.println("Checkbox is unchecked");
		} else {
			System.out.println("Checkbox is already unchecked");
		}
	}

	public static void radioButton_Deselect(WebElement Radio) {
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			Radio.click();
			System.out.println("Radio Button is deselected");
		} else {
			System.out.println("Radio Button was already Deselected");
		}
	}

	public static void dragAndDrop(WebDriver driver, WebElement fromWebElement, WebElement toWebElement) {
		Actions builder = new Actions(driver);
		builder.dragAndDrop(fromWebElement, toWebElement).perform();
	}

	public static void dragAndDrop_Method2(WebDriver driver, WebElement fromWebElement, WebElement toWebElement) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(fromWebElement)
				.moveToElement(toWebElement).release(toWebElement).build();
		dragAndDrop.perform();
	}

	public static void dragAndDrop_Method3(WebDriver driver, WebElement fromWebElement, WebElement toWebElement) throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.clickAndHold(fromWebElement).moveToElement(toWebElement)
		.perform();
		Thread.sleep(2000);
		builder.release(toWebElement).build().perform();
	}

	public static void hoverWebelement(WebDriver driver, WebElement HovertoWebElement)
			throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(HovertoWebElement).perform();
		Thread.sleep(2000);

	}

	public static void doubleClickWebelement(WebDriver driver, WebElement doubleclickonWebElement)throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.doubleClick(doubleclickonWebElement).perform();
		Thread.sleep(2000);
	}

	public static String getToolTip(WebElement toolTipofWebElement)
			throws InterruptedException {
		String tooltip = toolTipofWebElement.getAttribute("title");
		System.out.println("Tool text : " + tooltip);
		return tooltip;
	}

	public static void selectElementByVisibleText(WebElement element, String Name) {
		Select selectitem = new Select(element);
		selectitem.selectByVisibleText(Name);
	}

	public static void selectElementByValue(WebElement element, String value) {
		Select selectitem = new Select(element);
		selectitem.selectByValue(value);
	}

	public static void selectElementByIndex(WebElement element, int index) {
		Select selectitem = new Select(element);
		selectitem.selectByIndex(index);
	}

	public static void clickCheckboxFromList(WebDriver driver, String xpathOfElement, String valueToSelect) {

		List<WebElement> lst = driver.findElements(By.xpath(xpathOfElement));
		for (int i = 0; i < lst.size(); i++) {
			List<WebElement> dr = lst.get(i).findElements(By.tagName("label"));
			for (WebElement f : dr) {
				System.out.println("value in the list : " + f.getText());
				if (valueToSelect.equals(f.getText())) {
					f.click();
					break;
				}
			}
		}
	}

	public static void uploadFile(WebElement browseButton, String filePath) throws Exception {
		StringSelection sel2 = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel2,null);
		System.out.println("selection" +sel2);
		Thread.sleep(1000);
		browseButton.click();
		System.out.println("Browse button clicked");
		Robot robot2 = new Robot();
		Thread.sleep(1000);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		robot2.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	public static void downoadFile(WebElement downloadButton) throws Exception {
		downloadButton.click();   
		Thread.sleep(2000);   
		Robot robot = new Robot();   
		//For clicking on the Ok button on the dialog box   
		robot.keyPress(KeyEvent.VK_ENTER);    
		robot.keyRelease(KeyEvent.VK_ENTER);    
		Thread.sleep(2000);   
		//For clicking on Ok button on the dialog box which appears(not necessary)   
		//while saving file in a specific location.   
		robot.keyPress(KeyEvent.VK_ENTER);    
		robot.keyRelease(KeyEvent.VK_ENTER);    
		Thread.sleep(2000);   
		//For navigating to Yes button,if a prompt says that the file already   
		//exists in the location   
		robot.keyPress(KeyEvent.VK_LEFT);    
		robot.keyRelease(KeyEvent.VK_LEFT);    
		Thread.sleep(2000);   
		//For clicking on Ok button   
		robot.keyPress(KeyEvent.VK_ENTER);    
		robot.keyRelease(KeyEvent.VK_ENTER);    
	}

	public static void downloadFile(WebDriver driver, String href, String fileName)
			throws Exception {
		URL url = null;
		URLConnection con = null;
		int i;
		url = new URL(href);
		con = url.openConnection();
		File file = new File(".//OutputData//" + fileName);
		BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(file));
		while ((i = bis.read()) != -1) {
			bos.write(i);
		}
		bos.flush();
		bis.close();
	}

	public static void navigateToEveryLinkInPage(WebDriver driver) throws InterruptedException {
		List<WebElement> linksize = driver.findElements(By.tagName("a"));
		int linksCount = linksize.size();
		System.out.println("Total no of links Available: " + linksCount);
		String[] links = new String[linksCount];
		System.out.println("List of links Available: ");
		// print all the links from WebPage
		for (int i = 0; i < linksCount; i++) {
			links[i] = linksize.get(i).getAttribute("href");
			System.out.println(linksize.get(i).getAttribute("href"));
		}
		// navigate to each Link on the WebPage
		for (int i = 0; i < linksCount; i++) {
			driver.navigate().to(links[i]);
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
		}
	}

	public static void scrollIntoView(WebDriver driver, WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public static void moveToElement(WebDriver driver, WebElement ele) {
		Actions a=new Actions(driver);
		a.moveToElement(ele).build().perform();
	}

	//==============================================================================================

	public static void check(WebElement checkBox) {
		if (!checkBox.isSelected())
			checkBox.click();
	}

	@SuppressWarnings("deprecation")
	public void fluentWait(WebDriver driver, WebElement element, int timeoutInSeconds){
		new FluentWait<WebDriver>(driver)
		.withTimeout(30, TimeUnit.SECONDS)
		.pollingEvery(1, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOf(element));
	}

	public static String getAllOptionsDropdown(WebElement element) {
		Select selectList = new Select(element);
		List<WebElement> options = selectList.getOptions();
		String value = "";
		for (WebElement option : options) {
			value = value + option.getAttribute("value");
		}
		return value;
	}

	public static long getTime() {
		return System.currentTimeMillis();
	}

	protected static String getWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	protected static Set<String> getWindowHandles(WebDriver driver) {
		return driver.getWindowHandles();
	}

	public void scrollBottom(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight); return true");
		try { wait(2); }catch(Exception e){}
	}

	public void scrollTop(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0); return true");
		try { wait(2); }catch(Exception e){}
	}

	public void scrollCenter(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight/2); return true");
		try { wait(2); }catch(Exception e){}
	}

	public void scrollPage(WebDriver driver, int xValue, int yValue) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + xValue + "," + yValue + ")", "");
		try { wait(2); }catch(Exception e){}
	}

	public void selectFromListBox(List<WebElement> elementList, String selection) {
		try {
			for (WebElement element : elementList) {
				if (element.getText().trim().equalsIgnoreCase(selection)) {
					element.click();
					break;
				}
			}
		} catch (Exception e) {
			Reporter.log("Error : [" + selection + "] is not present in the list box or list box contains no value : "
					+ e.getLocalizedMessage(), true);
		}
	}

	public static void Wait(WebDriver driver, WebElement element, int timeoutInSeconds)
			throws HeadlessException, IOException, AWTException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			//Thread.sleep(2000);
			Reporter.log("Waiting for " + element + " for " + timeoutInSeconds + " seconds.",true);
		} catch (Exception e) {
			Reporter.log(e.getMessage(),true);
			// Fail the test
			assertTrue(false);
		}
	}

	public static void WebDriverExplicitWait(WebDriver driver, int timeoutInSeconds, String by, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		if (by.equalsIgnoreCase("id"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		if (by.equalsIgnoreCase("name"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
		if (by.equalsIgnoreCase("tagName"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
		if (by.equalsIgnoreCase("className"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
		if (by.equalsIgnoreCase("linkText"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
		if (by.equalsIgnoreCase("partialLinkText"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
		if (by.equalsIgnoreCase("cssSelector"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
		if (by.equalsIgnoreCase("xpath"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	//=============================================================================================
	
	public static void waitForElement(WebDriver driver, By selector) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
		} catch (TimeoutException e) {
			fail("Could not locate element");
		}
	}
	
	public static boolean waitForContent(WebDriver driver, By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
		} catch (TimeoutException e) {
			fail("Could not locate element");
		}
		long startTime = System.currentTimeMillis();
		long duration = 3000; // 1.5 seconds
		while(true) {
			long currentTime = System.currentTimeMillis();
			if(currentTime > (startTime+duration)) {
				break;
			}
			if(!driver.findElement(element).getText().equals("")) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
}
