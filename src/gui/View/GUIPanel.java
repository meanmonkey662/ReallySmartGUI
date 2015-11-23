package gui.View;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import gui.Controller.GuiController;
import java.awt.Color;
import gui.View.GUIPanel;
import javax.swing.*;
import java.awt.event.*;

public class GUIPanel extends JPanel
{

		private GuiController baseController;
		private JButton firstButton;
		private JTextField firstTextField;
		private SpringLayout baseLayout;

	public GUIPanel(GuiController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new JButton("Do eeettt!!!!");
		firstTextField = new JTextField("Dont even THINK of typing here!!");


		setupPanel();
		setupLayout();
		setupListeners();

	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.orange);
		this.add(firstButton);
		this.add(firstTextField);
		
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 125, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -44, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 58, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 0, SpringLayout.WEST, firstButton);
	}

	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
						firstTextField.setText("Wowwwww......");
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent moved)
			{
				firstButton.setText("Mouse X: " + moved.getX() + " Mouse Y: " + moved.getY());
				
				if((moved.getX() > 25 && moved.getX() < 40) && (moved.getY() > 50 && moved.getY() < 70))
				{
					changeRandomColor();
					
				}
			}
			
			public void mouseDragged(MouseEvent dragged)
			{
				if(dragged.isAltDown())
				{
					firstTextField.setText("you held alt and dragged!");
				}
				
			}
		});
		
		this.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent clicked)
			{
				changeRandomColor();
				if(SwingUtilities.isLeftMouseButton(clicked))
				{
					firstTextField.setText("you are using the left click");
				}
				else if(SwingUtilities.isRightMouseButton(clicked))
				{
					firstTextField.setText("you right clicked");
				}
			}
			
			public void mouseReleased(MouseEvent released)
			{
				changeRandomColor();
			}
			
			public void mousePressed(MouseEvent pressed)
			{
				
			}
			
			public void mouseEntered(MouseEvent entered)
			{
				changeRandomColor();
			}
			
			public void mouseExited(MouseEvent exited)
			{
				changeRandomColor();
			}
		});
	}
	private void changeRandomColor()
	{
		int red, green, blue;
			
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
	}
		
		
	}

