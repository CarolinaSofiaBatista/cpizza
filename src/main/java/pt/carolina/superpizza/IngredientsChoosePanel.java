package pt.carolina.superpizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pt.carolina.superpizza.wizard.AbstractWizardPanel;

public class IngredientsChoosePanel extends AbstractWizardPanel {

	private static final long serialVersionUID = 1L;

	public static final String ID = "INGREDIENTS_CHOOSE";

	private SuperPizzaModel model;

	String[] listData = {"Azeitonas","Frango","Pepperoni","Banana","Cogumelos","Milho","Fiambre","Bacon","Atum","Camarão","Peru","Cebola","Chouriço","Pimento","Espinafres","Ananás"};

	public IngredientsChoosePanel(SuperPizzaModel superPizzaModel) {
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
		JLabel lblBreadcrumb = new JLabel("> Select 3 Ingredients");
		breadcrumb.add(lblBreadcrumb);
		headerContent.add(breadcrumb, BorderLayout.SOUTH);
		add(headerContent, BorderLayout.NORTH);

		JPanel content = new JPanel(new GridLayout(2, 2));
		add(content, BorderLayout.CENTER);

		JList<String> list = new JList<String>(listData);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				JList<String> source = (JList)e.getSource();
				List<String> selectedValuesList = source.getSelectedValuesList();
				if(selectedValuesList.size() > 3){
					source.clearSelection();
					JOptionPane.showMessageDialog (getParent(), "Ups! You select more than 3 ingredients! This is not a mega Pizza!!", "Validation", JOptionPane.WARNING_MESSAGE);
				}else {
					model.setIngredients(selectedValuesList);
				}
			}
		});
		JScrollPane listScroller = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane. HORIZONTAL_SCROLLBAR_NEVER);
		content.add(listScroller);

	}

	public Object getPanelDescriptorIdentifier() {
		return ID;
	}

	@Override
	public Object getNextPanelDescriptor() {
		return ResumeOrderPanel.ID;
	}

	@Override
	public Object getBackPanelDescriptor() {
		return PizzaSaucePanel.ID;
	}

	@Override
	public boolean aboutToHidePanel() {
		if(model.getIngredients().size() < 1){
			JOptionPane.showMessageDialog (getParent(), "Please select at least one ingredient!!", "Validation", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

}
