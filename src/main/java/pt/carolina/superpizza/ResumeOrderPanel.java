package pt.carolina.superpizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pt.carolina.superpizza.wizard.AbstractWizardPanel;

public class ResumeOrderPanel extends AbstractWizardPanel{

	private static final long serialVersionUID = 1L;

	public static final String ID = "RESUME_ORDER";

	private SuperPizzaModel model;

	private JLabel pizzaSizeName = new JLabel("pizzaSizeName");
	private JLabel sauceName = new JLabel("sauceName");
	private JLabel ingredientsName = new JLabel("ingredientsName");
	private JLabel lblPrice = new JLabel("lblPrice");

	public ResumeOrderPanel(SuperPizzaModel superPizzaModel) {
		this.model = superPizzaModel;

		initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
		header.setBackground(Color.GRAY);
		JLabel title = new JLabel("RESUME ORDER");
		title.setFont(new Font("arial", Font.BOLD, 12));
		header.add(title);
		add(header, BorderLayout.NORTH);
		JPanel content = new JPanel(new GridLayout(8, 0));
		pizzaSizeName.setHorizontalAlignment(SwingConstants.CENTER);
		content.add(pizzaSizeName);
		sauceName.setHorizontalAlignment(SwingConstants.CENTER);
		content.add(sauceName);
		ingredientsName.setHorizontalAlignment(SwingConstants.CENTER);
		content.add(ingredientsName);
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		Font f = lblPrice.getFont();
		lblPrice.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		content.add(lblPrice);
		add(content, BorderLayout.CENTER);
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
