import IO.UserFileIO;
import IO.VocabFileIO;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 3, 2011
 * Time: 3:52:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Vocablist {

    private static ArrayList<String[]> words;
    private static int direction;

    public Vocablist(int difficulty, int direction) {
        load(difficulty);
        this.direction = direction;
    }

    public String validate(String answer1,String answer2,String answer3) {

        System.out.println("Q:"+answer1+" "+answer2+" "+answer3);
        for(String[] i : words) {
            System.out.println("S:"+i[0]+" "+i[1]+" "+i[2]);
            if (i[0].equals(answer1) && i[1].equals(answer2) && i[2].equals(answer3)) {
                Userlist.addSuccess();
                return "correct";
            }
            /**
            if (direction == 1) {
                if (i[0].equals(answer)) {
                    return "correct";
                }
            } else {
                if (i[2].equals(answer)) {
                    return "correct";
                }
            }
             **/
        }
        Userlist.addLoss();
        return "wrong";
    }

    public void load(int difficulty) {
        words = new VocabFileIO().load(difficulty);
        System.out.println("Vocablist loaded");
    }

    public String getWords() {
        String ret = "";
        String[] select;
        Random seed = new Random();

        for (int i=0; i<3; i++){
            select = words.get(seed.nextInt(words.size()));

            ret = ret+":"+select[0]+":"+select[1]+":"+select[2];

        }

        System.out.println("RET"+ret);
        
        return ret;  //To change body of created methods use File | Settings | File Templates.
    }
}
