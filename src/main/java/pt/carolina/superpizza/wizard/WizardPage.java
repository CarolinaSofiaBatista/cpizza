package pt.carolina.superpizza.wizard;

/**
 * A page in the wizard
 */

public interface WizardPage {

	/**
	 * Returns the unique Object-based identifier for this panel descriptor.
	 * 
	 * @return The Object-based identifier
	 */
	public abstract Object getPanelDescriptorIdentifier();

	/**
	 * Set the wizard that contains this page
	 * 
	 * @param wizard
	 */
	void setWizard(WizardApplet wizard);

	/**
	 * Override this class to provide the Object-based identifier of the panel that the user should traverse to when the
	 * Next button is pressed. Note that this method is only called when the button is actually pressed, so that the
	 * panel can change the next panel's identifier dynamically at runtime if necessary. Return null if the button
	 * should be disabled. Return FinishIdentfier if the button text should change to 'Finish' and the dialog should
	 * end.
	 * 
	 * @return Object-based identifier.
	 */
	public abstract Object getNextPanelDescriptor();

	/**
	 * Override this class to provide the Object-based identifier of the panel that the user should traverse to when the
	 * Back button is pressed. Note that this method is only called when the button is actually pressed, so that the
	 * panel can change the previous panel's identifier dynamically at runtime if necessary. Return null if the button
	 * should be disabled.
	 * 
	 * @return Object-based identifier
	 */
	public abstract Object getBackPanelDescriptor();

	/**
	 * Override this method to provide functionality that will be performed just before the panel is to be displayed.
	 */
	public abstract void aboutToDisplayPanel() throws Exception;

	/**
	 * Override this method to perform functionality when the panel itself is displayed.
	 */
	public abstract void displayingPanel();

	/**
	 * Override this method to perform functionality just before the panel is to be hidden.
	 */
	public abstract boolean aboutToHidePanel();

	/**
	 * Return true if the panel must be skipped
	 * 
	 * @return
	 */
	public abstract boolean skipPanel();

}