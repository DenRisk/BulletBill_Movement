package Physics;

import Sprite.Sphere;

public class Movement {

    public Movement (Sphere sphere, Sphere sphereXY, Sphere sphereXZ, Sphere sphereYZ) {

        path(sphere, sphereXY, sphereXZ, sphereYZ);

    }

    // Methode um einen Quadrat einzugrenzen in der sich die Kugel befindet --> Anwendung siehe ganz unten

    private boolean getSpherePosition (double smallestX, double biggestX, double smallestY, double biggestY, double smallestZ, double biggestZ, Sphere sphere) {

        if (sphere.getX0() > smallestX && sphere.getX0() < biggestX && sphere.getY0() > smallestY && sphere.getY0() < biggestY && sphere.getZ0() > smallestZ && sphere.getZ0() < biggestZ) {
            return true;
        }
        return false;
    }

    private void movingSphere (Sphere sphere) {

        //Ermittlung der Startwerte
        double startX = sphere.getX0();
        double startY = sphere.getY0();
        double startZ = sphere.getZ0();

        double startVx = sphere.getVx();
        double startVy = sphere.getVy();
        double startVz = sphere.getVz();

        double startAx = sphere.getAx();
        double startAy = sphere.getAy();
        double startAz = sphere.getAz();

        // Bewegungsformel für neue Positionen

        double newX = startX + startVx * Time.timeFraction + 0.5 * startAx * (Time.timeFraction * Time.timeFraction);
        double newY = startY + startVy * Time.timeFraction + 0.5 * startAy * (Time.timeFraction * Time.timeFraction);
        double newZ = startZ + startVz * Time.timeFraction + 0.5 * startAz * (Time.timeFraction * Time.timeFraction);

      //  double newVx = startVx + startAx * Time.timeFraction;
      //  double newVy = startVy + startAy * Time.timeFraction;
      //  double newVz = startVz + startAz * Time.timeFraction;

        //setze neue Werte

        sphere.updatePos(newX, newY, newZ);
       // sphere.updateVelocity(newVx, newVy, newVz);
    }


