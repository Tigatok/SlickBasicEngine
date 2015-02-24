package Game.SplashScreen;

import com.oracle.jrockit.jfr.Transition;
import com.sun.media.jfxmedia.logging.Logger;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.Timer;

/**
 * Created by Tyler on 2/22/2015.
 */
public class SplashScreen extends BasicGameState {
    private Image splashScreenImage;
    private int id;
    private Timer splashScreenTimer;
    public static int seconds;
    private int miliseconds = 0;
    private int time;

    public SplashScreen(int id) throws SlickException {
        this.id = id;
        this.splashScreenImage = new Image("images/SplashScreen/KatoGames_SplashScreen_01.png");
        time = 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        time += i;
        if(time/1000 == 5 || gameContainer.getInput().isKeyPressed(Input.KEY_ENTER)){
            Logger.logMsg(0, "5 seconds has passed.");
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
    } //Updates runs every milisecond.

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        splashScreenImage.draw(0, 0);
        //@Todo add options for debug mode.
//        graphics.setColor(Color.red);
//        graphics.drawString("Time: "+time/1000, 20, 20);
    }

    @Override
    public int getID() {
        return this.id;
    }
}
