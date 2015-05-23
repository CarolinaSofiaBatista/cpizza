package pt.carolina.superpizza;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import pt.carolina.superpizza.wizard.AbstractWizardPanel;

public class ResumeOrderPanel extends AbstractWizardPanel{
	
	private static final long serialVersionUID = 1L;

	public static final String ID = "RESUME_ORDER";
	
	private SuperPizzaModel model;
	
	private JLabel pizzaSizeName = new JLabel();
	private JLabel sauceName = new JLabel();
	private JLabel ingredientsName = new JLabel();
	private JLabel lblPrice = new JLabel();
	
	public ResumeOrderPanel(SuperPizzaModel superPizzaModel) {
		this.model = superPizzaModel;

        initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		
		setLayout(new GridLayout(4, 4, 0, 0));
		JPanel panel = new JPanel();
		panel.add(new JLabel("RESUME ORDER"));
		panel.add(new JSeparator());
		panel.add(pizzaSizeName);
		panel.add(sauceName);
		panel.add(ingredientsName);
		panel.add(lblPrice);
		add(panel);
		
	}

	
	@Override
	public void displayingPanel() {
		pizzaSizeName.setText(model.getPizzaSizeName());
		sauceName.setText(model.getSauceName());
		ingredientsName.setText(model.getIngredientsName());
		lblPrice.setText(model.getPrice());
	}
	
	
	public Object getPanelDescriptorIdentifier() {
		return ID;
	}

	@Override
	public Object getNextPanelDescriptor() {
		return FinalPanel.ID;
	}

	@Override
	public Object getBackPanelDescriptor() {
		return IngredientsChoosePanel.ID;
	}
}
