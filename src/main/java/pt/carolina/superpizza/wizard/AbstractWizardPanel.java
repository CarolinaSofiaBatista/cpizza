package pt.carolina.superpizza.wizard;

import javax.swing.JPanel;

/**
 * A base descriptor class used to reference a Component panel for the Wizard, as well as provide general rules as to
 * how the panel should behave.
 * 
 *
 * @version $Revision$ - $Date$
 */

public abstract class AbstractWizardPanel extends JPanel implements WizardPage {

	private static final long serialVersionUID = 7026600435866199431L;

	private WizardApplet wizard;

	public void setWizard(WizardApplet w) {
		wizard = w;
	}

	/**
	 * Returns a reference to the Wizard component.
	 * 
	 * @return The Wizard class hosting this descriptor.
	 */
	public final WizardApplet getWizard() {
		return wizard;
	}

	public abstract Object getNextPanelDescriptor();

	public abstract Object getBackPanelDescriptor();

	public void aboutToDisplayPanel() throws Exception {

	}

	public void displayingPanel() {

	}

	public boolean aboutToHidePanel() {
		return true;
	}

	public boolean skipPanel() {
		return false;
	}
}
