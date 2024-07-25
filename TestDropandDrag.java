import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TestDropandDrag {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\joesa\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		
		try {
			
			driver.get("https://jqueryui.com/droppable/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement iframe = driver.findElement(By.className("demo-frame"));
			driver.switchTo().frame(iframe);
			
			WebElement sourceElement = driver.findElement(By.id("draggable"));
			WebElement targetElement = driver.findElement(By.id("droppable"));
			
			Actions actions = new Actions(driver);
			actions.dragAndDrop(sourceElement, targetElement).perform();
			
			TimeUnit.SECONDS.sleep(20);
			
			String targetColor = targetElement.getCssValue("background-color");
			String targetText = targetElement.getText();
			
			if (targetColor.equals("rgba(0, 128, 0, 1)") && targetText.equals("Dropped!")) {
				System.out.println("Drag and Drop Successful. Verfication message:Drop operation completed successfully");
			} else {
				System.out.println("Drag and Drop failed. verfication message: Drag and Drop did not completed");
			}
		}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				driver.quit();
			}
	}

	
    
}
