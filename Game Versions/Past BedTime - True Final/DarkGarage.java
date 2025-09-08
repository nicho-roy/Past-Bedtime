import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DarkGarage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DarkGarage extends Room
{

    /**
     * Constructor for objects of class DarkGarage.
     * 
     */
    public DarkGarage(Player playerObj, Door door, Entity entity)
    {
        super(800, 600, 1, 4, playerObj, door, entity); 
        
        prepare();
        
        if (door.id == -5) {
            addObject(playerObj,100,100);
        }
    }
    private void prepare() {
        Door breakerTransition = new Door(100);
        breakerTransition.setImage("BreakerDark.png");
        breakerTransition.getImage().scale(48,48);
        addObject(breakerTransition, 600,22);
        
        showText("I could fix this with the wrench...", 600, 50);
        
        Door door6d = new Door(-6);
        door6d.setRotation(270);
        addObject(door6d, 4,100);
    }
}
