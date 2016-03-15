package AppliSimu;

import DomaineRoute.Route;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Responsable on 15/03/2016.
 */
public class IHMRoute extends JPanel implements Observer {
    private Route route;

    private void initGraphique() {
        this.setVisible(true);
    }

    public IHMRoute(Route maRoute) {
        super();
        this.route = maRoute;
        maRoute.addObserver(this);
        initGraphique();
    }

    public IHMRoute() {
        super();
        initGraphique();
        this.route = null;
    }

    public void update(Observable o, Object arg) {
        this.repaint();
    }

    @Override
    public void paint(Graphics contexteGraphique) {
        super.paint(contexteGraphique);
        contexteGraphique.setColor(Color.red);
        dessinerRoute(contexteGraphique);
    }

    private void dessinerRoute(Graphics contexteGraphique) {

        contexteGraphique.fillRect((int)(route.getX()-(route.getLargeur()/2.0)), (int)(route.getY()-(route.getLargeur()/2.0)), 30, (int)route.getLargeur());
    }

}
