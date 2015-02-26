package Game.Config;

import Game.Options.Option;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Tyler on 2/23/2015.
 */
public class GameSettings {

    private static File file;
    //Load the default variables here
    private ArrayList<String> configurationLines;

    public GameSettings() {
        System.out.println("Starting GameSettings");
        configurationLines = new ArrayList<String>();
        file = new File("./settings.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
                loadDefaults(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            try {
//                BufferedReader reader = new BufferedReader(new FileReader(file));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    String lineSplit[] = line.split("=");
//                    configurationLines.add(lineSplit[1]);
//                    System.out.println(configurationLines.get(1));
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//            try {
//                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
//                bufferedWriter.write("" +
//                        "DEBUG_MODE: False\n" +
//                        "");
//                bufferedWriter.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        init();

    }

    public void loadDefaults(File fileToWriteTo) {
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileToWriteTo));
            bufferedWriter.write("#################");
            bufferedWriter.write("# Configuration #");
            bufferedWriter.write("##### File $#####");
            bufferedWriter.write("#################");
            bufferedWriter.write("# any line starting with a # is ignored.");
            bufferedWriter.write("# Variables can be created as such:");
            bufferedWriter.write("#    variablename=value");
            bufferedWriter.write("#    Possible value types: \"string\", 'char', 0 int, 0.0 double, ");
            bufferedWriter.write("#################");
            bufferedWriter.write("#################");
            bufferedWriter.write("DEBUG_MODE=false\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
//        BufferedReader bufferedReader = null;
//        try {
//            bufferedReader = new BufferedReader(new FileReader(file));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split(":");
                String key = lineSplit[0];
                String value = lineSplit[1];
                new Option(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//            configurationLines.add(bufferedReader.readLine());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String[] optionsValue;
//        for (int i = 0; i < configurationLines.size(); i++) { //@Todo add maximum amount of config lines so they cant add more.
//            switch(i){
//                case 0:
//                    optionsValue = configurationLines.get(0).split(":");
//                    optionsValue[1] = optionsValue[1].trim();
//                    DEBUG_MODE = Boolean.parseBoolean(optionsValue[1]);
//                    System.out.println("Debug Mode: "+ Boolean.parseBoolean(optionsValue[1]));
//                    break;
//            }
//        }
    }
}
