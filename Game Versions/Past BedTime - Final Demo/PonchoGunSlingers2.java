import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PonchoGunSlingers2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PonchoGunSlingers2 extends SimulationWorld
{
    private long lastFrameTimeMS;
    private double timeStepDuration;
    public static GreenfootSound gameMusic;
    private long startTime;
    /**
     * Constructor for objects of class PonchoGunSlingers2.
     * 
     */
    public PonchoGunSlingers2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
      super(2);
      prepare();
      //lastFrameTimeMS = System.currentTimeMillis();
      //timeStepDuration = 1.0 / 60;
      gameMusic = new GreenfootSound("lassolady(reversed).mp3");
      gameMusic.stop();
    }
    public void started()
    {
        super.started();
        lastFrameTimeMS = System.currentTimeMillis();
        gameMusic.playLoop();
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
        cowboy.setLocation(41,522);
        cowboy.setLocation(16,482);
        cowboy.setLocation(26,477);
        cowboy.setLocation(21,468);
        cowboy.setLocation(21,466);
        Platform platform = new Platform();
        addObject(platform,63,495);
        Platform platform2 = new Platform();
        addObject(platform2,319,337);
        Bandit bandit = new Bandit();
        addObject(bandit,348,286);
        Platform platform3 = new Platform();
        addObject(platform3,672,462);
        Bandit bandit2 = new Bandit();
        addObject(bandit2,700,411);
        Platform platform4 = new Platform();
        addObject(platform4,771,175);
        Platform platform5 = new Platform();
        addObject(platform5,821,328);
        Platform platform6 = new Platform();
        addObject(platform6,1033,221);
        Platform platform7 = new Platform();
        addObject(platform7,1081,448);
        Platform platform8 = new Platform();
        addObject(platform8,495,123);
        Bandit bandit3 = new Bandit();
        addObject(bandit3,518,73);
        Bandit bandit4 = new Bandit();
        addObject(bandit4,820,279);
        Bandit bandit5 = new Bandit();
        addObject(bandit5,775,124);
        Bandit bandit6 = new Bandit();
        addObject(bandit6,998,171);
        Bandit bandit7 = new Bandit();
        addObject(bandit7,1105,398);
        platform4.setLocation(570,286);
        platform4.setLocation(588,290);
        platform8.setLocation(499,453);
        bandit3.setLocation(462,402);
        bandit5.setLocation(555,243);
    }
}
