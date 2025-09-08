import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameKitchen extends World
{
    private int startTick=0;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public GameKitchen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(618, 800, 1); 
    }
    public void act() {
        if (startTick == 100) {
            Greenfoot.setWorld( new StartScreen());
        }
        startTick++;
    }
}
