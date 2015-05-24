package pt.carolina.superpizza;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pt.carolina.superpizza.wizard.AbstractWizardPanel;

public class FinalPanel extends AbstractWizardPanel{

	private static final long serialVersionUID = 1L;

	public static final String ID = "CONFIRMATION";

	private SuperPizzaModel model;

	public FinalPanel(SuperPizzaModel superPizzaModel) {
		this.model = superPizzaModel;
		initComponents();
	}

	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		JLabel lblMakeYourPizza = new JLabel("Thank you for your Order!");
		lblMakeYourPizza.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMakeYourPizza);
		add(panel);

	}

	public Object getPanelDescriptorIdentifier() {
		return ID;
	}

	@Override
	public Object getNextPanelDescriptor() {
		return null;
	}

	@Override
	public Object getBackPanelDescriptor() {
		return null;
	}
}
