package it.unimol.save_the_bird.application;

public class CollisionHandler {

    /**
     * Verifica l'eventuale collisione dell'oggetto Bird con l'oggetto Bullet.
     *
     * @return True se la collisione a' avvenuta.
     * @param bird uccello
     * @param bullet proiettile
     */
    public static boolean checkCollision(Bird bird, Bullet bullet) {
        return bird.getBorder().intersects(bullet.getBorder());
    }
}