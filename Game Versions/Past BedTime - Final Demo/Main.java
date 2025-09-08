import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main extends World
{
    private int startTick=0;
    
    Player hero = new Player();
    Door door0 = new Door(0);
    Entity entity = new Entity();
    /**
     * Constructor for objects of class Main.
     * 
     */
    public Main()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //prepare();
        
    }
    public void act() {
        if (startTick == 0) {
            Greenfoot.setWorld( new DarkBasement(hero, door0, entity));
        }
        startTick++;
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Player hero = new Player();
        //Door door0 = new Door(0);
        //Entity entity = new Entity();
        //Greenfoot.setWorld( new DarkBasement(hero, door0, entity));
    }
}
