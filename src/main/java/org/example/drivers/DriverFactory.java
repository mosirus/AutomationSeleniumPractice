package org.example.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    // Menggunakan ThreadLocal untuk memastikan WebDriver unik untuk setiap thread jika parallel execution
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        if (driver.get() == null) {
            String browser = "chrome";

            switch (browser.toLowerCase()) {
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
            }

            driver.get().manage().window().maximize();
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("Driver is not initialized. Please call initDriver() first.");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Hapus driver dari ThreadLocal
        }
    }
}
