package IO;

import java.io.*;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 3, 2011
 * Time: 2:38:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionIO {
    private PrintWriter output;
    private BufferedReader input;

    public ConnectionIO(Socket client) {
        try {
            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), "UTF-8"));


            input = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void send(String message) {
        System.out.println("Sending message: " + message);
        output.println(message);
        output.flush();
    }

    public String receive() {
        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
