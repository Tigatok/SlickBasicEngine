package Game.Options;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Tyler on 2/24/2015.
 */
public class Option {
    public static Map<String, Option> stringOptionHashMap = new ConcurrentHashMap<String, Option>();
    private String optionName;
    private Object optionValue;

    public Option(String optionName, Object optionValue) {

        this.optionName = optionName;
        this.optionValue = optionValue;

        stringOptionHashMap.put(optionName, this);
        System.out.print("String Option Hashmap Size: "+ stringOptionHashMap.size());
        parseValue(this.optionValue);
    }

    public Object getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(Object optionValue) {
        this.optionValue = optionValue;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public void parseValue(Object optionValue) {
        System.out.println("Option Value: "+ optionValue);
        if (optionValue instanceof String) {
            if (((String) optionValue).equalsIgnoreCase("true")) {
                this.optionValue = true;
            } else if (((String) optionValue).equalsIgnoreCase("false")) {
                this.optionValue = false;
            }
        }
        if (optionValue instanceof Integer) {
            System.out.print("Option Value instance of Integer");
        }
    }

//    public static boolean isHighlighted(int intToCheck){
//        int optionCounter = 0;
//        int optionsMapSize = stringOptionHashMap.size();
//
//    }
}
