package group7.entities.inanimate;

import group7.entities.animate.Player;

import java.awt.geom.Rectangle2D;
import java.awt.Graphics;

public abstract class Collectable extends Inanimate {
    protected int objectType;

    protected boolean visible = true; // If object hasn't been picked up TRUE, else FALSE 

    // TYPES OF COLLECTABLES
    public static final int ESCAPE_KEYCARD = 0;
    public static final int GREEN_HEALTH_POTION = 1;
	public static final int PURPLE_SPEED_POTION = 2;
    public static final int EGG_POINT_BONUS = 3;
    
    // Constructor
    public Collectable(int x, int y) {
        super(x, y);
    }

    protected void updateAnimation() {
        // implement if you animate the potion/keys/eggs
    }
    
    public int getObjectType() {
        return objectType;
    }

    public Rectangle2D getHitbox() {
        if (visible) {
            return super.getHitbox();
        } else {
            return new Rectangle2D.Double(0, 0, 0, 0);
        }
    }

    @Override
    public void onInteraction(Player player) {
        visible = false;
    }

    public void render(Graphics g) {
        if (visible) {
            super.render(g);
        }
    }
}