    public void path(Sphere sphere, Sphere sphereXY, Sphere sphereXZ, Sphere sphereYZ) {

        //Ich setzte alle Koordianten gleich
        sphereXY.setZ0(sphereXZ.getZ0());
        sphereXZ.setY0(sphereXY.getY0());
        sphereYZ.setX0(sphereXY.getX0());

        System.out.println( "Pos: " + "x: "  + (int) sphere.getX0() + ", y: " +  (int) sphere.getY0() + ", z: " + (int) sphere.getZ0());
        System.out.println( "Velocity: " + "vx: "  + (int) sphere.getVx() + ", vy: " +  (int) sphere.getVy() + ", vz: " + (int) sphere.getVz());


        //Methode zur Kugelbewegung
        movingSphere(sphere);


        /**
         * Hiermit lasse ich die Kugel durch die strecke laufen in dem ich die Geschwindigkeit in einzelnen Richtungen manipulieren
         */

        if (sphere.getY0() > 137 && sphere.getY0() < 153 ) {
            sphere.setVz(-10);
            sphere.setVy(8);

        }
        if (sphere.getY0() > 153) {
            sphere.setVz(-10);
            sphere.setVy(0);
        }

        if (sphereXZ.getZ0() < 70) {
            sphere.setVx(-5);
            sphere.setVz(-8);
            sphere.setVy(1);
        }

        if (sphereXZ.getZ0() < 65) {
            sphere.setVx(-6);
            sphere.setVz(-6);
            sphere.setVy(3);
        }

        if (sphereXZ.getZ0() < 60) {
            sphere.setVx(-7);
            sphere.setVz(-4);
            sphere.setVy(5);
        }

        if (sphereXZ.getZ0() < 55) {
            sphere.setVx(-8);
            sphere.setVz(-2);
            sphere.setVy(4);
        }


        if (sphereXZ.getZ0() < 50) {
            sphere.setVx(-10);
            sphere.setVz(0);
            sphere.setVy(2);
        }

        if (sphereXY.getX0() < 705){
            sphere.setVy(0);
            sphere.setVx(-8);

        }

        if (sphereXY.getX0() < 695) {
            sphere.setVy(2);
            sphere.setVx(-7);
        }

        if (sphereXY.getX0() < 685) {
            sphere.setVy(5);
            sphere.setVx(-6);
        }

        if (sphereXY.getX0() < 675) {
            sphere.setVy(7);
            sphere.setVx(-4);
        }

        if (sphereXY.getY0() > 205) {
            sphere.setVy(0);
            sphere.setVx(-8);
        }

        // Gerade strecke - Fall auf gerade Strecke

        if (sphereXY.getX0() < 495) {
            sphere.setVy(1);

        }
        if (sphereXY.getX0() < 490) {
            sphere.setVy(2);

        }

        if (sphereXY.getX0() < 485) {
            sphere.setVy(2);

        }

        if (sphereXY.getX0() < 480) {
            sphere.setVy(3);

        }

        if (sphereXY.getX0() < 475) {
            sphere.setVy(4);
            sphere.setVx(-7);
        }

        if (sphereXY.getX0() < 470) {
            sphere.setVy(5);
            sphere.setVx(-6);
        }

        if (sphereXY.getX0() < 465) {
            sphere.setVy(9);
            sphere.setVx(-5);
        }

        //Ball prallt auf (ohne Kollision)

        if (sphereXY.getY0() > 305) {
            sphere.setVy(0);
            sphere.setVx(-8);
        }

        // Ball macht links Kurve

        if (sphereXY.getX0() < 300) {
            sphere.setVz(0);
            sphere.setVx(-10);
        }

        if (sphereXY.getX0() < 290) {
            sphere.setVz(2);
            sphere.setVx(-8);
        }

        if (sphereXY.getX0() < 280) {
            sphere.setVz(4);
            sphere.setVx(-7);
        }

        if (sphereXY.getX0() < 270) {
            sphere.setVz(6);
            sphere.setVx(-6);
        }

        if (sphereXY.getX0() < 260) {
            sphere.setVz(8);
            sphere.setVx(-4);
        }

        if (sphereXY.getX0() < 250) {
            sphere.setVz(10);
            sphere.setVx(0);
        }

        // Ball fällt durch Loch in Kurve

        if (sphereYZ.getZ0() > 130 && sphereYZ.getY0() > 300) {
            sphere.setVz(8);
            sphere.setVy(2);
        }

        if (sphereYZ.getZ0() > 135 && sphereYZ.getY0() > 300) {
            sphere.setVz(6);
            sphere.setVy(4);
        }

        if (sphereYZ.getZ0() > 140 && sphereYZ.getY0() > 300) {
            sphere.setVz(4);
            sphere.setVy(6);
        }

        if (sphereYZ.getZ0() > 145 && sphereYZ.getY0() > 300) {
            sphere.setVz(2);
            sphere.setVy(8);
        }

        if (sphereYZ.getZ0() > 150 && sphereYZ.getY0() > 300) {
            sphere.setVz(0);
            sphere.setVy(10);
        }

        // Kurve nach Fall

        if (sphereYZ.getY0() > 337) {
            sphere.setVy(6);
            sphere.setVz(4);
        }

        if (sphereYZ.getY0() > 340) {
            sphere.setVy(5);
            sphere.setVz(5);
        }

        if (sphereYZ.getY0() > 345) {
            sphere.setVy(4);
            sphere.setVz(7);
        }

        if (sphereYZ.getY0() > 354) {
            sphere.setVy(1);
            sphere.setVz(9);
        }

        if (sphereYZ.getY0() > 355) {
            sphere.setVy(0);
            sphere.setVz(10);
        }

        // Kleiner freier Fall


        if (sphereYZ.getZ0() > 200 && sphereYZ.getY0() > 300) {
            sphere.setVz(8);
            sphere.setVy(2);
        }

        if (sphereYZ.getZ0() > 210 && sphereYZ.getY0() > 300) {
            sphere.setVz(6);
            sphere.setVy(4);
        }

        if (sphereYZ.getZ0() > 220 && sphereYZ.getY0() > 300) {
            sphere.setVz(4);
            sphere.setVy(6);
        }

        if (sphereYZ.getZ0() > 230 && sphereYZ.getY0() > 300) {
            sphere.setVz(2);
            sphere.setVy(8);
        }

        if (sphereYZ.getZ0() > 240 && sphereYZ.getY0() > 300) {
            sphere.setVz(0);
            sphere.setVy(10);
        }

        //Sofortige Rechts Kurve nach kleinem Fall


        if (sphereYZ.getY0() > 405) {
            sphere.setVy(0);
            sphere.setVz(5);
            sphere.setVx(-5);
        }

        if (sphereYZ.getZ0() > 250 && sphereYZ.getY0() > 400 ) {
            sphere.setVz(0);
            sphere.setVx(-10);
        }

        // Nächste Kurve

        if (sphereXZ.getX0() < 90) {
            sphere.setVx(-10);
            sphere.setVz(2);
        }

        if (sphereXZ.getX0() < 80) {
            sphere.setVx(-6);
            sphere.setVz(4);
        }

        if (sphereXZ.getX0() < 70) {
            sphere.setVx(-6);
            sphere.setVz(6);
        }

        if (sphereXZ.getX0() < 60) {
            sphere.setVx(-4);
            sphere.setVz(8);
        }

        if (sphereXZ.getX0() < 50) {
            sphere.setVx(-0);
            sphere.setVz(10);
        }

        // next curve

        if (sphereXZ.getZ0() > 310) {
            sphere.setVz(10);
            sphere.setVx(2);
        }

        if (sphereXZ.getZ0() > 320) {
            sphere.setVz(6);
            sphere.setVx(4);
        }

        if (sphereXZ.getZ0() > 330) {
            sphere.setVz(6);
            sphere.setVx(6);
        }

        if (sphereXZ.getZ0() > 340) {
            sphere.setVz(4);
            sphere.setVx(8);
        }

        if (sphereXZ.getZ0() > 350) {
            sphere.setVz(0);
            sphere.setVx(10);
        }


        /**
         * Hiermit lege ich die einzelnen Element abschnitte fest die die Kugel durchläuft
         *
         * TEST
         */

         /*

         // 01. FreierFall

        if (getSpherePosition(700, 800, 0, 100, 100, 200, sphere)) {
            movingSphere(sphere);
        }

        // 02. Fall-Kurve

        if (getSpherePosition(700, 800, 100, 200, 100, 200, sphere)) {
            sphere.setAy(-1.5);
            sphere.setAz(-3.5);
            movingSphere(sphere);
        }

        // 03. Kurve mit Steigung

        if (getSpherePosition(700, 800, 100, 200, 0, 100, sphere)) {
            sphere.setAx(-10);
            sphere.setAy(5);
            movingSphere(sphere);
        }

        // 04. Kleiner Fall (weiße Fläche)

        if (getSpherePosition(600, 700, 100, 200, 0, 100, sphere)) {
            movingSphere(sphere);
        }

        //05. Gerade Strecke nach kleiner Fall (Kollision noch nicht dabei)

        if (getSpherePosition(600, 700, 200, 300, 0, 100, sphere)) {
            movingSphere(sphere);
        }

        //06. Zweite gerade Strecke

        if (getSpherePosition(500, 600, 200, 300, 0, 100, sphere)) {
            movingSphere(sphere);
        }

        //07. Großer freier Fall

        if (getSpherePosition(400, 500, 200, 300, 0, 100, sphere)) {
            movingSphere(sphere);
        }

        //08. Gerade Strecke nach großem Fall

        if (getSpherePosition(400, 500, 300, 400, 0, 100, sphere)) {
            movingSphere(sphere);
        }

        //09. Zweite Gerade Strecke nach dem großen Fall

        if (getSpherePosition(300, 400, 300, 400, 0, 100, sphere)) {
            movingSphere(sphere);
        }

        //10. Links Kurve nach langer geraden Strecke

        if (getSpherePosition(200, 300, 300, 400, 0, 100, sphere)) {
            movingSphere(sphere);
        }

        //11. Loch in gerader Strecke, Fall mit Kurve

        if (getSpherePosition(200, 300, 300, 400, 100, 200, sphere)) {
            movingSphere(sphere);
        }

        //12. Kleiner Fall in eine Kurve

        if (getSpherePosition(200, 300, 300, 400, 200, 300, sphere)) {
            movingSphere(sphere);
        }

        //13. rechts Kurve nach kleinem Fall

        if (getSpherePosition(200, 300, 400, 500, 200, 300, sphere)) {
            movingSphere(sphere);
        }

        //14. gerade Strecke nach rechts Kurve

        if (getSpherePosition(100, 200, 400, 500, 200, 300, sphere)) {
            movingSphere(sphere);
        }

        //15. Links Kurve

        if (getSpherePosition(0, 100, 400, 500, 200, 300, sphere)) {
            movingSphere(sphere);
        }

        //16. Links Kurve nach links Kurve

        if (getSpherePosition(0, 100, 400, 500, 300, 400, sphere)) {
            movingSphere(sphere);
        }

        //17. gerades Ende

        if (getSpherePosition(100, 200, 400, 500, 300, 400, sphere)) {
            movingSphere(sphere);
        }


        */




        }

}












