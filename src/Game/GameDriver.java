package Game;

import Game.Config.GameSettings;
import Game.Game.Game;
import Game.MainMenu.MainMenu;
import Game.Options.Options;
import Game.SplashScreen.SplashScreen;
import Game.Util.GameAPI;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Tyler on 2/22/2015
 */
public class GameDriver extends StateBasedGame {
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int FPS = 60;
    public static final double VERSION = 1.0;
    public static int SPLASHSCREEN = 0;
    public static int MAINMENU = 1;
    public static int GAME = 2;
    public static int OPTIONS = 3;
    private static GameSettings gameSettings;

    public GameDriver(String gameName) {
        super(gameName);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appGameContainer = new AppGameContainer(new GameDriver("My GameDriver v" + VERSION));
            appGameContainer.setDisplayMode(WIDTH, HEIGHT, false);
            appGameContainer.setTargetFrameRate(FPS);
            appGameContainer.setShowFPS(true);
            gameSettings = GameAPI.getGameSettings();
            appGameContainer.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new SplashScreen(SPLASHSCREEN));
        this.addState(new MainMenu(MAINMENU));
        this.addState(new Game(GAME));
        this.addState(new Options(OPTIONS));
    }
}
