package org.elango;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassMethods {

	public static WebDriver driver;

	public Actions actions;
	// public Robot robot;
	public Alert alert;
	public JavascriptExecutor executor;

	public WebDriver get() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;

	}

	public void launch(String url) {
		driver.get(url);
	}

	public void windowMaximize() {
		driver.manage().window().maximize();

	}

	public WebElement xpath(String xpathvalue) {
		WebElement refName = driver.findElement(By.xpath(xpathvalue));
		return refName;

	}

	public WebElement id(String xpathvalue) {
		WebElement refName = driver.findElement(By.id(xpathvalue));
		return refName;

	}

	public WebElement name(String xpathvalue) {
		WebElement refName = driver.findElement(By.name(xpathvalue));
		return refName;

	}

	public WebElement className(String xpathvalue) {
		WebElement refName = driver.findElement(By.className(xpathvalue));
		return refName;

	}

	public void title() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public void url() {
		String url = driver.getCurrentUrl();
		System.out.println(url);

	}

	public void text(WebElement refName) {
		String text = refName.getText();
		System.out.println(text);

	}

	public void attribute(WebElement refName) {
		String attribute = refName.getAttribute("Value");
		System.out.println(attribute);

	}

	public void close() {
		driver.close();

	}

	public void quit() {
		driver.quit();

	}

	public void sendkeys(WebElement refName, String value) {
		refName.sendKeys(value);

	}

	public void click(WebElement refName) {
		refName.click();

	}

	public void to(String url) {
		driver.navigate().to(url);

	}

	public void back() {
		driver.navigate().back();

	}

	public void forward() {
		driver.navigate().forward();

	}

	public void refresh() {
		driver.navigate().refresh();

	}

	public void move(WebElement refName) {
		Actions actions = new Actions(driver);
		actions.moveToElement(refName).perform();

	}

	public void dragDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();

	}

	public void rightClick(WebElement refName) {
		Actions actions = new Actions(driver);
		actions.contextClick(refName).perform();

	}

	public void doubleClick(WebElement refName) {
		Actions actions = new Actions(driver);
		actions.doubleClick(refName).perform();
	}

	public void keyBoardShift(WebElement refName, String values) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys(refName, values).keyUp(Keys.SHIFT).perform();

	}

	public void keyBoardTab(WebElement refName, String values) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.TAB).sendKeys(refName, values).keyUp(Keys.TAB).perform();

	}

	public void sendKeysEnter(WebElement refName, String value) {
		refName.sendKeys(value, Keys.ENTER);

	}

	public void robot() throws AWTException {
		Robot robot = new Robot();

	}

	public void keyPressShift() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SHIFT);
	}

	public void keyReleaseShift() throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(KeyEvent.VK_SHIFT);

	}

	public void keyPressTAB() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
	}

	public void keyReleaseTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(KeyEvent.VK_TAB);

	}

	public void keyPressEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	public void keyReleaseEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void keyPressAndRelease(String A) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);

	}

	public void simpleAlert() {
		alert = driver.switchTo().alert();
		alert.accept();

	}

	public void confirmAlert() {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void promptAlert(String value) {
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	// public File screenShot() {
	// TakesScreenshot refName = (TakesScreenshot)driver;
	// File s = refName.getScreenshotAs(OutputType.FILE);
	// return s;
	//
	// }
	public static void multipleScreenShot(String name, String location) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(location);
		FileUtils.copyFile(source, dest);

	}

	public void particularScreenshot(String location, WebElement refName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = refName.getScreenshotAs(OutputType.FILE);
		File dest = new File(location);
		FileUtils.copyFile(source, dest);

	}

	public void javaScriptInsert(String value, WebElement refName) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(value, refName);
		// return executor;

	}

	public void javaScriptAttribute(WebElement refName) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object attribute = executor.executeScript("return arguments[0].getAttribute('value')", refName);
		System.out.println(attribute);

	}

	public void javaScriptClick(WebElement refName) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", refName);

	}

	public void javaScriptScrollDown(WebElement refName) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", refName);

	}

	public void javaScriptScrollUp(WebElement refName) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", refName);

	}

	public void selectByIndex(WebElement refName, int a) {
		Select s = new Select(refName);
		s.selectByIndex(a);

	}

	public void selectByValue(WebElement refName, String numerical) {
		Select s = new Select(refName);
		s.selectByValue(numerical);

	}

	public void selectByVisibleText(WebElement refName, String text) {
		Select s = new Select(refName);
		s.selectByVisibleText(text);

	}

	public void selectGetOptions(WebElement refName) {
		Select s = new Select(refName);
		List<WebElement> s1 = s.getOptions();
		int size = s1.size();
		System.out.println(size);
	}

	public void windowHandle() {
		String parent = driver.getWindowHandle();
		System.out.println(parent);

	}
	public void windowHandles() {
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

	}
	public void threadSleep(long l) throws InterruptedException {
		Thread.sleep(l);
}

	public void implicitWait(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

	}
	public void fluentWait(int a, int b) {
		Wait w = new FluentWait(driver).withTimeout(Duration.ofSeconds(a)).pollingEvery(Duration.ofSeconds(b))
				.ignoring(Throwable.class);

	}
	public void switchToFrame(WebElement refName) {
		driver.switchTo().frame(refName);
	}
	public void switchToFrameByIndex(int i) {
		driver.switchTo().frame(i);
	}
	public void frameCount(String value) {
		List<WebElement> frameCount = driver.findElements(By.tagName(value));
		int size = frameCount.size();
		System.out.println(size);
	}
public void tagName(String name, String value) {
		List<WebElement> ref = driver.findElements(By.tagName(value));
		int size = ref.size();
		System.out.println(size);
	}

}
