import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class PonchoGunSlingers1 extends SimulationWorld
{
    private long lastFrameTimeMS;
    private double timeStepDuration;
    //public static GreenfootSound gameMusic;
    private long startTime;
    /**
     * Constructor for objects of class PonchoGunSlingers1.
     */
    public PonchoGunSlingers1()
    {
        super(1);
        //gameMusic = new GreenfootSound("lassolady.mp3");
        prepare();
        //gameMusic.stop();
    }

    /*public boolean isInScene1() {
        return isInScene1;
    }

    public void goToScene2() {
        setBackground("Scene 2.png");
        isInScene1 = false;
    }*/
    public void started()
    {
        super.started();
        //gameMusic.playLoop();
    }
    
    public void stopped()
    {
        super.stopped();
        //gameMusic.stop();
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
        Cowboy cowboy =  new  Cowboy();
        addObject(cowboy, 128, 486);
        cowboy.setLocation(38,465);
        Platform platform = new Platform();
        addObject(platform,74,497);
        Platform platform2 = new Platform();
        addObject(platform2,425,345);
        Platform platform3 = new Platform();
        addObject(platform3,641,151);
        Platform platform4 = new Platform();
        addObject(platform4,676,449);
        Platform platform5 = new Platform();
        addObject(platform5,1018,451);
        platform3.setLocation(972,324);
    }
}
