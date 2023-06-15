import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Grass extends Actor
{
    
    int age=0;
    int babyAmount=0;
    int babyTimer=0;
    int babyCD=75;
    public void act()
    {
        age++;
        babyTimer=(int)(Math.random()*100);

         if(age>=500){
            World w=getWorld();
            w.removeObject(this);
            return;
        }
        List <Grass> grassCount= getObjectsInRange(2000, Grass.class);
       
        babyCD--;
        if(babyTimer==2 && babyCD<0 && grassCount.size()<45 && this!=null){
            babyAmount=(int)(Math.random()*4)+1;
            for(int k=0; k<babyAmount; k++){
                
                int amountx=(int)(Math.random()*180)-90;
                int amounty=(int)(Math.random()*180)-90;
                if(-40<amountx && amountx<40){
                    amountx=amountx * 2;
                }
                if(-40<amounty && amounty<40){
                    amounty=amounty * 2;
                }
                getWorld().addObject(new Grass(), getX()+amountx, getY()+amounty);
                babyCD=300;
            }
        }
    }
}
