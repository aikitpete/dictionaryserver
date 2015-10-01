import IO.UserFileIO;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 3, 2011
 * Time: 1:46:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class Userlist {

    private static ArrayList<String[]> users;
    private static int currentUser;

    public static int validate(String username, String password) {
        if (users == null) {
            load();
        }
        for (String[] i : users) {
            if (i[0].equals(username)) {
                if (i[1].equals(password)) {
                    currentUser = users.indexOf(i);
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        return 0;
    }

    public static int add(String username, String password) {
        if (users == null) {
            load();
        }
        if (validate(username, password) == 0) {
            users.add(new String[]{username, password, "0", "0"});
            System.out.println("User " + username + " created");
            save();
            return 1;
        } else {
            System.out.println("Error adding user " + username + "");
            return -1;
        }

    }

    public static void save() {
        new UserFileIO().save(users);
        System.out.println("Userlist saved");
    }

    public static void addSuccess() {
        users.get(currentUser)[2]=String.valueOf(Integer.valueOf(users.get(currentUser)[2])+1);
        users.get(currentUser)[3]=String.valueOf(Integer.valueOf(users.get(currentUser)[3])+1);
        save();
    }

    public static void addLoss() {
        users.get(currentUser)[3]=String.valueOf(Integer.valueOf(users.get(currentUser)[3])+1);
        save();
    }

    public static ArrayList<String> getUserData() {
        ArrayList<String> ret = new ArrayList<String>();
        ret.add((users.get(currentUser)[0]));
        ret.add((users.get(currentUser)[2]));
        ret.add((users.get(currentUser)[3]));
        return ret;
    }

    public static void load() {
        users = new UserFileIO().load();
        System.out.println("Userlist loeaded");
    }
}
