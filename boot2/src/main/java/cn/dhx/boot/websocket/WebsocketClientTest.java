package cn.dhx.boot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.WebSocket;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public class WebsocketClientTest {

    public static void main(String[] args) throws URISyntaxException {
        String path = "ws://127.0.0.1:8091/websocket";
        URI uri = new URI(path);

        new Thread(() -> {
            MyWebsocketClient myWebsocketClient = new MyWebsocketClient(uri);
            myWebsocketClient.connect();
            while (!myWebsocketClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
                log.info("还没有打开");
            }
            myWebsocketClient.send("aa");
        }).start();
        log.info("ok");
    }
}
