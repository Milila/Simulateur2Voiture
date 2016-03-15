package AppliSimu;

import DomaineRoute.Route;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Responsable on 15/03/2016.
 */
public class IHMRoute extends JComponent {
    private Route route;
    private JFrame frame;


    private void initGraphique() {

        this.setVisible(true);
        repaint();
    }

    public IHMRoute(JFrame frame, Route maRoute) {
        super();
        this.setSize(505, 505);
        this.route = maRoute;
        this.frame = frame;
       // maRoute.addObserver(this);
        initGraphique();
        //frame.add(this);
    }

    public IHMRoute(JFrame frame) {
        super();
        initGraphique();
        this.frame = frame;
        this.route = null;
        //frame.add(this);
    }
    /*@Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
    */
    @Override
    public void paintComponent(Graphics contexteGraphique) {
        //super.paint(contexteGraphique);

        contexteGraphique.setColor(Color.BLACK);
        dessinerRoute(contexteGraphique);
    }

    private void dessinerRoute(Graphics contexteGraphique) {

        System.out.println("x " + (int)(route.getX()-(route.getLargeur()/2.0)) + "y " + (int)(route.getY()-(route.getLargeur()/2.0)));
        contexteGraphique.fillRect((int)(route.getX()-(route.getLargeur()/2.0)), (int)(route.getY()-(route.getLargeur()/2.0)), 300, (int)route.getLargeur());
    }

}
