package pt.carolina.superpizza;

import java.awt.Color;
import java.awt.FlowLayout;

import pt.carolina.superpizza.wizard.AbstractWizardPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class SelectPizzaSizePanel extends AbstractWizardPanel {
	
	private static final long serialVersionUID = 1L;

	public static final String ID = "SELECT_PIZZA_SIZE";
	
	private SuperPizzaModel model;
	
	public SelectPizzaSizePanel(SuperPizzaModel superPizzaModel) {
		this.model = superPizzaModel;
        initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		
//		setLayout(new FlowLayout());
		JPanel header = new JPanel();
		header.setLayout(new GridLayout(4, 4, 2, 2));
		JLabel lblMakeYourPizza = new JLabel("MAKE YOUR PIZZA");
		lblMakeYourPizza.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(lblMakeYourPizza);
		JSeparator comp = new JSeparator();
		header.add(comp);
		header.setBackground(Color.WHITE);
		header.add(new JLabel("> Please select pizza size:"));
		add(header);
		
		
		model.setPizzaSize(model.MEDIUM);
	}

	public Object getPanelDescriptorIdentifier() {
		return ID;
	}

	@Override
	public Object getNextPanelDescriptor() {
		return PizzaSaucePanel.ID;
	}

	@Override
	public Object getBackPanelDescriptor() {
		return null;
	}
}
