/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package factory_method;

/**
 *
 * @author ASUS
 */
public interface ObstacleFactory {
    Obstacle createAsteroid(int score);
    Obstacle createDebrisField(int score);
    Obstacle createSolarFlare(int score);
    Obstacle createEnemyShip(int score);
    Obstacle createBlackHole(int score);
}
 
