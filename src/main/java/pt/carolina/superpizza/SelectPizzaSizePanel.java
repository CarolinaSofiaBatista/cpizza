package pt.carolina.superpizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import pt.carolina.superpizza.wizard.AbstractWizardPanel;

public class SelectPizzaSizePanel extends AbstractWizardPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static final String ID = "SELECT_PIZZA_SIZE";

	private SuperPizzaModel model;

	private JRadioButton selected = null;

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

		JPanel content = new JPanel(new GridLayout(1, 3, 1, 1));
		add(content, BorderLayout.CENTER);	
		ButtonGroup btnGroup = new ButtonGroup();
		JRadioButton jrbs = new JRadioButton(model.SMALL, new ImageIcon(getClass().getResource("pizza.jpg")), true);
		jrbs.setActionCommand(model.SMALL);
		jrbs.addActionListener(this);
		//		jrbs.setSize(new Dimension(10,10));
		jrbs.setHorizontalTextPosition(SwingConstants.CENTER);
		jrbs.setVerticalTextPosition(JRadioButton.BOTTOM);
		JRadioButton jrbm = new JRadioButton(model.MEDIUM, new ImageIcon(getClass().getResource("pizza.jpg")));
		jrbm.setActionCommand(model.MEDIUM);
		jrbm.addActionListener(this);
		jrbm.setHorizontalTextPosition(SwingConstants.CENTER);
		jrbm.setVerticalTextPosition(JRadioButton.BOTTOM);
		JRadioButton jrbb = new JRadioButton(model.BIG, new ImageIcon(getClass().getResource("pizza.jpg")));
		jrbb.setActionCommand(model.BIG);
		jrbb.addActionListener(this);
		jrbb.setHorizontalTextPosition(SwingConstants.CENTER);
		jrbb.setVerticalTextPosition(JRadioButton.BOTTOM);
		btnGroup.add(jrbs);
		btnGroup.add(jrbm);
		btnGroup.add(jrbb);
		content.add(jrbs);
		content.add(jrbm);
		content.add(jrbb);
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

	public void actionPerformed(ActionEvent e) {
		JRadioButton jrb = (JRadioButton) e.getSource();
		if(selected != null){
			selected.setIcon(new ImageIcon(getClass().getResource("pizza.jpg")));
		}
		selected = jrb;
		jrb.setIcon(new ImageIcon(getClass().getResource("selected.jpg")));
		model.setPizzaSize(e.getActionCommand());
	}
}
