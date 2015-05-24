package pt.carolina.superpizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pt.carolina.superpizza.wizard.AbstractWizardPanel;

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
		setLayout(new BorderLayout());
		JPanel headerContent = new JPanel(new BorderLayout());

		JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
		header.setBackground(Color.GRAY);
		JLabel title = new JLabel("MAKE YOUR PIZZA");
		title.setFont(new Font("arial", Font.BOLD, 12));
		header.add(title);
		headerContent.add(header, BorderLayout.NORTH);
		JPanel breadcrumb = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 6));
		breadcrumb.setBackground(Color.LIGHT_GRAY);
		JLabel lblBreadcrumb = new JLabel("> Please select pizza size");
		breadcrumb.add(lblBreadcrumb);
		headerContent.add(breadcrumb, BorderLayout.SOUTH);
		add(headerContent, BorderLayout.NORTH);

		JPanel content = new JPanel(new GridLayout(6,3));
		add(content, BorderLayout.SOUTH);

		//So para exemplo
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
