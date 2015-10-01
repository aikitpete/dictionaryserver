import IO.ConnectionIO;

import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 2, 2011
 * Time: 10:55:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Session extends Thread {

    private ConnectionIO connection;
    private Session session;
    private Vocablist vocablist;

    public Session(Socket client) {

        session = this;
        connection = new ConnectionIO(client);
        session.start();

    }

    public void run() {

        String messageIn = null;

        messageIn = connection.receive();

        String[] messageInContents;

        if (messageIn != null) {
            messageInContents = messageIn.split(" ");
        } else {
            messageInContents = null;
        }


        while (true) {

            System.out.println("Received:" + messageIn);

            if (messageIn == null) {

                System.out.println("Client error, client disconnected");
                break;

            } else if (messageInContents[0].equals("login")) {

                System.out.println("MESSAGE TYPE:LOGIN");

                if (messageInContents.length >= 3) {

                    connection.send("login " + Tools.validate(messageInContents[1], messageInContents[2]));

                } else {

                    connection.send("login error");

                }

            } else if (messageInContents[0].equals("create")) {

                System.out.println("MESSAGE TYPE:CREATE");

                if (messageInContents.length >= 3) {

                    connection.send("create " + Tools.create(messageInContents[1], messageInContents[2]));

                } else {

                    connection.send("create error");

                }

            } else if (messageInContents[0].equals("start")) {

                System.out.println("MESSAGE TYPE:START");

                if (messageInContents.length >= 3) {

                    connection.send("start " + Tools.start(messageInContents[1], messageInContents[2], this));
                    connection.send("word " + Tools.word(null,null,null, this));

                } else {

                    connection.send("start error");

                }

            } else if (messageInContents[0].equals("word")) {

                System.out.println("MESSAGE TYPE:WORD");

                if (messageInContents.length >= 2) {
                    messageInContents = messageIn.split(":");
                    connection.send("word " + Tools.word(messageInContents[1], messageInContents[2],messageInContents[3],this));

                } else {

                    connection.send("word error");

                }

            } else if (messageInContents[0].equals("statistics")) {

                System.out.println("MESSAGE TYPE:STATISTICS");

                if (messageInContents.length == 1) {
                    messageInContents = messageIn.split(":");

                    connection.send("statistics " + Tools.statistics());

                } else {

                    connection.send("statistics error");

                }

            }

            messageIn = connection.receive();
            if (messageIn != null) {
            messageInContents = messageIn.split(" ");
        } else {
            messageInContents = null;
        }
        }

    }

    public void setVocabList(int difficulty, int direction) {
        this.vocablist = new Vocablist(difficulty, direction);
    }

    public Vocablist getVocabList() {
        return vocablist;
    }
}
