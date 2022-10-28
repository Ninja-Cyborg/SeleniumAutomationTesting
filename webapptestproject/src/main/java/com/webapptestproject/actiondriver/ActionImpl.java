package com.webapptestproject.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import com.webapptestproject.base.Base;
import com.webapptestproject.exceptions.ElementNotFoundException;

public class ActionImpl extends Base implements Action{

	@Override
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("window.scrollBy(0,290)", element);
	}

	@Override
	public void click(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
	}

	@Override
	public boolean isDisplayed(WebDriver driver, WebElement element) {
		boolean flag = false;
		flag = findElement(driver, element);
		if(flag) {
			flag = element.isDisplayed();
			if(flag) {
				System.out.println("Element Displayed");
			} else {
				System.out.println("Element not Displayed");
			}
		} else {
			System.out.println("Not displayed");
		}
		
		return flag;
	}

	@Override
	public boolean type(WebElement element, String text) {
		boolean flag = false;
		try {
			flag = element.isDisplayed();
			element.clear();
			element.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}
		}
		
		return flag;
	}

	@Override
	public boolean findElement(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			 element.isDisplayed();
			 flag = true;
		} catch(Exception e) {
			flag = false;
		} finally {
			if(flag) {
				System.out.println("Found the element");
			} else {
				System.out.println("Element Not Found");
			}
		}
		
		return flag;
	}

	@Override
	public boolean isSelected(WebDriver driver, WebElement element) {
		boolean flag = false;
		flag = findElement(driver, element);
		if (flag) {
			flag = element.isSelected();
			if (flag) {
				System.out.println("Element is Selected");
			} else {
				System.out.println("Element not Selected");
			}
		} else {
			System.out.println("Not selected ");
		}
		
		return flag;
	}

	@Override
	public boolean isEnabled(WebDriver driver, WebElement element) {
		boolean flag = false;
		flag = findElement(driver, element);
		if (flag) {
			flag = element.isEnabled();
			if (flag) {
				System.out.println("Element is Enabled");
			} else {
				System.out.println("Element not Enabled");
			}
		} else {
			System.out.println("Not Enabled ");
		}
		return flag;
	}

	// Select methods
	@Override
	public boolean selectBySendkeys(String value, WebElement element) {
		boolean flag = false;
		try {
			element.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the DropDown");		
			} else {
				System.out.println("DropDown Not Found");
			}
		}
		
	}

	@Override
	public boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Index");
			} else {
				System.out.println("Option not Selected [selectByIndex]");
			}
		}
		
	}

	@Override
	public boolean selectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
		
	}

	@Override
	public boolean selectByVisibleText(WebElement element, String visibletext) {
		boolean flag = false;
		try {
			Select select = new Select(element);
			select.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
		
	}

	@Override
	public boolean mouseHoverByJavaScript(WebDriver driver, WebElement locator) {
		boolean flag = false;
		try {
			WebElement mouseLoc = locator;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mouseLoc);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("MouseHover succesfull");
			} else {
				System.out.println("MouseHover failed");
			}
		}
		
	}

	@Override
	public boolean JSClick(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			flag = true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		
		return flag;
	}

	@Override
	public boolean switchToFrameByIndex(WebDriver driver, int index) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.
							visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame selected with index " + index );
			} else {
				System.out.println("Frame selection failed for index " + index );
			}
		}
		
	}

	@Override
	public boolean switchToFrameById(WebDriver driver, String id) {
		boolean flag = false;
		try {
			driver.switchTo().frame(id);
			flag = true;
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Frame selected with id " + id);
			} else {
				System.out.println("Frame selection failed for id \"" + id );
			}
		}
		
	}

	@Override
	public boolean switchToFrameByName(WebDriver driver, String name) {
		boolean flag = false;
		try {
			driver.switchTo().frame(name);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame select with name " + name);
			} else if (!flag) {
				System.out.println("Frame selection failed with name " + name );
			}
		}
		
	}

	@Override
	public boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Frame switch success");
			} else if (!flag) {
				System.out.println("Frame switch failed");
			}
		}
		
	}

	@Override
	public void mouseOverElement(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserHover sucess");
			} else {
				System.out.println("MouseHover failed");
			}
		}
		
	}

	@Override
	public boolean moveToElement(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
	//		actions.scrollToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean mouseover(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {	
		}
		
	}

	@Override
	public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Draggable Action success"+source);			
			} else if(!flag) {
				System.out.println("Draggable Action failed"+ source);
			}
		}
		
	}

	@Override
	public boolean dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("DragAndDrop Action Success");
			} else if(!flag) {
				System.out.println("DragAndDrop Action Failed");
			}
		}
		
	}

	@Override
	public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Slider Action succesfull");
			} else {
				System.out.println("Slider Action failed");
			}
		}
	}

	@Override
	public boolean rightclick(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(element).perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("RightClick Action Successful");
			} else {
				System.out.println("RightClick Action Failed");
			}
		}
		
	}

	@Override
	public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();
			String[] array = windowList.toArray(new String[0]);
			driver.switchTo().window(array[count-1]);
			if (driver.getTitle().contains(windowTitle)){
				flag = true;
			}else{
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("SwitchingWindowByTitle Successfull");
			} else {
				System.out.println("Element not Found to SwitchingWindowByTitle");
			}
		}
		
	}

	@Override
	public boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("SwitchToNewWindow Succesfull");				
			} else {
				System.out.println("Element not found for SwitchToNewWindow");
			}
		}
		
	}

	@Override
	public boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {
			Set<String> set=driver.getWindowHandles();
			Object popup[]=set.toArray();
			driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("switchToOldWindow successfull");			
			} else {
				System.out.println("Element not found for switchToOldWindow");
			}
		}
	}

	@Override
	public int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int colCount = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
		}
		
		return colCount;
	}

	@Override
	public int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowCount = rows.size() - 1;
		return rowCount;
	}

	@Override
	public boolean Alert(WebDriver driver) {
		boolean flag = false;
		Alert alert = null;

		try {
			alert = driver.switchTo().alert();
			alert.accept();
			flag = true;
		} catch (NoAlertPresentException ex) {
			ex.printStackTrace();
		} finally {
			if (!flag) {
				System.out.println("Alert handled successfully");		
			} else{
				System.out.println("No alert to handle");
			}
		}

		return flag;
	}

	@Override
	public boolean launchUrl(WebDriver driver, String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched url: "+url);				
			} else {
				System.out.println("Failed to launch url: "+url);
			}
		}
		
	}

	@Override
	public boolean isAlertPresent(WebDriver driver) {
		try { 
			driver.switchTo().alert(); 
			return true; 
		} catch (NoAlertPresentException Ex) { 
			return false; 
		}   
		
	}

	@Override
	public String getCurrentURL(WebDriver driver) {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current url:"+text);
		}
		return text;
	}

	@Override
	public String getTitle(WebDriver driver) {
		boolean flag = false;
		String text = driver.getTitle();
		if (flag) {
			System.out.println("Page Title:"+text);
		}
		return text;
	}

	@Override
	public boolean verifyClick(WebElement locator, String locatorName) {
		boolean flag = false;
		try {
			locator.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Click Successful"+locatorName);
			} else {
				System.out.println("Click Failed"+locatorName);
			}
		}
	}

	@Override
	public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		 Wait<WebDriver> wait = null;
		    try {
		        wait = new FluentWait<WebDriver>((WebDriver) driver)
		        		.withTimeout(Duration.ofSeconds(20))
		        	    .pollingEvery(Duration.ofSeconds(2))
		        	    .ignoring(Exception.class);
		        wait.until(ExpectedConditions.visibilityOf(element));
		        element.click();
		    }catch(Exception e) {
		    	e.printStackTrace();
		    } 
	}

	@Override
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Override
	public void explicitWait(WebDriver driver, WebElement element, int timeInSec) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeInSec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@Override
	public void pageLoadTimeOut(WebDriver driver, int timeInSec) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeInSec));
		
	}

	@Override
	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// local path
		// jenkins path
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}

	@Override
	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	
	
}
