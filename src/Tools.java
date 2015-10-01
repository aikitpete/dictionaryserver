import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 3, 2011
 * Time: 12:24:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class Tools {
    public static String validate(String username, String password) {
        int code = Userlist.validate(username, password);

        String ret;

        switch (code) {
            case 1:
                ret = "success " + username;
                break;
            case 0:
                ret = "error notfound " + username;
                break;
            case -1:
                ret = "error wrong " + username;
                break;
            default:
                ret = "error";
        }

        return ret;
    }

    public static String create(String username, String password) {
        int code = Userlist.add(username, password);

        String ret;

        switch (code) {
            case 1:
                ret = "success " + username;
                break;
            case -1:
                ret = "error " + username;
                break;
            default:
                ret = "error " + username;
        }

        return ret;
    }

    public static String start(String difficulty, String direction, Session session) {
        session.setVocabList(Integer.valueOf(difficulty), Integer.valueOf(direction));

        return "success";
    }

    public static String word(String answer1,String answer2,String answer3, Session session){
        String ret = "";
        if (answer1==null) {
            ret = ret+"null";
        } else {
            ret = ret+session.getVocabList().validate(answer1,answer2,answer3);

        }
        ret = ret+session.getVocabList().getWords();
        return ret;

    }

    public static String statistics() {
        ArrayList<String> data = Userlist.getUserData();
        return (data.get(0)+" "+data.get(1)+" "+data.get(2));
    }
}
