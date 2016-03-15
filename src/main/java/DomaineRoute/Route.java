package DomaineRoute;

import java.util.Observable;

/**
 * Created by Responsable on 15/03/2016.
 */
public class Route extends Observable{
    float x;
    float y;
    float largeur;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getLargeur() {
        return largeur;
    }

    public Route(float x, float y, float largeur)
    {
        this.x=x;
        this.y=y;
        this.largeur=largeur;
    }

}
