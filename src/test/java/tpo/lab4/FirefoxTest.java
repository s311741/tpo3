package tpo.lab4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest extends AbstractPageTest {
  @Override
  protected WebDriver makeDriver() {
    return new FirefoxDriver();
  }
}
