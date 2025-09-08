import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Room extends World
{
    public static Entity entity;
    //TEST CODE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
    public static Player playerObj2;
    
    public int roomID = 0;
    public int chaseTick=0;
    
    //music code
    public static GreenfootSound music = new GreenfootSound("Game ambience.wav");
    public static GreenfootSound chaseTheme = new GreenfootSound("Entity Sounds.mp3");
    //GreenfootSound chaseTheme = new GreenfootSound("AudioMessage.wav");
    
    /**
     * Constructor for objects of class Room.
     */
    public Room(int width, int height, int cells, int roomID, Player playerObj, Door door, Entity entityObj)
    {
        super(width, height, cells);
        this.roomID = roomID;
        entity = entityObj;
        //TEST CODE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
        //Player hero = playerObj;
        
        //experimental!!!!!!!!!!
        playerObj2 = playerObj;
        //door = door;
        
    }
    public void act() {
        if (playerObj2.gameOver==false) {
            bgMusic();
            chaseMusic();
        }
        if (playerObj2.gameOver) {
            chaseTheme.stop();
            music.stop();
        }
    }
    
    public void bgMusic() {
        /*
        if(!music.isPlaying())
        {
            music.setVolume ( 10 );
            music.play();
        }
        */
        music.setVolume (20);
        music.playLoop();
        if (entity.dead) {
            music.stop();
        }
        
        /*if ( ! musicStarted) {
            music.playLoop();
            music.setVolume ( 10 );
            musicStarted = true;
        }
        */
    }
    
    
    public void chaseMusic() {
        //System.out.println("entity.chase;" + entity.chase);
        /*
        if (roomID==8) {
            System.out.println("entity.chase;" + entity.chase);
        }
        */
       
        if (entity.chase) {
            chaseTheme.setVolume(40);
            chaseTheme.playLoop();
            
        }
        else {
            chaseTheme.stop();
        }
    }
}
