public class NBody {

    /**
     * Read and returns the radius of a universe contained in a given file
     *
     * @param filename the name of the give file
     * @return returns the double radius of the universe
     */
    public static double readRadius(String filename) {
        In in = new In(filename);
        int amount = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /**
     * Read and return a list of planets from a give file;
     *
     * @param filename the name of the give file
     * @return returns a list of planets contained in the file
     */
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int amount = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[amount];
        int index = 0;
        while (index < amount) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[index] = new Planet(xP, yP, xV, yV, m, img);
            index += 1;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "./images/starfield.jpg");
        for (Planet planet : planets) {
            planet.draw();
        }

        StdDraw.enableDoubleBuffering();

        double time = 0;
        int amount = planets.length;
        while (time <= T) {
            double[] xForces = new double[amount];
            double[] yForces = new double[amount];
            for (int i = 0; i < amount; i++) {
                Planet planet = planets[i];
                xForces[i] = planet.calcNetForceExertedByX(planets);
                yForces[i] = planet.calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < amount; i++) {
                Planet planet = planets[i];
                planet.update(time, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for (Planet planet : planets) {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
    }
}
