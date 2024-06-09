package tpo.lab4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeTest extends AbstractPageTest {
  @Override
  protected WebDriver makeDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    return new ChromeDriver(options);
  }
}
