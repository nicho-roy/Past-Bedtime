 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JumpScare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JumpScare extends SimulationWorld
{
    private int startTick=0;
    /**
     * Constructor for objects of class JumpScare.
     * 
     */
    public JumpScare()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(4); 
    }
    public void act() {
        super.act();
        if (startTick == 100) {
            Greenfoot.setWorld( new Main());
        }
        startTick++;
    }
}
