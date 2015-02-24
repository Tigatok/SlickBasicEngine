package Game.Config;

import com.sun.media.jfxmedia.logging.Logger;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Tyler on 2/23/2015.
 */
public class GameSettings {

    //Load the default variables here
    public static boolean DEBUG_MODE;
    private ArrayList<String> configurationLines;
    private static File file;

    public GameSettings() {
        System.out.println("Starting GameSettings");
        configurationLines = new ArrayList<String>();
        file = new File("./settings.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("" +
                        "DEBUG_MODE: False\n" +
                        "");
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    init();

    }

    public void init() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            configurationLines.add(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] optionsValue;
        for (int i = 0; i < configurationLines.size(); i++) { //@Todo add maximum amount of config lines so they cant add more.
            switch(i){
                case 0:
                    optionsValue = configurationLines.get(0).split(":");
                    optionsValue[1] = optionsValue[1].trim();
                    DEBUG_MODE = Boolean.parseBoolean(optionsValue[1]);
                    System.out.println("Debug Mode: "+ Boolean.parseBoolean(optionsValue[1]));
                    break;
            }
        }
    }
}
