package gui.View;

import javax.swing.JFrame;
import gui.Controller.GuiController;

public class GUIFrame extends JFrame
{

		private GuiController baseController;
		private GUIPanel basePanel;

	public GUIFrame(GuiController baseController)
	{
		this.baseController = baseController;
		basePanel = new GUIPanel(baseController);
		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setTitle("Frankenstein application");
		this.setSize(400,400);
		this.setVisible(true);
	}
	
	public GuiController getBaseController()
	{
		return baseController;
	}
}

