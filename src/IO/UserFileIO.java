package IO;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 3, 2011
 * Time: 1:58:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserFileIO extends FileIO {

    public void save(ArrayList<String[]> users) {

        setFile("users.dat");
        
        initOutput();

        for (String[] i : users) {

            write(i[0] + " " + i[1] + " " + i[2] + " " + i[3]);

        }

        closeOutput();

    }

    public ArrayList<String[]> load() {
        ArrayList<String[]> users = new ArrayList<String[]>();

        setFile("users.dat");

        initInput();


        String line = read();

        while (line != null) {

            String[] lineData = line.split(" ");

            if (lineData.length == 4) {
                users.add(new String[]{lineData[0], lineData[1], lineData[2], lineData[3]});
            }

            line = read();
        }

        closeInput();


        return users;  //To change body of created methods use File | Settings | File Templates.
    }
}
