package tpo.lab4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractPageTest {
  private WebDriver driver;
  public static final String URL = "https://en.wikipedia.org";

  protected abstract WebDriver makeDriver();

  @BeforeEach
  public void setUp() {
    driver = makeDriver();
    driver.manage().window().maximize();
    driver.get(URL);
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void featuredArticle() {
    // A page should have a photo
    driver.findElement(By.xpath("//*[contains(text(), 'featured article')]/following::a[2]")).click();
    driver.findElement(By.xpath("//*[contains(@class, 'infobox')]//img[1]")).click();
    (new Actions(driver)).sendKeys(Keys.ESCAPE).perform();

    // A page should have references
    driver.findElement(By.xpath("//a[contains(@href, 'References')]"));
  }

  @Test
  public void search() throws InterruptedException {
    WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchInput']"));
    searchBox.sendKeys("итмо");
    searchBox.submit();

    WebElement firstResultLink = driver.findElement(By.xpath("//div[contains(@class, 'results')]//div[contains(@class, 'container')]//a[1]"));

    firstResultLink.click();
    assertTrue(driver.getCurrentUrl().contains("ITMO"));
  }

  @Test
  public void russianWikipediaStillThere() {
    WebElement russian = driver.findElement(By.xpath("//a/descendant-or-self::*[contains(text(), 'Русский')]"));
    russian.click();
    assertTrue(driver.getCurrentUrl().contains("ru.wikipedia"));
  }
}
