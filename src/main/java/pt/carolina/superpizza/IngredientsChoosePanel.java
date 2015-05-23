package pt.carolina.superpizza;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

import pt.carolina.superpizza.wizard.AbstractWizardPanel;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class IngredientsChoosePanel extends AbstractWizardPanel {
	
	private static final long serialVersionUID = 1L;

	public static final String ID = "INGREDIENTS_CHOOSE";
	
	private SuperPizzaModel model;
	
	private JLabel errorLbl = new JLabel();
	
	String[] listData = {"Azeitonas","Frango","Pepperoni","Banana","Cogumelos","Milho","Fiambre","Bacon","Atum","Camarão","Peru","Cebola","Chouriço","Pimento","Espinafres","Ananás"};
	
	public IngredientsChoosePanel(SuperPizzaModel superPizzaModel) {
		this.model = superPizzaModel;

        initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		
		setLayout(new GridLayout(4, 4, 0, 0));
		JPanel panel = new JPanel();
		panel.add(new JLabel("MAKE YOUR PIZZA - Ingredients"));
		panel.add(new JSeparator());
		panel.add(errorLbl);
		add(panel);
		
		JList<String> list = new JList<String>(listData);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				JList<String> source = (JList)e.getSource();
	            List<String> selectedValuesList = source.getSelectedValuesList();
	            if(selectedValuesList.size() > 3){
	            	source.clearSelection();
	            	errorLbl.setText("Ups! You select more than 3 ingredients! It's not a mega Pizza!!");
	            }else{
	            	model.setIngredients(selectedValuesList);
	            }
			}
		});
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		panel.add(listScroller);
		
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

}
