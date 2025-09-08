import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CodePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CodePanel extends Room
{
    public Player tempPlayer;
    
    public boolean c6=false;
    public boolean c1=false;
    public boolean c8=false;
    public boolean c2=false;
    
    /**
     * Constructor for objects of class CodePanel.
     * 
     */
    public CodePanel(Player playerObj, Door door, Entity entity)
    {
        super(512, 512, 1,15, playerObj, door, entity);
        
        tempPlayer = playerObj;
        
        Panel panel = new Panel();
        addObject(panel, getWidth() / 2, getHeight() / 2);
        
        showText("press e to exit", getWidth() / 2 , 400 );
    }
    public void act() {
        super.act();
        
        
        if (Greenfoot.isKeyDown("e")) {
            Greenfoot.setWorld( new  Entrance(tempPlayer, new Door(2000), entity));
        }    
        
        String key = Greenfoot.getKey();
        if (key != null) {
            //System.out.println(key);
            boolean check = ( (key.equals("6")) ||
               (key.equals("1")) ||
               (key.equals("8")) ||
               (key.equals("2")) );
            //System.out.println(check);
            if (!check) {
                c6=false;
                c1=false;
                c8=false;
                c2=false;
                //System.out.println("reset: "+key);
            }
        }
        
        if (Greenfoot.isKeyDown("6")) {
            c6=true;
        }
        if (Greenfoot.isKeyDown("1") && (c6)) {
            c1=true;
        }
        if (Greenfoot.isKeyDown("8") && (c1)) {
            c8=true;
        }
        if (Greenfoot.isKeyDown("2") && (c8)) {
            c2=true;
            chaseTheme.stop();
            music.stop();
            Greenfoot.setWorld( new  EscapeEnding());
        }
        
    }
}
