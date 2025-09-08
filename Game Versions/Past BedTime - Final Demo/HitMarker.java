import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitMarker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitMarker extends Actor
{
    public int removeTick=0;
    /**
     * Act - do whatever the HitMarker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (removeTick==10) {
            World world = getWorld();
            world.removeObject(this);
        }
        removeTick++;
    }
}
