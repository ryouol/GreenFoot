import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1); 
        addObject(new Sheep(), 100,100);
        addObject(new Sheep(), 100,200);
        addObject(new Sheep(), 200,100);
        addObject(new Sheep(), 200,200);
        addObject(new Sheep(), 300,300);
        addObject(new Sheep(), 200,300);
        addObject(new Bear(), 500,500);
        addObject(new Bear(), 700,500);
        addObject(new Bear(), 600,600);
        addObject(new Grass(),(int)(Math.random()*750)+200,(int)(Math.random()*750)+200);
        addObject(new Grass(),(int)(Math.random()*750)+200,(int)(Math.random()*750)+200);
        addObject(new Grass(),(int)(Math.random()*750)+200,(int)(Math.random()*750)+200);
    }
}
