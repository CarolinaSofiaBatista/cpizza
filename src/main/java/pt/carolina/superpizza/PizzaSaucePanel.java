package pt.carolina.superpizza;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import pt.carolina.superpizza.wizard.AbstractWizardPanel;

public class PizzaSaucePanel extends AbstractWizardPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	public static final String ID = "PIZZA_SAUCE";
	
	private SuperPizzaModel model;
	
	public PizzaSaucePanel(SuperPizzaModel superPizzaModel) {
		this.model = superPizzaModel;

        initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		
		setLayout(new GridLayout(4, 4, 0, 0));
		JPanel panel = new JPanel();
		panel.add(new JLabel("MAKE YOUR PIZZA - Sauce"));
		panel.add(new JSeparator());	
		JButton jb1 = new JButton("Tomate e Oregãos");
		jb1.addActionListener(this);
		JButton jb2 = new JButton("Barbecue");
		jb2.addActionListener(this);
		JButton jb3 = new JButton("Mexicano");
		jb3.addActionListener(this);
		JButton jb4 = new JButton("Kebab");
		jb4.addActionListener(this);
		JButton jb5 = new JButton("Carbonara");
		jb5.addActionListener(this);
		panel.add(jb1);
		panel.add(jb2);
		panel.add(jb3);
		panel.add(jb4);
		panel.add(jb5);
		add(panel);
	}

	public Object getPanelDescriptorIdentifier() {
		return ID;
	}

	@Override
	public Object getNextPanelDescriptor() {
		return IngredientsChoosePanel.ID;
	}

	@Override
	public Object getBackPanelDescriptor() {
		return SelectPizzaSizePanel.ID;
	}

	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		model.setSauce(jb.getText());
	}

	
}
