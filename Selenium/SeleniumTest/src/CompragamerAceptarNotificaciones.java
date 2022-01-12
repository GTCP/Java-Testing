import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CompragamerAceptarNotificaciones{
	WebDriver driver;

public CompragamerAceptarNotificaciones(WebDriver driver) {
	this.driver = driver;
}
	public void AceptarNotificaciones() {
		WebDriverWait wait = new WebDriverWait(driver, 8000);
		WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"aceptarNotificacion\"]")));
		element.click();
	}
}