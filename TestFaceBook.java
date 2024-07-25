
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestFaceBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver" , "C:\\Users\\joesa\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		
		try {
			driver.get("https://www.facebook.com/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			if (driver.getTitle().contains("facebook")) {
				System.out.println("Not on the facebook homepage");
				return;
			}
			
			WebElement createAccountButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
			createAccountButton.click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
			WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
			firstNameField.sendKeys("Suganthi");
			
			WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
			lastNameField.sendKeys("Sanju");
			
			WebElement emailField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
			emailField.sendKeys("sanjusuganthi0425@gmail.com");
			
			WebElement emailConfirmationField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
			emailConfirmationField.sendKeys("sanjusuganthi0425@gmail.com");
			
			WebElement passwordField = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
			passwordField.sendKeys("Susan@0425");
			
			WebElement dayField = driver.findElement(By.xpath("//select[@name='birthday_day']"));
			dayField.sendKeys("11");
			
			WebElement monthField = driver.findElement(By.xpath("//select[@name='birthday_month']"));
			monthField.sendKeys("may");
			
			WebElement yearField = driver.findElement(By.xpath("//select[@name='birthday_year']"));
			yearField.sendKeys("1985");
			
			WebElement genderRadio = driver.findElement(By.xpath("//input[@value='2']"));
			genderRadio.click();
			
			WebElement signUpButton = driver.findElement(By.xpath("//button[@name='websubmit']"));
			signUpButton.click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getTitle().contains("Facebook")) {
				System.out.println("Registration successful.Verfication message:user registration successfully and redirected to the facebook homepage");
				
			} else {
                System.out.println("Registration failed.Verification message :user registration failed");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}				
					
		finally {
			driver.quit();
		}	

	}

}
