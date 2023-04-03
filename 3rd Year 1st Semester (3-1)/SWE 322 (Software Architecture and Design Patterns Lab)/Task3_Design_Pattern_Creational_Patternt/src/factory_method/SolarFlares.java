/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory_method;

/**
 *
 * @author ASUS
 */
public abstract class SolarFlares implements Obstacle{
    
    @Override
    public void show(){
        System.out.println("SolarFlares popped up");
    }
    
}

class Small_SolarFlares extends SolarFlares{
    @Override
    public void show(){
        System.out.println("Small_SolarFlares popped up");
    }
    
}

class Large_SolarFlares extends SolarFlares{
    @Override
    public void show(){
        System.out.println("Large_SolarFlares popped up");
    }
    
}