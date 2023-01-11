package Config;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseProxy extends BaseTest{

    public static BrowserMobProxyServer serverBase;

    @BeforeClass
    public static void startProxy(){
        serverBase.newHar("youtube");
        UserAgentsCreation.createUserAgent(USERAGENT.ANDROIDRU, serverBase);
    }


    @AfterClass
    public static void stopProxy(){
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
