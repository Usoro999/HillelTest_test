package Config;

import net.lightbody.bmp.BrowserMobProxyServer;

    public class UserAgentsCreation {
        public static void createUserAgent(USERAGENT useragent, BrowserMobProxyServer server){
            switch(useragent){
                case ANDROIDRU -> createAndroidAgentRU(server);
                case ANDROIDEN -> createAndroidEN(server);
            }

        }

    private static void createAndroidAgentRU(BrowserMobProxyServer server) {
        server.addRequestFilter((httpRequest, httpMessageContents, httpMessageInfo) -> {
            httpRequest.headers().remove("user-agent");
            httpRequest.headers().remove("Accept-Language");
            httpRequest.headers().remove("Content-Language");

            httpRequest.headers().add("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");
            httpRequest.headers().add("Accept-Language", "ru");
            httpRequest.headers().add("Content-Language","ru_RU");
            httpRequest.headers().remove("Referer");

            return null;
        });

    }
    private static void createAndroidEN(BrowserMobProxyServer server) {
            server.addRequestFilter((request, contents, messageInfo) -> {
                request.headers().remove("user-agent");
                request.headers().remove("Accept-Language");
                request.headers().remove("Content-Language");

                request.headers().add("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");
                request.headers().add("Accept-Language", "en");
                request.headers().add("Content-Language", "en_EN");

                request.headers().remove("Referer");

                return null;
            });
        }
}
