import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiverCrossing implements ActionListener
{
	//Created all the frames and panels
	private JFrame content = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel arrayPanel = new JPanel();
	private JPanel infoPanel = new JPanel();
	
	//Created JLabels
	private JLabel holdingPlank = new JLabel("<html><body><br> You are holding: </body> </html>");
	private JLabel instruction = new JLabel("<html><body>Click the plank to  pick up <br> the plank</body> </html>");
	private JLabel instruction_two = new JLabel("<html><body><br>Click the stump to <br> move to that stump</body> </html>");
	private JLabel[] plankHoldingLabel = new JLabel[3];
	
	//Created JButtons 
	private JButton restartButton = new JButton("Restart Level");
	private JButton quitButton = new JButton("   Quit Game   ");
	//An array for all the buttons
	private JButton[][] mainArray = new JButton[13][9];	

	//Adding all the images into ImageIcons
	
	//Bank Icons	
	private ImageIcon icon_firstBank = new ImageIcon("RiverCrossingGraphics/bank1.jpg");
	private ImageIcon icon_secondBank = new ImageIcon("RiverCrossingGraphics/bank2.jpg");
	
	//Water Icons
	private ImageIcon icon_waterOne = new ImageIcon("RiverCrossingGraphics/water1.jpg");
	private ImageIcon icon_waterTwo = new ImageIcon("RiverCrossingGraphics/water2.jpg");
	private ImageIcon icon_waterThree = new ImageIcon("RiverCrossingGraphics/water3.jpg");
	private ImageIcon icon_waterFour = new ImageIcon("RiverCrossingGraphics/water4.jpg");
	
	//Stump Icons	
	private ImageIcon icon_stump_one = new ImageIcon("RiverCrossingGraphics/stump1.jpg");
	private ImageIcon icon_stump_two = new ImageIcon("RiverCrossingGraphics/stump2.jpg");
	private ImageIcon icon_stump_three = new ImageIcon("RiverCrossingGraphics/stump3.jpg");
	
	//Man Icons
	private ImageIcon stump1manIcon = new ImageIcon("RiverCrossingGraphics/stump1_man.jpg");
	private ImageIcon stump2manIcon = new ImageIcon("RiverCrossingGraphics/stump2_man.jpg");
	private ImageIcon stump3manIcon = new ImageIcon("RiverCrossingGraphics/stump3_man.jpg");
		
	//Plank Icons
	private ImageIcon plank_one = new ImageIcon("RiverCrossingGraphics/plank1.jpg");//Horizontal Plank
	private ImageIcon plank_two = new ImageIcon("RiverCrossingGraphics/plank2.jpg");//Vertical Plank
	
	private boolean plankCheck;
	
	/* This constructor has all the code for this game.
	* All the panels are added and laid out using Border, Grid and Box Layouts etc.
	* I have used the for loop to add all of the buttons
	* I have used the for loop to add icons to these buttons
	* I have added icons to buttons which are supposed to be in certain places
	*/
	public RiverCrossing()
	{
		mainPanel.setLayout(new BorderLayout());
		arrayPanel.setLayout(new GridLayout(13,9));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
				
		//Adding the bottom bank
		for (int i = 0; i < 9; i++)
		{
			mainArray[12][i] = new JButton(icon_firstBank);
		}
		//Starting position for the player
		mainArray[12][4] = new JButton(stump2manIcon);
		
		//Setting icon_waterOne to all places in between the banks
		for (int a = 1; a < 12; a++)
		{
			for (int b = 0; b < 9; b++)
			{
				mainArray[a][b] = new JButton(icon_waterOne);
			}
		}
		
		for (int t = 0; t <3; t++)
		{
			plankHoldingLabel[t] = new JLabel();
		}
		//Adding the top bank
		for (int i = 0; i < 9; i++)
		{
			mainArray[0][i] = new JButton(icon_secondBank);
		}		
		mainArray[0][4] = new JButton(icon_stump_three);
		
		//Adding stumps into position
		mainArray[2][0] = new JButton(icon_stump_one);
		mainArray[4][4] = new JButton(icon_stump_one);
		mainArray[6][0] = new JButton(icon_stump_one);
		mainArray[6][2] = new JButton(icon_stump_one);
		mainArray[6][6] = new JButton(icon_stump_one);
		mainArray[8][0] = new JButton(icon_stump_one);
		mainArray[8][4] = new JButton(icon_stump_one);
		mainArray[10][0] = new JButton(icon_stump_one);
		
		//Adding planks into position
		mainArray[9][0] = new JButton(plank_two);		
		mainArray[9][4] = new JButton(plank_two);		
		mainArray[10][4] = new JButton(plank_two);		
		mainArray[11][4] = new JButton(plank_two);
		mainArray[6][3] = new JButton(plank_one);		
		mainArray[6][4] = new JButton(plank_one);		
		mainArray[6][5] = new JButton(plank_one);		
		
		//Adding water icons into position
		mainArray[3][7] = new JButton(icon_waterTwo);
		mainArray[6][8] = new JButton(icon_waterTwo);		
		mainArray[3][2] = new JButton(icon_waterThree);
		mainArray[3][3] = new JButton(icon_waterThree);
		mainArray[4][6] = new JButton(icon_waterThree);
		mainArray[10][6] = new JButton(icon_waterThree);		
		mainArray[5][1] = new JButton(icon_waterFour);		
		mainArray[7][3] = new JButton(icon_waterFour);	
		
		//Adds all the buttons to the grid and adds ActionListener to the buttons
		for (int x = 0; x < 13; x++)
		{
			for (int y = 0; y < 9; y++)
			{
				arrayPanel.add(mainArray[x][y]);
				mainArray[x][y].setBorder(null);
				mainArray[x][y].addActionListener(this);
			}
		}
		
		//Adding the quitButton and infoPanel to the buttonPanel
		buttonPanel.add(quitButton);		
		buttonPanel.add(infoPanel);
		
		quitButton.addActionListener(this);

		//Adding instructions to the infoPanel
		infoPanel.add(instruction);
		infoPanel.add(instruction_two);
		infoPanel.add(holdingPlank);

		//Making the label big enough to hold the big plank
		for (int s = 0; s < 3; s++)
		{
			infoPanel.add(plankHoldingLabel[s]);
		}
		
		content.setTitle("River Crossing Game");
		content.setSize(450, 400);			
		content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content.setContentPane(mainPanel);
		content.setLocation(800,150);		
				
		mainPanel.add("East", buttonPanel);
		mainPanel.add(arrayPanel);		
		
		content.setVisible(true);				
	}
		
	/*
	* This constructor has all the Action Listeners assigned to it
	* If a button is pressed, it checks in the actionPerformed constructor to see what command will be carried out
	*/
	public void actionPerformed(ActionEvent e)
	{
		//Exit the game when quit button is pressed
		if (e.getSource() == quitButton)
		{
			System.exit(0);
		}
		
		//If the 8:4 stump is clicked then
		if(e.getSource() == mainArray[8][4])
		{
			//check if there is a plank in between the two stumps
			if(mainArray[9][4].getIcon() == plank_two)
			{
				mainArray[8][4].setIcon(stump1manIcon); //move the man to 8:4 stump
				mainArray[12][4].setIcon(icon_stump_two); //place the normal stump icon in the original place
				mainArray[8][0].setIcon(icon_stump_one);
			}			
			//check if there is a plank in between the two stumps (8:0 - 8:4)
			if(mainArray[8][3].getIcon() == plank_one)
			{
				mainArray[8][4].setIcon(stump1manIcon); //move the man to 8:4 stump
				mainArray[12][4].setIcon(icon_stump_two); //place the normal stump icon in the original place
				mainArray[8][0].setIcon(icon_stump_one); //place the normal stump icon in the original place
			}
		}

		//If the 12:4 (start posiition) stump if clicked then 
		if(e.getSource() == mainArray[12][4])
		{
			
			if (mainArray[12][4].getIcon() != stump2manIcon)//checks if the player isn't already there
			{
				if(mainArray[11][4].getIcon() == plank_two)//checks if there is a plank between two stumps
				{
					mainArray[12][4].setIcon(stump2manIcon);//move the man to 12:4 stump
					mainArray[8][4].setIcon(icon_stump_one);//place the stump on 8:4 place
				}
			}
		}
		
		//if the water/plank is clicked then
		if(e.getSource() == mainArray[11][4]|| e.getSource() == mainArray[10][4]|| e.getSource() == mainArray[9][4])
		{
			//check if there is a plank
			if(mainArray[9][4].getIcon() == plank_two)
			{
				//pick the plank up and show it in the infopanel
				for(int i=0; i < 3; i++)
				{
					plankHoldingLabel[i].setIcon(new ImageIcon("RiverCrossingGraphics/plank2.jpg"));
				}
				//place the water icons in the place of the plank
				mainArray[11][4].setIcon(icon_waterOne);
				mainArray[10][4].setIcon(icon_waterOne);
				mainArray[9][4].setIcon(icon_waterOne);
				plankCheck = true;
			}
			else if(plankCheck == true)
			{
				//check if there isn't a plank
				if(mainArray[9][4].getIcon() != plank_two)
				{
					//remove the plank from the infoPanel
					for(int i=0; i < 3; i++)
					{
						plankHoldingLabel[i].setIcon(null);
					}

					//Place the plank so the player can move
					mainArray[11][4].setIcon(plank_two);
					mainArray[10][4].setIcon(plank_two);
					mainArray[9][4].setIcon(plank_two);	
					plankCheck = false;						
				}			
			}
		}
		
		if(e.getSource() == mainArray[8][0])
		{
			//check if there is a plank
			if(mainArray[8][2].getIcon() == plank_one)
			{
				mainArray[8][0].setIcon(stump1manIcon);//place the man at 8:0
				//mainArray[12][4].setIcon(stump2Icon);//
				mainArray[8][4].setIcon(icon_stump_one);//place the stump at 8:4(source position)
				//mainArray[10][0].setIcon(icon_stump_one);
				//mainArray[6][0].setIcon(icon_stump_one);
			}
		}
		//if the water/plank is clicked then
		if(e.getSource() == mainArray[8][3]||e.getSource() == mainArray[8][2]||e.getSource() == mainArray[8][1])
		{
			//check if there is a plank there
			if(mainArray[8][1].getIcon() == plank_one)
			{
				//get the plank and save in the infoPanel
				for(int i=0; i < 3; i++)
				{
					plankHoldingLabel[i].setIcon(new ImageIcon("RiverCrossingGraphics/plank2.jpg"));
				}
				//Replace the plank with water icons
				mainArray[8][3].setIcon(icon_waterOne);
				mainArray[8][2].setIcon(icon_waterOne);
				mainArray[8][1].setIcon(icon_waterOne);
				plankCheck = true;
			}
			
			else if(plankCheck == true)
			{
				//check if 8:1 is not a plank
				if(mainArray[8][1].getIcon() != plank_one)
					{
						//remove the plank from the infoPanel
						for(int i=0; i < 3; i++)
						{
							plankHoldingLabel[i].setIcon(null);
						}
						//Place the plank so the player can move
						mainArray[8][3].setIcon(plank_one);
						mainArray[8][2].setIcon(plank_one);
						mainArray[8][1].setIcon(plank_one);	
						plankCheck = false;
					}
			}			
		}
		
	}
}