package Game.Options;

import Game.Config.GameSettings;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * Created by Tyler on 2/23/2015.
 */
public class Options extends BasicGameState {
    private int id;
    private int selectedMenuItem;

    public Options(int id){
        this.id = id;
    }
    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        selectedMenuItem = 0;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setColor(Color.white);
        graphics.drawString("~Options~", 280, 20);
        if (selectedMenuItem == 0) {
            graphics.drawString(String.format("Debug Mode:%7s", GameSettings.DEBUG_MODE), 50, 120);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if(gameContainer.getInput().isKeyPressed(Input.KEY_DOWN)){
            selectedMenuItem++;
            if(selectedMenuItem > 1){
                selectedMenuItem =0;
            }
        }
        if(gameContainer.getInput().isKeyPressed(Input.KEY_UP)){
            selectedMenuItem--;
            if(selectedMenuItem <0){
                selectedMenuItem = 0;
            }
        }
        if(gameContainer.getInput().isKeyPressed(Input.KEY_ENTER)){
            if(selectedMenuItem == 0){
                if(GameSettings.DEBUG_MODE){
                    GameSettings.DEBUG_MODE = false;
                }else if(!GameSettings.DEBUG_MODE){
                    GameSettings.DEBUG_MODE = true;
                }
            }
        }
        if(gameContainer.getInput().isKeyPressed(Input.KEY_ESCAPE)){
            stateBasedGame.enterState(1);
        }
    }
}
