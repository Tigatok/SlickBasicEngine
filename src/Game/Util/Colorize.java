package Game.Util;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * Created by Tyler on 2/23/2
 */
public class Colorize {
    //&1 = white
    //&2 = black
    //&3 = red
    //&4 = green
    //&5 = blue
    //&6 = yellow
    //&7 = orange
    //&r = reset = white
    private static String coloredString;

    public static void Colorize(String stringToColorize, Graphics graphics, int x, int y) {
        //We have a string with a bunch of color codes.
        String[] sectionToBeColored = stringToColorize.split("&");//    &1test &2Hello &Hi        //Grab frm the '& to the next &'

        for (String sectionToColor : sectionToBeColored) {
            if (!sectionToColor.equals("")) {
                System.out.println("Color:" + sectionToColor);
                String colorCode = sectionToColor.substring(0, 1);
                System.out.println("Colorcode: " + colorCode);
                if (colorCode.equals("1")) {
                    coloredString += Color.white + sectionToColor;
                } else if (colorCode.equals("2")) {
                    coloredString += Color.black + sectionToColor;
                } else if (colorCode.equals("3")) {
                    coloredString += Color.red + sectionToColor;
                }
            }
        }

    }
}
