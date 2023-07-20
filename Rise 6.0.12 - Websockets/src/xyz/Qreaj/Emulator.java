package xyz.Qreaj;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class Emulator extends WebSocketServer {



    public static String killaura_nametags(String inputJson) {
        // Very shit check btw keep adding i am sure that i can crack any shit you add btw nice obfuscation
        // deobfuscated like in 20minutes *_* but why modify jarfile when i can create crack  for multiple versions
        Gson gson = new Gson();
        JsonObject inputObj = gson.fromJson(inputJson, JsonObject.class);
        JsonArray inputArray = inputObj.getAsJsonArray("a");
        JsonArray outputArray = new JsonArray();
        for (JsonElement element : inputArray) {
            JsonObject obj = element.getAsJsonObject();

            obj.remove("b");
            obj.remove("c");
            outputArray.add(obj);
        }
        JsonObject outputObj = new JsonObject();
        outputObj.addProperty("b",1);
        outputObj.addProperty("id",7);
        outputObj.add("a", outputArray);
        return gson.toJson(outputObj);
    }

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
            if (s.contains("\"id\":1")) {
                webSocket.send("{\"a\":true,\"b\":3.141592653589793,\"c\":69,\"id\":1}");
                System.out.println("Server join check sent!");
            } else if (s.contains("\"id\":3")) {
                System.out.println("Server join check sent!");
                webSocket.send(s);
        } else if (s.startsWith("{\"a\":[{\"a\":")) {
              webSocket.send(killaura_nametags(s));
              System.out.println("Killaura,Nametags check sent!");
            }

    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    @Override
    public void onStart() {

    }
}
