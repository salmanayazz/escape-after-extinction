package group7.gameStates;

import group7.Game;
import group7.Graphics.GraphicsButtons;
import group7.Graphics.GraphicsGrid;
import group7.Graphics.GraphicsPanel;
import group7.utils.AssetLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

import static group7.Graphics.GraphicsPanel.panelHeight;
import static group7.Graphics.GraphicsPanel.panelWidth;

public class creditState extends MainMenuState{
    private BufferedImage creditText;
    public creditState(Game game) {
        super(game);
        mainMenuButtons = new GraphicsButtons[1];
        creditText = AssetLoader.getSpriteAtlas(AssetLoader.CreditMenu);
        mainMenuButtons[0] = new GraphicsButtons(game,panelWidth / 2 + 4*GraphicsGrid.getScaleX(), (int)(0.7*panelHeight), 9, gameStates.IN_MENU);
    }
    @Override
    public void render(Graphics g){
        mainPageParallelBG.renderParallelBackground(g);
        g.drawImage(creditText, (int)(0.5*(panelWidth-creditText.getWidth())),100,creditText.getWidth(),creditText.getHeight(),null);
        for (GraphicsButtons buttons : mainMenuButtons) {
            buttons.render(g);
        }
    }
}