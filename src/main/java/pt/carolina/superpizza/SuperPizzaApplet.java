package pt.carolina.superpizza;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import pt.carolina.superpizza.wizard.WizardApplet;

public class SuperPizzaApplet extends WizardApplet {

	private static final long serialVersionUID = 1L;

	private SuperPizzaModel model = new SuperPizzaModel();

	@Override
	public void init() {
		super.init();

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if (info.getName().equals("Nimbus")) {
					UIManager.setLookAndFeel(info.getClassName());
					SwingUtilities.updateComponentTreeUI(this);
				}
			}
		} catch (Exception exception) {
			System.err.println("Look and feel Nimbus cannot be installed");
		}

		registerWizardPanel(new SelectPizzaSizePanel(model));
		registerWizardPanel(new PizzaSaucePanel(model));
		registerWizardPanel(new IngredientsChoosePanel(model));
		registerWizardPanel(new ResumeOrderPanel(model));
		registerWizardPanel(new FinalPanel(model));

		setInitialPanel(SelectPizzaSizePanel.ID);

		setCurrentPanel(SelectPizzaSizePanel.ID, true);

		setFinishedId(ResumeOrderPanel.ID);

		//        setErrorPanel(ErrorPanel.ID);

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SuperPizzaApplet applet = new SuperPizzaApplet();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(applet);
		frame.setSize(700, 400);
		applet.init();
		applet.start();
		frame.setVisible(true);
	}
}
