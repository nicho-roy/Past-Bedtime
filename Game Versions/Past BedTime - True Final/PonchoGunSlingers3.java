import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.*;
/**
 * Write a description of class PonchoGunSlingers3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PonchoGunSlingers3 extends SimulationWorld
{
    private long lastFrameTimeMS;
    private double timeStepDuration;
    public static GreenfootSound gameMusic;
    private long startTime;
    /**
     * Constructor for objects of class PonchoGunSlingers3.
     * 
     */
    public PonchoGunSlingers3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(3); 
        //lastFrameTimeMS = System.currentTimeMillis();
        // = 1.0 / 60;
        prepare();
    }
    
    public void started()
    {
        super.started();
        lastFrameTimeMS = System.currentTimeMillis();
    }
    
    public void act()
    {
        super.act();
        timeStepDuration = (System.currentTimeMillis() - lastFrameTimeMS) / 200.0;
        lastFrameTimeMS = System.currentTimeMillis();

    }
  
    public double getTimeStepDuration()
     {
        return timeStepDuration;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Cowboy cowboy = new Cowboy();
        addObject(cowboy,128,486);
        cowboy.setLocation(76,491);
        cowboy.setLocation(60,488);
        cowboy.setLocation(52,485);
        cowboy.setLocation(44,477);
        cowboy.setLocation(56,477);
        cowboy.setLocation(64,506);
        Platform platform = new Platform();
        addObject(platform,64,506);
        Platform platform2 = new Platform();
        addObject(platform2,468,340);
        Platform platform3 = new Platform();
        addObject(platform3,818,265);
        Platform platform4 = new Platform();
        addObject(platform4,1067,420);
        platform2.setLocation(516,338);
        platform2.setLocation(426,352);
        platform2.setLocation(424,352);
        platform2.setLocation(414,348);
        platform2.setLocation(414,348);
        platform4.setLocation(1036,420);
        removeObject(platform4);
        platform3.setLocation(833,284);
    }
}