import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SimulationWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimulationWorld extends World
{
    private long lastFrameTimeMS;
    private double timeStepDuration;
    private long startTime;
    public static GreenfootSound level1Music = new GreenfootSound("lassolady.mp3");
    public static GreenfootSound level2Music = new GreenfootSound("lassolady(reversed).mp3");
    public static GreenfootSound jumpScare = new GreenfootSound("Entity Sounds.mp3");
    
    public int soundTick=0;
    
    public static int simID;
    /**
     * Constructor for objects of class StationRepository.
     * 
     */
    public SimulationWorld(int simIDp)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(1200, 600, 1);
        //prepare();
        lastFrameTimeMS = System.currentTimeMillis();
        timeStepDuration = 1.0 / 60;
        
        //System.out.println(simIDp);
        simID = simIDp;
        //System.out.println(simID);
    }
    public void act()
    {
        super.act();
        timeStepDuration = (System.currentTimeMillis() - lastFrameTimeMS) / 200.0;
        lastFrameTimeMS = System.currentTimeMillis();
        
        gameMusic();
    
    }
    
    public void gameMusic() {
        //System.out.println("switch" + simID);
        switch (simID) {
            case 1:
                level1Music.setVolume(80);
                level1Music.playLoop();
                break;
            case 2:
                level2Music.setVolume(80);
                level2Music.playLoop();
                level1Music.stop();
                break;
            case 3:
                level2Music.stop();
                break;
            case 4:
                jumpScare.setVolume(100);
                jumpScare.play();
                if (soundTick == 100) {
                    jumpScare.stop();
                }
                soundTick++;
        }
    }
    
    public void started()
    {
        super.started();
        lastFrameTimeMS = System.currentTimeMillis();
    }
    public double getTimeStepDuration()
    {
        return timeStepDuration;
    }
}