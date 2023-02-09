package TestNgConfigurations;

import Config.BaseTest;
import Config.USERAGENT;
import Config.UserAgentsCreation;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseProxyTestNG extends BaseTestTestNG {

    public static BrowserMobProxyServer serverBase;

    @BeforeClass
    public  void startProxy(){
        serverBase.newHar("youtube"); // create log file
        UserAgentsCreation.createUserAgent(USERAGENT.ANDROIDRU, serverBase);
    }


    @AfterClass
    public  void stopProxy(){
        Har har = serverBase.endHar();
        try {
            har.writeTo(new File("youtube.har"));
            serverBase.stop();

            for(HarEntry harEntry : har.getLog().getEntries()){
                harEntry.getRequest().getHeadersSize();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
