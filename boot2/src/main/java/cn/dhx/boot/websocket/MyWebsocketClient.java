package cn.dhx.boot.websocket;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

@Slf4j
@Getter
@Setter
public class MyWebsocketClient extends WebSocketClient {

    private String websocketUri;


    public MyWebsocketClient(URI serverUri) {
        super(serverUri);
        this.websocketUri = serverUri.toString();
    }

    @Override
    public void onOpen(ServerHandshake handshakes) {
        log.info("websocket {} open", websocketUri);
    }

    @Override
    public void onMessage(String message) {
        log.info("websocket message {}", message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log.info("websocket {} close", websocketUri);
    }

    @Override
    public void onError(Exception ex) {
        log.error("websocket {} error", websocketUri);
    }
}
