package group7.entities;

import group7.Graphics.GraphicsGrid;
import group7.levels.LevelData;
import group7.utils.Direction;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;

public class Enemy extends Animate {
    int directionUpdateInterval = 200;

    int detectionWidth = 5;
    int detectionHeight = 5;

    

    public Enemy(double posX, double posY, LevelData levelData) {
        super(posX, posY, levelData);
    }

    public void setAnimation() {

    }

    public void update() {
        updateDirection();
        super.update();
    }

    public void updateDirection() {
        Direction playerDirection = levelData.findPlayer((int) getPosX(), (int) getPosY(), detectionWidth);
        if (!(playerDirection == Direction.NONE)) {
            // remove all directions
            removeDirection(Direction.UP);
            removeDirection(Direction.DOWN);
            removeDirection(Direction.LEFT);
            removeDirection(Direction.RIGHT);

            // move to towards the center of the tile to prevent getting stuck
            if (getPosX() % 1 > 0.5 && playerDirection != Direction.RIGHT) {
                setDirection(Direction.LEFT);
            } else if (getPosX() % 1 < 0.5 && playerDirection != Direction.LEFT) {
                setDirection(Direction.RIGHT);
            }
            if (getPosY() % 1 > 0.5 && playerDirection != Direction.DOWN) {
                setDirection(Direction.UP);
            } else if (getPosY() % 1 < 0.5 && playerDirection != Direction.UP) {
                setDirection(Direction.DOWN);
            } 
            System.out.println(playerDirection);

            setDirection(playerDirection);
            return;
        }

        // if the player is not in range, move randomly
        if (directionUpdateInterval > 0) {
            directionUpdateInterval--;
            return;
        }
        directionUpdateInterval = (int) (Math.random() * 100);
        switch ((int) (Math.random() * 5)) {
            case 0:
                toggleDirection(Direction.UP);
                break;
            case 1:
                toggleDirection(Direction.DOWN);
                break;
            case 2:
                toggleDirection(Direction.LEFT);
                break;
            case 3:
                toggleDirection(Direction.RIGHT);
                break;
            case 4: // stop moving
                removeDirection(Direction.UP);
                removeDirection(Direction.DOWN);
                removeDirection(Direction.LEFT);
                removeDirection(Direction.RIGHT);
                break;
        }
    }

    public void loadAnimations() {

    }

    public Rectangle2D getDetectionBounds() {
        return new Rectangle2D.Double(posX - detectionWidth / 2, posY - detectionHeight / 2, detectionWidth, detectionHeight);
    }

    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.YELLOW);

        // debugging the direction the enemy is moving in
        g.setColor(Color.ORANGE);
        if (movingDown) {
            GraphicsGrid.drawRect(g, getPosX(), getPosY() + 1, 0.1, 0.1);
        }
        if (movingLeft) {
            GraphicsGrid.drawRect(g, getPosX() - 1, getPosY(), 0.1, 0.1);
        }
        if (movingRight) {
            GraphicsGrid.drawRect(g, getPosX() + 1, getPosY(), 0.1, 0.1);
        }
        if (movingUp) {
            GraphicsGrid.drawRect(g, getPosX(), getPosY() - 1, 0.1, 0.1);
        }
    } 
}