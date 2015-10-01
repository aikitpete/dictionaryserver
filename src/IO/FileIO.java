package IO;

import javax.swing.*;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 3, 2011
 * Time: 3:54:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileIO {

    private BufferedReader input;
    private BufferedWriter output;
    private String file;

    public void setFile(String file) {
        this.file = file;
    }

    public void initInput() {


        InputStream in;
        in = null;
        if (file != null) try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        // Use default encoding if no encoding is specified.
        String from = null;
        System.setProperty("file.encoding", "UTF-8");
        if (from == null) from = System.getProperty("file.encoding");

        

        try {
            input = new BufferedReader(new InputStreamReader(in, from));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

    public void initOutput() {
        try {
            output = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public String read() {
        try {
            //System.out.println(input.readLine());
            String ret = input.readLine();
            
            return ret;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    public void closeInput() {
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void write(String message) {
        try {
            output.write(message);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void closeOutput() {
        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
