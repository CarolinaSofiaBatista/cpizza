package pt.carolina.superpizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import pt.carolina.superpizza.wizard.AbstractWizardPanel;

public class PizzaSaucePanel extends AbstractWizardPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	public static final String ID = "PIZZA_SAUCE";

	private SuperPizzaModel model;

	private JButton selected = null;

	private JButton jb1 = null;

	public PizzaSaucePanel(SuperPizzaModel superPizzaModel) {
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
		JLabel lblBreadcrumb = new JLabel("> Select your prefered sauce");
		breadcrumb.add(lblBreadcrumb);
		headerContent.add(breadcrumb, BorderLayout.SOUTH);
		add(headerContent, BorderLayout.NORTH);

		JPanel content = new JPanel(new GridLayout(2, 2, 1, 1));
		add(content, BorderLayout.CENTER);	
		jb1 = new JButton("Tomate e Oregãos", new ImageIcon(getClass().getResource("sauce.jpg")));
		jb1.addActionListener(this);
		jb1.setVerticalTextPosition(SwingConstants.CENTER);
		jb1.setHorizontalTextPosition(SwingConstants.CENTER);
		jb1.setToolTipText("Tomate e Oregãos");
		JButton jb2 = new JButton("Barbecue", new ImageIcon(getClass().getResource("sauce.jpg")));
		jb2.addActionListener(this);
		jb2.setVerticalTextPosition(SwingConstants.CENTER);
		jb2.setHorizontalTextPosition(SwingConstants.CENTER);
		jb2.setToolTipText("Barbecue");
		JButton jb3 = new JButton("Mexicano", new ImageIcon(getClass().getResource("sauce.jpg")));
		jb3.addActionListener(this);
		jb3.setVerticalTextPosition(SwingConstants.CENTER);
		jb3.setHorizontalTextPosition(SwingConstants.CENTER);
		jb3.setToolTipText("Mexicano");
		JButton jb4 = new JButton("Kebab", new ImageIcon(getClass().getResource("sauce.jpg")));
		jb4.addActionListener(this);
		jb4.setVerticalTextPosition(SwingConstants.CENTER);
		jb4.setHorizontalTextPosition(SwingConstants.CENTER);
		jb4.setToolTipText("Kebab");
		JButton jb5 = new JButton("Carbonara", new ImageIcon(getClass().getResource("sauce.jpg")));
		jb5.addActionListener(this);
		jb5.setVerticalTextPosition(SwingConstants.CENTER);
		jb5.setHorizontalTextPosition(SwingConstants.CENTER);
		jb5.setToolTipText("Carbonara");
		JButton jb6 = new JButton("Portuguesa", new ImageIcon(getClass().getResource("sauce.jpg")));
		jb6.addActionListener(this);
		jb6.setVerticalTextPosition(SwingConstants.CENTER);
		jb6.setHorizontalTextPosition(SwingConstants.CENTER);
		jb6.setToolTipText("Portuguesa");
		content.add(jb1);
		content.add(jb2);
		content.add(jb3);
		content.add(jb4);
		content.add(jb5);
		content.add(jb6);
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
		if(selected != null){
			selected.setBorder(null);
		}
		selected = jb;
		jb.setBorder(new LineBorder(Color.WHITE, 12));
		model.setSauce(jb.getText());
	}

	@Override
	public void aboutToDisplayPanel() throws Exception {
		//default Sauce
		jb1.doClick();
	}

}
