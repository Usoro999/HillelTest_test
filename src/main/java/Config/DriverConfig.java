package Config;

import Config.BROWSERS;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.Inet4Address;
import java.net.UnknownHostException;


public class DriverConfig {
    static WebDriver driver;


    public static WebDriver createDriver(BROWSERS browsers) {
        switch (browsers){
            case CHROMEINCOGNITO : createChrome();
            case FIREFOX : createFirefox();
            case CHROMEPROXY : createChromeProxy();
        }
        return driver;
    }

    private static void createChromeProxy() {

        if(driver==null) {
            BrowserMobProxyServer server = new BrowserMobProxyServer();
            server.setTrustAllServers(true);
            server.start();

            BaseProxy.serverBase = server;

            Proxy seleniumProxy = ClientUtil.createSeleniumProxy(server);
            String hostIp = null;
            try {
                hostIp = Inet4Address.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            seleniumProxy.setHttpProxy(hostIp + ":" + server.getPort());
            seleniumProxy.setSslProxy(hostIp + ":" + server.getPort());

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
            capabilities.setAcceptInsecureCerts(true);

            ChromeOptions options = new ChromeOptions();
            options.merge(capabilities);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();

    }


    public static void createChrome() {
       //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");

        if (driver == null) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
    }
    public static void createFirefox(){

    }
}