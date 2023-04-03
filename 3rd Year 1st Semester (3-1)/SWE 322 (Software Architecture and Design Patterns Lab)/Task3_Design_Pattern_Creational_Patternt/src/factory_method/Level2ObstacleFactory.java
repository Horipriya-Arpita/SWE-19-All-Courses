/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory_method;

/**
 *
 * @author ASUS
 */
public abstract class Level2ObstacleFactory implements ObstacleFactory{
    
    @Override
    public Obstacle createAsteroid(int score) {
        int r = (int)(Math.random() * 2) + 1;
        if(r==1){
           return new Rocky_Asteroids(); 
        }
        else {
            return new Silicon_Asteroids();
        }
    }

    @Override
    public Obstacle createDebrisField(int score) {
        int r = (int)(Math.random() * 2) + 1;
        if(r==1){
           return new Large_Metal_DebrisFeild(); 
        }
        else {
            return new Large_Crystal_DebrisFeild();
        }
    }
    
    @Override
    public Obstacle createSolarFlare(int score) {
        return new Large_SolarFlares();
    }
    
    @Override
    public Obstacle createEnemyShip(int score) {
        int r = (int)(Math.random() * 2) + 1;
        if(r==1){
           return new Blue_EnemyShips(); 
        }
        else {
            return new Red_EnemyShips();
        }
    }
    
    @Override
    public Obstacle createBlackHole(int score) {
        return new Large_BlackHoles();
    }
}
