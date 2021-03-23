public class TestPlanet {
    public static void main(String[] args) {
        
        Planet planet1 = new Planet(0, 0, 0, 0, 1e12, "planet1");
        Planet planet2 = new Planet(3, 3, 2, 4, 7.5e11, "planet2");
        System.out.println("force-x of planet2 on planet1: " + planet1.calcForceExertedByX(planet2));
        System.out.println("force-y of planet2 on planet1: " + planet1.calcForceExertedByY(planet2));
        planet1.update(0.05, planet1.calcForceExertedByX(planet2), planet1.calcForceExertedByY(planet2));
        String outString = "planet1 x position: " + planet1.xxPos 
        + " planet1 y position: " + planet1.yyPos + " planet x velocity: " + planet1.xxVel + " planet1 y velocity: " + planet1.yyVel;
        System.out.println(outString);
    }
}
