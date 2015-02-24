package Game.MainMenu;

import Game.Config.GameSettings;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.Map;

/**
 * Created by Tyler on 2/22/2015.
 */
public class MainMenu extends BasicGameState{
private int id;
    private StateBasedGame game;
    private int selectedMenuItem;
    private Map<Integer, Boolean> menuItemMap;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MainMenu(int id){
    this.id = id;

    }
    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.game = stateBasedGame;
        selectedMenuItem = 0;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setColor(Color.white);
        graphics.drawString("Slick Engine 1.0", 300, 100);
        if(selectedMenuItem == 0){
            graphics.setColor(Color.yellow);
            graphics.drawString("Play Game", 300, 150);
            graphics.setColor(Color.white);
            graphics.drawString("Options", 300, 170);
            graphics.drawString("Quit", 300, 190);
        }
        else if(selectedMenuItem == 1){
            graphics.setColor(Color.white);
            graphics.drawString("Play Game", 300, 150);
            graphics.setColor(Color.yellow);
            graphics.drawString("Options", 300, 170);
            graphics.setColor(Color.white);
            graphics.drawString("Quit", 300, 190);
        }
        else if(selectedMenuItem == 2){
            graphics.setColor(Color.white);
            graphics.drawString("Play Game", 300, 150);
            graphics.drawString("Options", 300, 170);
            graphics.setColor(Color.yellow);
            graphics.drawString("Quit", 300, 190);
            graphics.setColor(Color.white);
        }


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if(gameContainer.getInput().isKeyPressed(Input.KEY_DOWN)){
            selectedMenuItem++;
            if(selectedMenuItem >2){
                selectedMenuItem = 0;
            }
        }
        else if (gameContainer.getInput().isKeyPressed(Input.KEY_UP)){
            selectedMenuItem--;
            if(selectedMenuItem <0){
                selectedMenuItem = 2;
            }
        }
        else if( gameContainer.getInput().isKeyPressed(Input.KEY_ENTER)){
            switch(selectedMenuItem){
                case 0: //Play Game
                    if(GameSettings.DEBUG_MODE) {
                        System.out.println("Play Game Selected!");
                    }
                    stateBasedGame.enterState(2, new FadeOutTransition(), new FadeInTransition());
                    break;
                case 1: //Options
                    if(GameSettings.DEBUG_MODE){
                        System.out.println("Options Selected!");
                    }
                    stateBasedGame.enterState(3);
                    break;
                //Possibly add load?
                case 2: //Quit
                    if(GameSettings.DEBUG_MODE){
                        System.out.println("Quitting Game");
                    }
                    gameContainer.exit();
                    break;
            }
        }
    }

}
