package appliSimu;

import java.awt.*;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;


import domaineRoute.Route;
import domaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
	private CommandeVoiture maCommandeVoiture;
	private Route route;
	
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);
		this.setLayout(new BorderLayout());
		add(this.maCommandeVoiture = new CommandeVoiture(this, maVoiture),BorderLayout.NORTH);
		add(new IHMRoute(route),BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public IHMVoiture(Voiture maVoiture, Route route) {
		super();
		this.maVoiture = maVoiture;
		maVoiture.addObserver(this);
		this.route = route;
		initGraphique();
	}

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
	}
	
	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	//@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		contexteGraphique.setColor(Color.red);
		dessinerVoiture(contexteGraphique);

	}


	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
		contexteGraphique.fillRect(xPixel, 300, 30, 15);
	}
	
}
