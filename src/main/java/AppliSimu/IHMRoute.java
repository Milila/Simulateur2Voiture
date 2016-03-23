package appliSimu;

import domaineRoute.Route;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Responsable on 15/03/2016.
 */
public class IHMRoute extends JComponent implements Observer {
    private Route route;

    private void initGraphique() {
        this.setVisible(true);
    }

    public IHMRoute(Route maRoute) {
        super();
        this.route = maRoute;
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics contexteGraphique) {
        System.out.println("paint IHMRoute");
        super.paintComponent(contexteGraphique);
        contexteGraphique.setColor(Color.BLACK);
        dessinerRoute(contexteGraphique);
    }

    private void dessinerRoute(Graphics contexteGraphique) {
        contexteGraphique.drawLine(route.getX1(),route.getY1(),route.getX2(),route.getY2());
        contexteGraphique.drawLine(route.getX1(),route.getY1()-40,route.getX2(),route.getY2()-40);
    }


    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
