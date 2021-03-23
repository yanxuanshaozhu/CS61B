public class Planet {

    public static double gravityConst = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /**
     * The first constructor, creates a planet with given parameters
     *
     * @param xP: planet x position
     * @param yP: planet y position
     * @param xV: planet x direction velocity
     * @param yV: planet y direction velocity
     * @m: planet mass
     * @img: planet figure
     */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    /**
     * Second constructor, carets a planet that is the same as the given planet.
     *
     * @param a given planet
     */
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /**
     * Calculate the distance between self planet and a given planet
     *
     * @param p a given planet
     * @return returns the distance between self planet and a given planet
     */
    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Calculate the force between self planet and a given planet
     *
     * @param p a given planet
     * @return returns the force between self planet and a given planet
     */
    public double calcForceExertedBy(Planet p) {
        double dist = this.calcDistance(p);
        return Planet.gravityConst * this.mass * p.mass / (dist * dist);
    }

    /**
     * Calculate the force in x direction between self planet and a given planet
     *
     * @param p a given planet
     * @return returns the force in x direction between self planet and a given
     * planet
     */
    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dist = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return force * dx / dist;
    }

    /**
     * Calculate the force in y direction between self planet and a given planet
     *
     * @param p a given planet
     * @return returns the force in y direction between self planet and a given
     * planet
     */
    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        double dist = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return force * dy / dist;
    }

    /**
     * Calculate the net force in x direction among self planet and a list of
     * planets
     *
     * @param planets a list of planets
     * @return returns the net force in x direction among self planet and a list of
     * planets
     */
    public double calcNetForceExertedByX(Planet[] planets) {
        double netforcex = 0;
        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                double dx = planet.xxPos - this.xxPos;
                double dist = this.calcDistance(planet);
                double force = this.calcForceExertedBy(planet);
                double forcex = force * dx / dist;
                netforcex += forcex;
            }
        }
        return netforcex;
    }

    /**
     * Calculate the net force in y direction among self planet and a list of
     * planets
     *
     * @param planets a list of planets
     * @return returns the net force in y direction among self planet and a list of
     * planets
     */
    public double calcNetForceExertedByY(Planet[] planets) {
        double netforcey = 0;
        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                double dy = planet.yyPos - this.yyPos;
                double dist = this.calcDistance(planet);
                double force = this.calcForceExertedBy(planet);
                double forcey = force * dy / dist;
                netforcey += forcey;
            }
        }
        return netforcey;
    }

    /**
     * Update self velocity and self position
     *
     * @param time   the duration of the force
     * @param forcex force in x direction
     * @param forcey force in y direction
     */
    public void update(double time, double forcex, double forcey) {
        double ax = forcex / this.mass;
        double ay = forcey / this.mass;
        this.xxVel += time * ax;
        this.yyVel += time * ay;
        this.xxPos += this.xxVel * time;
        this.yyPos += this.yyVel * time;
    }

    /**
     * Draw a picture of the planet using the StdDraw library
     */
    public void draw() {

        double x = this.xxPos;
        double y = this.yyPos;
        String filename = this.imgFileName;
        StdDraw.picture(x, y, filename);
    }

}
