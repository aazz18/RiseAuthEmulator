package xyz.Qreaj;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class Emulator extends WebSocketServer {

    public static void main(String args[]) {
        WebSocketServer webSocketServer = new Emulator(new InetSocketAddress("127.0.0.1", 3009));
        webSocketServer.start();
    }

    public Emulator(InetSocketAddress address) {
        super(address);

    }
    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {

    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {

    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
             webSocket.send("{\"a\":true,\"b\":3.141592653589793,\"c\":69,\"id\":1}");
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    @Override
    public void onStart() {

    }
}
