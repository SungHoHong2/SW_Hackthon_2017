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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UI_Frame implements ActionListener {

	private JFrame frame;
	private JPanel centerPanel, leftPanel, rightPanel, lowerMainPanel,
			upperPanel, mainPanel, headingPanel;
	private JButton btnConsoleLight1, btnConsoleLight2, btnBothConsole,
			btnNavigateUp, btnNavigateDown, btnNavigateLeft, btnNavigateRight,
			btnRun, btnTerminate, btnPause;
	private JSlider speed, duration;
	private JLabel lblSpeed, lblDuration, lblShowSpeed, lblShowEnergy,
			lblUpArrow, lblDownArrow, lblRightArrow, lblLeftArrow, lblPause,
			lblRightLight, lblLeftLight, lblBothLight, lblHorn, copyLblUpArrow,
			copyLblDownArrow, copyLblRightArrow, copyLblLeftArrow,
			copyLblPause, copyLblRightLight, copyLblLeftLight,
			copyLblBothLight, copyLblHorn, lblAction, lblTitle, lblControl;
	private JComboBox comboBox;
	private String[] comboBoxTypes = { "Sequence", "Simultaneous" };
	private BufferedImage upArrow;
	private JToolBar toolBar;
	private URL imageURL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Frame window = new UI_Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.setSize(1000, 600);

		toolBar = new JToolBar();
		toolBar.setRollover(true);

		btnRun = addToolbarButton("images/run_top.png", btnRun, "Run");
		toolBar.add(btnRun);
		toolBar.addSeparator();

		btnPause = addToolbarButton("images/pause_menu.png", btnPause, "Pause");
		toolBar.add(btnPause);
		toolBar.addSeparator();

		btnTerminate = addToolbarButton("images/stop_menu.png", btnTerminate,"Stop");
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
		imageURL = UI_Frame.class.getResource("images/top.png");
		lblUpArrow.setIcon(new ImageIcon(imageURL));
		lblUpArrow.addMouseListener(new PointListener());

		lblRightArrow = new JLabel();
		lblRightArrow.setBounds(20, 30, 50, 50);
		imageURL = UI_Frame.class.getResource("images/left.png");
		lblRightArrow.setIcon(new ImageIcon(imageURL));
		lblRightArrow.addMouseListener(new PointListener());

		lblDownArrow = new JLabel();
		lblDownArrow.setBounds(20, 30, 50, 50);
		imageURL = UI_Frame.class.getResource("images/down.png");
		lblDownArrow.setIcon(new ImageIcon(imageURL));
		lblDownArrow.addMouseListener(new PointListener());

		lblLeftArrow = new JLabel();
		lblLeftArrow.setBounds(20, 30, 50, 50);
		imageURL = UI_Frame.class.getResource("images/right.png");
		lblLeftArrow.setIcon(new ImageIcon(imageURL));
		lblLeftArrow.addMouseListener(new PointListener());

		lblPause = new JLabel();
		lblPause.setBounds(20, 30, 50, 50);
		imageURL = UI_Frame.class.getResource("images/break.png");
		lblPause.setIcon(new ImageIcon(imageURL));
		lblPause.addMouseListener(new PointListener());

		lblRightLight = new JLabel();
		lblRightLight.setBounds(20, 30, 50, 50);
		imageURL = UI_Frame.class.getResource("images/right_light.png");
		lblRightLight.setIcon(new ImageIcon(imageURL));
		lblRightLight.addMouseListener(new PointListener());

		lblLeftLight = new JLabel();
		lblLeftLight.setBounds(20, 30, 50, 50);
		imageURL = UI_Frame.class.getResource("images/left_light.png");
		lblLeftLight.setIcon(new ImageIcon(imageURL));
		lblLeftLight.addMouseListener(new PointListener());

		lblBothLight = new JLabel();
		lblBothLight.setBounds(20, 30, 50, 50);
		imageURL = UI_Frame.class.getResource("images/both_light.png");
		lblBothLight.setIcon(new ImageIcon(imageURL));
		lblBothLight.addMouseListener(new PointListener());

		lblHorn = new JLabel();
		lblHorn.setBounds(20, 30, 50, 50);
		imageURL = UI_Frame.class.getResource("images/horn.png");
		lblHorn.setIcon(new ImageIcon(imageURL));
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
		comboBox = new JComboBox(comboBoxTypes);
		comboBox.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		comboBox.addActionListener(new SequenceListener());
		comboBox.setMaximumSize(comboBox.getPreferredSize());
		centerPanel.add(Box.createVerticalStrut(50));
		centerPanel.add(comboBox);
		rightPanel = new JPanel(new GridLayout(4, 3));

		// first button

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
		lblShowSpeed = new JLabel("Speed: 00");
		lblShowEnergy = new JLabel("Energy: 00");
		rightPanel.add(lblShowSpeed);
		rightPanel.add(lblShowEnergy);
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
		String imgLocation = "images/" + imageName + ".png";
		URL imageURL = UI_Frame.class.getResource(imgLocation);

		// Create and initialize the button.
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(this);
		ImageIcon icon = new ImageIcon(imageURL, altText);
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg, altText);
		if (imageURL != null) { // image found
			button.setIcon(icon);
		} else { // no image found
			button.setText(altText);
			System.err.println("Resource not found: " + imgLocation);
		}

		return button;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnTerminate){
			frame.dispose();

		}
		else{
			//write logic
		}
		

	}

	private class SpeedListener implements ChangeListener {
		public void stateChanged(ChangeEvent event) {
			lblShowSpeed.setText("Speed: " + speed.getValue());

		} // end of SpeedListener
	}

	private class SequenceListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// needs to be filled
			// select color on basis of chosen index
			if (comboBox.getSelectedIndex() == 0) {
				// perform action for Sequence
			} else if (comboBox.getSelectedIndex() == 1) {
				// perform action for simultaneous

			}
		}
	}

	private class PointListener implements MouseListener {
		public void mousePressed(MouseEvent event) {

		}

		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == lblUpArrow) {
				copyLblUpArrow = createLabel(copyLblUpArrow, "images/top.png");
				upperPanel.add(copyLblUpArrow);
			} else if (event.getSource() == lblDownArrow) {
				copyLblDownArrow = createLabel(copyLblDownArrow,
						"images/down.png");
				upperPanel.add(copyLblDownArrow);
			} else if (event.getSource() == lblRightArrow) {
				copyLblRightArrow = createLabel(copyLblRightArrow,
						"images/left.png");
				upperPanel.add(copyLblRightArrow);
			} else if (event.getSource() == lblLeftArrow) {
				copyLblLeftArrow = createLabel(copyLblLeftArrow,
						"images/right.png");
				upperPanel.add(copyLblLeftArrow);
			} else if (event.getSource() == lblLeftLight) {
				copyLblLeftLight = createLabel(copyLblLeftLight,
						"images/left_light.png");
				upperPanel.add(copyLblLeftLight);
			} else if (event.getSource() == lblRightLight) {
				copyLblRightLight = createLabel(copyLblRightLight,
						"images/right_light.png");
				upperPanel.add(copyLblRightLight);
			} else if (event.getSource() == lblBothLight) {
				copyLblBothLight = createLabel(copyLblBothLight,
						"images/both_light.png");
				upperPanel.add(copyLblBothLight);
			} else if (event.getSource() == lblPause) {
				copyLblPause = createLabel(copyLblPause, "images/break.png");
				upperPanel.add(copyLblPause);

			} else {
				copyLblHorn = createLabel(copyLblHorn, "images/horn.png");
				upperPanel.add(copyLblHorn);
			}
			upperPanel.revalidate();
			upperPanel.repaint();
		}

		private JLabel createLabel(JLabel label, String path) {
			label = new JLabel();
			label.setBounds(20, 30, 100, 100);
			URL imageURL = UI_Frame.class.getResource(path);
			label.setIcon(new ImageIcon(imageURL));
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
	


}
