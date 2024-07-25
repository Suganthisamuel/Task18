import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestjQueryui {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\joesa\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		
		try {
		
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		WebElement datePicker = driver.findElement(By.id("datepicker"));
		datePicker.click();
		
		WebElement nextButton = driver.findElement(By.className("ui-datepicker-next"));
		nextButton.click();
		
		WebElement dateToSelect = driver.findElement(By.xpath("//a[text()='22']"));
		dateToSelect.click();
		
		System.out.println("Select date: 22");
		
		Thread.sleep(3000);
		
	}   catch (Exception e) {
		e.printStackTrace();
		
	}   finally {
		driver.quit();
	}
	
	}
}
