import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class BreakerDark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Breaker extends Actor
{
    /**
     * Act - do whatever the BreakerDark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //turnOnLights();
    }
    /*
    public void turnOnLights() {
        World world = getWorld();
        List<Player> players = world.getObjects(Player.class);
        if (players.size() != 0) {
            Player player = players.get(0);
            
            if (player.wrench==true) {
                List<Player> playerlist = getObjectsInRange(110, Player.class);
                if (playerlist.size() == 0) return;
                Player playercheck = playerlist.get(0);
                
                //Actor player = getOneIntersectingObject(Player.class);
                if (player != null) { 
                    Greenfoot.setWorld( new  DarkGarage(playerObj, door, entity));
                }
            }
        }
    }
    */
}
