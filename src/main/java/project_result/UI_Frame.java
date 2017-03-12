package project_result;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UI_Frame extends JFrame implements ActionListener, Runnable {

	JFrame frame;
	Stack<String> inst = Buffer.instructions;
	Queue<String> str_inst = Buffer.storyboard_instructions;
	Queue<JLabel> stry_time = Buffer.storybaord_timeline;

	private JPanel centerPanel, leftPanel, rightPanel, lowerMainPanel,
			upperPanel, mainPanel, headingPanel;
	private JButton btnConsoleLight1, btnConsoleLight2, btnBothConsole,
			btnNavigateUp, btnNavigateDown, btnNavigateLeft, btnNavigateRight,
			btnRun, btnTerminate, btnPause;
	private JSlider speed, duration;
	private JLabel lblSpeed, lblDuration, lblShowSpeed, 
			lblUpArrow, lblDownArrow, lblRightArrow, lblLeftArrow, lblPause,
			lblRightLight, lblLeftLight, lblBothLight, lblHorn, copyLblUpArrow,
			copyLblDownArrow, copyLblRightArrow, copyLblLeftArrow,
			copyLblPause, copyLblRightLight, copyLblLeftLight,
			copyLblBothLight, copyLblHorn, lblAction, lblTitle, lblControl;	
	private JToolBar toolBar;
	private URL imageURL;
    private Thread thread;

	
	/**
	 * Create the application.
	 */
	public UI_Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
        thread = new Thread (this, "UI_FRAME_THREAD");
        thread.start ();
        
		frame = new JFrame();
		frame.setSize(1000, 600);

		toolBar = new JToolBar();
		toolBar.setRollover(true);

		btnRun = addToolbarButton("/Users/hongdavid/Desktop/images/run_top.png", btnRun, "Run");
		toolBar.add(btnRun);
		btnRun.addActionListener(this);
		toolBar.addSeparator();

		btnPause = addToolbarButton("/Users/hongdavid/Desktop/images/pause_menu.png", btnPause, "Pause");
		toolBar.add(btnPause);
		btnPause.addActionListener(this);
		toolBar.addSeparator();

		btnTerminate = addToolbarButton("/Users/hongdavid/Desktop/images/stop_menu.png", btnTerminate,"Stop");
		toolBar.add(btnTerminate);
		btnTerminate.addActionListener(this);

		headingPanel = new JPanel(new GridLayout(1, 3));
		lblAction = new JLabel("<html><b>Action ICON</b></html>",
				SwingConstants.CENTER);
		lblAction.setForeground(Color.WHITE);
		lblTitle = new JLabel("<html><b>Title of the Action</b></html>",
				SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblControl = new JLabel("<html><b>Control Panel</b></html>",
				SwingConstants.CENTER);
		lblControl.setForeground(Color.WHITE);
		headingPanel.setBackground(Color.BLACK);
		headingPanel.add(lblAction);
		headingPanel.add(lblTitle);
		headingPanel.add(lblControl);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		leftPanel = new JPanel(new GridLayout(3, 3, 5, 5));
		leftPanel.setBackground(Color.GRAY);
		
		lblUpArrow = new JLabel();
		lblUpArrow.setBounds(20, 30, 50, 50);
		lblUpArrow.setIcon(new ImageIcon("/Users/hongdavid/Desktop/images/top.png"));
		lblUpArrow.addMouseListener(new PointListener());

		lblRightArrow = new JLabel();
		lblRightArrow.setBounds(20, 30, 50, 50);
		lblRightArrow.setIcon(new ImageIcon("/Users/hongdavid/Desktop/images/left.png"));
		lblRightArrow.addMouseListener(new PointListener());

		lblDownArrow = new JLabel();
		lblDownArrow.setBounds(20, 30, 50, 50);
		lblDownArrow.setIcon(new ImageIcon("/Users/hongdavid/Desktop/images/down.png"));
		lblDownArrow.addMouseListener(new PointListener());

		lblLeftArrow = new JLabel();
		lblLeftArrow.setBounds(20, 30, 50, 50);
		lblLeftArrow.setIcon(new ImageIcon("/Users/hongdavid/Desktop/images/right.png"));
		lblLeftArrow.addMouseListener(new PointListener());

		lblPause = new JLabel();
		lblPause.setBounds(20, 30, 50, 50);
		lblPause.setIcon(new ImageIcon("/Users/hongdavid/Desktop/images/break.png"));
		lblPause.addMouseListener(new PointListener());

		lblRightLight = new JLabel();
		lblRightLight.setBounds(20, 30, 50, 50);
		lblRightLight.setIcon(new ImageIcon("/Users/hongdavid/Desktop/images/right_light.png"));
		lblRightLight.addMouseListener(new PointListener());

		lblLeftLight = new JLabel();
		lblLeftLight.setBounds(20, 30, 50, 50);
		lblLeftLight.setIcon(new ImageIcon("/Users/hongdavid/Desktop/images/left_light.png"));
		lblLeftLight.addMouseListener(new PointListener());

		lblBothLight = new JLabel();
		lblBothLight.setBounds(20, 30, 50, 50);
		lblBothLight.setIcon(new ImageIcon("/Users/hongdavid/Desktop/images/both_light.png"));
		lblBothLight.addMouseListener(new PointListener());

		lblHorn = new JLabel();
		lblHorn.setBounds(20, 30, 50, 50);
		lblHorn.setIcon(new ImageIcon("/Users/hongdavid/Desktop/images/horn.png"));
		lblHorn.addMouseListener(new PointListener());

		leftPanel.add(lblUpArrow);
		leftPanel.add(lblRightArrow);
		leftPanel.add(lblDownArrow);
		leftPanel.add(lblLeftArrow);
		leftPanel.add(lblPause);
		leftPanel.add(lblRightLight);
		leftPanel.add(lblLeftLight);
		leftPanel.add(lblBothLight);
		leftPanel.add(lblHorn);
		lowerMainPanel = new JPanel(new GridLayout(1, 3));

		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setMaximumSize(centerPanel.getPreferredSize());
		speed = new JSlider(JSlider.HORIZONTAL, 0, 200, 25);
		speed.setMajorTickSpacing(25);
		speed.setMinorTickSpacing(5);
		speed.setPaintTicks(true);
		speed.setPaintLabels(true);
		speed.setAlignmentX(Component.CENTER_ALIGNMENT);
		speed.addChangeListener(new SpeedListener());

		duration = new JSlider(JSlider.HORIZONTAL, 0, 60, 10);
		duration.setMajorTickSpacing(10);
		duration.setMinorTickSpacing(5);
		duration.setPaintTicks(true);
		duration.setPaintLabels(true);
		duration.setAlignmentX(Component.CENTER_ALIGNMENT);
		duration.addChangeListener(new SpeedListener());

		lblSpeed = new JLabel("Speed");
		lblDuration = new JLabel("Duration");
		centerPanel.add(Box.createVerticalStrut(70));
		centerPanel.add(lblSpeed);
		centerPanel.add(Box.createVerticalStrut(20));
		centerPanel.add(speed);
		centerPanel.add(Box.createVerticalStrut(50));
		centerPanel.add(lblDuration);
		centerPanel.add(Box.createVerticalStrut(20));
		centerPanel.add(duration);
		centerPanel.add(Box.createVerticalStrut(50));
		rightPanel = new JPanel(new GridLayout(4, 3));


		btnConsoleLight1 = makeNavigationButton("cosole_light",
				"Left_Console_Light", "Toggle left console light",
				"Left Console Light");

		btnConsoleLight2 = makeNavigationButton("cosole_light",
				"Right_Console_Light", "Toggle Right console light",
				"Right Console Light");

		btnNavigateUp = makeNavigationButton("up_console", "navigate_up",
				"to navigate up", "Navigate Up");

		btnNavigateLeft = makeNavigationButton("right_console",
				"navigate_left", "to navigate left", "Navigate Left");

		btnNavigateRight = makeNavigationButton("left_console",
				"navigate_right", "to navigate right", "Navigate Right");
		btnNavigateDown = makeNavigationButton("down_console", "navigate_down",
				"to navigate down", "Navigate Down");
		btnBothConsole = makeNavigationButton("both_light_console",
				"Both console", "", "both Light Console");

		rightPanel.add(btnConsoleLight1);
		rightPanel.add(btnNavigateUp);
		rightPanel.add(btnConsoleLight2);
		rightPanel.add(btnNavigateLeft);
		rightPanel.add(btnBothConsole);
		rightPanel.add(btnNavigateRight);
		rightPanel.add(new JLabel());
		rightPanel.add(btnNavigateDown);
		rightPanel.add(new JLabel());
		rightPanel.setBackground(Color.lightGray);
		lowerMainPanel.add(leftPanel);
		lowerMainPanel.add(centerPanel);
		lowerMainPanel.add(rightPanel);
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		upperPanel = new JPanel(new FlowLayout());
		upperPanel.setPreferredSize(new Dimension(1000, 90));
		upperPanel.setBackground(Color.DARK_GRAY);
		mainPanel.add(upperPanel);
		mainPanel.add(headingPanel);
		mainPanel.add(lowerMainPanel);
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
	}

	protected JButton makeNavigationButton(String imageName,
		String actionCommand, String toolTipText, String altText) {
		// Look for the image.
		String imgLocation = "/Users/hongdavid/Desktop/images/" + imageName + ".png";

		
		// Create and initialize the button.
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(this);
		ImageIcon icon = new ImageIcon(imgLocation);
				
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		
		icon = new ImageIcon(newimg, altText);
		button.setIcon(icon);		
		return button;
	}

	public void actionPerformed(ActionEvent e) {
		//btnTerminate
		if(e.getSource()== btnTerminate){
			
			Buffer.storyboard_instructions = new LinkedList<String>();
			Buffer.storybaord_timeline = new LinkedList<JLabel>();
			Buffer.pause_the_storyboard = false;
			Buffer.start_the_storyboard = false;
			
			upperPanel.removeAll();
			upperPanel.revalidate();
			upperPanel.repaint();
		}

		
		else if(e.getSource()==btnConsoleLight1){		
			inst.push(Buffer.Instructions.LEFT_LIGHT_ON.getValue());		
						
		}else if (e.getSource()==btnConsoleLight2){
			inst.push(Buffer.Instructions.RIGHT_LIGHT_ON.getValue());		
			
			
		}else if (e.getSource()==btnBothConsole){
			inst.push(Buffer.Instructions.BOTH_LIGHTS_ON.getValue());		
		
			
		}else if (e.getSource()==btnNavigateUp){
			inst.push(Buffer.Instructions.FORWARD.getValue());		
			
			
		}else if (e.getSource()==btnNavigateDown){
			inst.push(Buffer.Instructions.BACKWARD.getValue());		
			
						
		}else if (e.getSource()==btnNavigateLeft){
			inst.push(Buffer.Instructions.TURN_LEFT.getValue());		

			
		}else if (e.getSource()==btnNavigateRight){
			inst.push(Buffer.Instructions.TURN_RIGHT.getValue());		

			
		}else if (e.getSource()==btnRun){
			System.out.println("RUN THE STORYBOARD");
			Buffer.start_the_storyboard = true;
			Buffer.pause_the_storyboard = false;
			
		}else if (e.getSource()==btnPause){
			System.out.println("STOP THE STORYBOARD");
			Buffer.pause_the_storyboard = true;
		}
		
	}
	
	
	private class SpeedListener implements ChangeListener {
		public void stateChanged(ChangeEvent event) {
			
			JSlider source = (JSlider) event.getSource();			
		      int max = source.getMaximum();
	          if (!source.getValueIsAdjusting()) {	        	  	
	        	  	if(max==200){
	        	  		Buffer.speed = (int)source.getValue();
	        	  	}else{
	        	  		Buffer.duration = (int)source.getValue() * 10;
	        	  	}	        	  	
	          }
		
		} 
	}

		
	private class PointListener implements MouseListener {
		public void mousePressed(MouseEvent event) {

		}

		
	public void mouseClicked(MouseEvent event) {
			if (event.getSource() == lblUpArrow) {
				copyLblUpArrow = createLabel(copyLblUpArrow, 
						"/Users/hongdavid/Desktop/images/top.png");
				upperPanel.add(copyLblUpArrow);				
				str_inst.offer(Buffer.Instructions.FORWARD.getValue());
				stry_time.add(copyLblUpArrow);
				
								
			} else if (event.getSource() == lblDownArrow) {
				copyLblDownArrow = createLabel(copyLblDownArrow,
						"/Users/hongdavid/Desktop/images/down.png");
				upperPanel.add(copyLblDownArrow);
				str_inst.offer(Buffer.Instructions.BACKWARD.getValue());
				stry_time.add(copyLblDownArrow);

				
			} else if (event.getSource() == lblRightArrow) {
				copyLblRightArrow = createLabel(copyLblRightArrow,
						"/Users/hongdavid/Desktop/images/left.png");
				upperPanel.add(copyLblRightArrow);
				str_inst.offer(Buffer.Instructions.TURN_RIGHT.getValue());
				stry_time.add(copyLblRightArrow);
				
			} else if (event.getSource() == lblLeftArrow) {
				copyLblLeftArrow = createLabel(copyLblLeftArrow,
						"/Users/hongdavid/Desktop/images/right.png");
				upperPanel.add(copyLblLeftArrow);
				str_inst.offer(Buffer.Instructions.TURN_LEFT.getValue());
				stry_time.add(copyLblLeftArrow);
				
			} else if (event.getSource() == lblLeftLight) {
				copyLblLeftLight = createLabel(copyLblLeftLight,
						"/Users/hongdavid/Desktop/images/left_light.png");
				upperPanel.add(copyLblLeftLight);
				str_inst.offer(Buffer.Instructions.LEFT_LIGHT_ON.getValue());
				stry_time.add(copyLblLeftLight);
				
			} else if (event.getSource() == lblRightLight) {
				copyLblRightLight = createLabel(copyLblRightLight,
						"/Users/hongdavid/Desktop/images/right_light.png");
				upperPanel.add(copyLblRightLight);
				str_inst.offer(Buffer.Instructions.RIGHT_LIGHT_ON.getValue());
				stry_time.add(copyLblRightLight);
				
			} else if (event.getSource() == lblBothLight) {
				copyLblBothLight = createLabel(copyLblBothLight,
						"/Users/hongdavid/Desktop/images/both_light.png");
				upperPanel.add(copyLblBothLight);
				str_inst.offer(Buffer.Instructions.BOTH_LIGHTS_ON.getValue());
				stry_time.add(copyLblBothLight);
				
			} else if (event.getSource() == lblPause) {
				copyLblPause = createLabel(copyLblPause, "/Users/hongdavid/Desktop/images/break.png");
				upperPanel.add(copyLblPause);
				str_inst.offer(Buffer.Instructions.BRAKE.getValue());				
				stry_time.add(copyLblPause);
					
			} else {
				copyLblHorn = createLabel(copyLblHorn, "/Users/hongdavid/Desktop/images/horn.png");
				upperPanel.add(copyLblHorn);
				str_inst.offer(Buffer.Instructions.HORN.getValue());
				stry_time.add(copyLblHorn);				
			}
			upperPanel.revalidate();
			upperPanel.repaint();
		}

		private JLabel createLabel(JLabel label, String path) {
			label = new JLabel();
			label.setBounds(20, 30, 100, 100);			
			label.setIcon(new ImageIcon(path));
			label.addMouseListener(new PointListener());
			return label;
		}

		public void mouseEntered(MouseEvent arg0) {

		}

		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mouseReleased(MouseEvent event) {

		}
	}

	public JButton addToolbarButton(String path, JButton button,
			String alternateText) {
		imageURL = UI_Frame.class.getResource(path);
		button = new JButton();
		if (imageURL != null) {
			ImageIcon imageIcon = new ImageIcon(imageURL);
			Image newImage = imageIcon.getImage().getScaledInstance(60, 25,
					Image.SCALE_SMOOTH);
			button.setIcon(new ImageIcon(newImage));
		} else
			button.setText(alternateText);
		return button;
	}

	@Override
	public void run() {
		while(true){
	        try {
				Thread.sleep(1000);

				if(Buffer.start_the_storyboard && !Buffer.pause_the_storyboard){
					 if(Buffer.storybaord_timeline.size() > Buffer.storyboard_instructions.size()){ 						      
						      upperPanel.remove( Buffer.storybaord_timeline.remove() );
						      upperPanel.revalidate();
						      upperPanel.repaint();
					 }
					 else if(Buffer.storybaord_timeline.size()==Buffer.storyboard_instructions.size()){
						 Buffer.start_the_storyboard = false;
					 }
				}
				
				
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}		
	}
	


}