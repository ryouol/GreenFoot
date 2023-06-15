import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wolf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bear extends Actor
{

    int age=0;
    int babyCD=0;
    int eatCD=100;
    
    public Bear(){
        super();
        getImage().scale(50,40);
    }
    
    public void act(){
    
        
        if (age>300)
          getImage().scale(70,50);
        move(2);
        if(isAtEdge()){
            int r=(int)(Math.random()*360);
            setRotation(r);
        }
        int num=(int)(Math.random()*90);
        if(num==0){
            int angle=(int)(Math.random()*180);
            turn(angle);
        }
        
        age++;
        if(age>=4000){
            getWorld().removeObject(this);
            return;
        }
        
        
        
        babyCD--;
        if(getWorld()!=null &&age>800){
            Actor a=getOneIntersectingObject(Bear.class);
            if (a!=null) {

                if (  a.getWorld()!=null && ((Bear)a).age>=400 && ((Bear)a).babyCD<0 && babyCD<0)
                getWorld().addObject(new Bear(),getX(),getY());
                ((Bear)a).babyCD=200;
                this.babyCD=170;
            }
        }
        eatCD--;
        if(age>200 && eatCD<0){
            Actor a=getOneIntersectingObject(Sheep.class);
            if(a!=null){
                getWorld().removeObject(a);
                this.eatCD=130;
            }
        }
        
        
        
        
        
    }

}
