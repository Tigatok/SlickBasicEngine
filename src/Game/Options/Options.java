package Game.Options;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Tyler on 2/23/2015.
 */
public class Options extends BasicGameState {
    private int id;
    private int selectedMenuItem;

    public Options(int id) {
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
        int spacery = 40;
        for (Option option : Option.stringOptionHashMap.values()) {
//            if (Option.isHighLighted(selectedMenuItem)) {
//                graphics.setColor(Color.yellow);
//            } else {
//                graphics.setColor(Color.white);
//            }
            graphics.drawString(String.format(option.getOptionName() + ":%7s", Option.stringOptionHashMap.get(option.getOptionName()).getOptionValue()), 50, spacery += 50);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_DOWN)) {
            selectedMenuItem++;
            if (selectedMenuItem > 1) {
                selectedMenuItem = 0;
            }
        }
        if (gameContainer.getInput().isKeyPressed(Input.KEY_UP)) {
            selectedMenuItem--;
            if (selectedMenuItem < 0) {
                selectedMenuItem = 0;
            }
        }
        if (gameContainer.getInput().isKeyPressed(Input.KEY_ENTER)) {
            if (selectedMenuItem == 0) {
                if ((Boolean) Option.stringOptionHashMap.get("DEBUG_MODE").getOptionValue()) {
                    Option.stringOptionHashMap.get("DEBUG_MODE").setOptionValue(false);
                } else {
                    Option.stringOptionHashMap.get("DEBUG_MODE").setOptionValue(true);
                }
            }
        }
        if (gameContainer.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            stateBasedGame.enterState(1);
        }
    }
}
