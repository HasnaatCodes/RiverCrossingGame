import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RiverCrossing
{
	private JFrame content = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel gridPanel = new JPanel();
	private JPanel infoPanel = new JPanel();
	//private JLabel scoreLabel = new JLabel("Score: 0");
	private JButton restartButton = new JButton("Restart Level");
	private JButton quitButton = new JButton("   Quit Game   ");
	
	public RiverCrossing()
	{
		mainPanel.setLayout(new BorderLayout());
		gridPanel.setLayout(new GridLayout(13,9));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(restartButton);
		buttonPanel.add(infoPanel);
		buttonPanel.add(quitButton);
		
		content.setTitle("River Crossing Game");
		content.setSize(1000, 700);			
		content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content.setContentPane(mainPanel);
		
				
		mainPanel.add("East", buttonPanel);
		mainPanel.add(gridPanel);
		
		content.setVisible(true);
				
	}
	
}