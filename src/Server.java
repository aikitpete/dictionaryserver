import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public ServerSocket server;
    public int port = 18560;

    public Server() {

        try {

            while (true) {
                server = new ServerSocket(port);
                System.out.println("Server address: " + server.getInetAddress() + "   PORT:" + server.getLocalPort());

                Socket client = server.accept();
                new Session(client);
                System.out.println("Client address: " + client.getInetAddress() + "   PORT:" + client.getLocalPort());
                //port++;
            }
        } catch (Exception e) {
        }
    }

}