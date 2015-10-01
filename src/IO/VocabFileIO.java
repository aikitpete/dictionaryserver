package IO;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 3, 2011
 * Time: 3:53:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class VocabFileIO extends FileIO {
    public ArrayList<String[]> load(int difficulty) {
        ArrayList<String[]> list = new ArrayList<String[]>();

        setFile("vocab.txt");

        initInput();


        String line = read();

        while (line != null) {

            line = line.substring(1,line.length()-1);
            String[] lineData = line.split("' '");

            /**
            for(int i=0;i<lineData.length;i++){
                System.out.print(lineData[i]+";");
            }
            System.out.println();
            **/

            if (Integer.valueOf(lineData[3]) <= difficulty) {

                if (lineData.length == 4) {
                    list.add(new String[]{lineData[0], lineData[1], lineData[2], lineData[3]});
                }
            }
            line = read();
        }

        closeInput();

        return list;  //To change body of created methods use File | Settings | File Templates.
    }
}
