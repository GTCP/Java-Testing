import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Compragamer {
	static WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver();
	}
	@Test (priority=1)
	//@Test
	public void loadPage() {
		driver.navigate().to("https://compragamer.com/");
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "COMPRA GAMER | Compra Gamer");
	}
	@Test (priority=2)
	public void searchProduct() {		
		CompragamerAceptarNotificaciones Notificaciones= new CompragamerAceptarNotificaciones(driver);
		Notificaciones.AceptarNotificaciones();
		CompragamerBuscarProducto BuscarProducto = PageFactory.initElements(driver, CompragamerBuscarProducto.class);
		BuscarProducto.search("6600 xt");
		BuscarProducto.scrollear();
	}
	@Test (priority=3)
	public void finishTest() {
		if(driver!=null) {
			driver.close();
			driver = null;
		}
		System.out.println("Termino satisfactoriamente");
		Assert.assertNull(driver);
	}
}