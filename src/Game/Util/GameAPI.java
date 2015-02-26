package Game.Util;

import Game.Config.GameSettings;

/**
 * Created by Tyler on 2/23/2015.
 */
public class GameAPI {
    public static GameSettings gameSettings;

    public GameAPI() {

    }

    public static GameSettings getGameSettings() {
        if (gameSettings == null) {
            gameSettings = new GameSettings();
        }
        return gameSettings;
    }
}
