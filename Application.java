import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Application {
	private JFrame frame;
	private final JTextField displayField = new JTextField();
	private final JButton button_1 = new JButton();
	private final JButton button_2 = new JButton();
	private final JButton button_3 = new JButton();
	private final JButton button_4 = new JButton();
	private final JButton button_5 = new JButton();
	private final JButton button_6 = new JButton();
	private final JButton button_7 = new JButton();
	private final JButton button_8 = new JButton();
	private final JButton button_9 = new JButton();
	private final JButton button_0 = new JButton();
	private final JButton button_star = new JButton();
	private final JLabel label_pass = new JLabel();

	public static void main(String args[]) {
		try {
			Application window = new Application();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Application() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 255, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(displayField);
		displayField.setText("");
		//displayField.setHorizontalAlignment(SwingConstants.RIGHT);
		displayField.setBounds(38, 15, 165, 22);
		
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(1);
			}
		});
		button_1.setText("1");
		button_1.setBounds(38, 71, 51, 28);
		
		frame.getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(2);
			}
		});
		button_2.setText("2");
		button_2.setBounds(95, 71, 51, 28);
		
		frame.getContentPane().add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(3);
			}
		});
		button_3.setText("3");
		button_3.setBounds(152, 71, 51, 28);
		
		frame.getContentPane().add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(4);
			}
		});
		button_4.setText("4");
		button_4.setBounds(38, 105, 51, 28);
		
		frame.getContentPane().add(button_5);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(5);
			}
		});
		button_5.setText("5");
		button_5.setBounds(95, 105, 51, 28);
		
		frame.getContentPane().add(button_6);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(6);
			}
		});
		button_6.setText("6");
		button_6.setBounds(152, 105, 51, 28);
		
		frame.getContentPane().add(button_7);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(7);
			}
		});
		button_7.setText("7");
		button_7.setBounds(38, 139, 51, 28);
		
		frame.getContentPane().add(button_8);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(8);
			}
		});
		button_8.setText("8");
		button_8.setBounds(95, 139, 51, 28);
		
		frame.getContentPane().add(button_9);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(9);
			}
		});
		button_9.setText("9");
		button_9.setBounds(152, 139, 51, 28);
		
		frame.getContentPane().add(button_0);
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(0);
			}
		});
		button_0.setText("0");
		button_0.setBounds(38, 173, 51, 28);
		
		frame.getContentPane().add(button_star);
		button_star.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Star();
			}
		});
		button_star.setText("*");
		button_star.setBounds(95, 173, 51, 28);
		
		frame.getContentPane().add(label_pass);
		label_pass.setText("key: 1234");
		label_pass.setBounds(38, 38, 150, 28);
		
		// Start from the initial state
		changeState(STATE.Initial);
	}

	// Definition of states 
	enum STATE { Initial, Waiting, Processing, Passed, Failed, Final };
	
	// Data fields
	STATE state;
	int n;
	int [] key = new int[] { 1, 2, 3, 4 };
	
	// Event method
	void Num(int num) {
		if (state == STATE.Waiting) {
			if (num == key[n]) {
				n++;
				changeState(STATE.Processing);
			}
			else {
				changeState(STATE.Failed);
			}
		}
		else if (state == STATE.Processing) {
			if (num == key[n]) {
				n++;
				changeState(STATE.Processing);
			}
			else {
				changeState(STATE.Failed);
			}
		}
		else if (state == STATE.Passed) {
			changeState(STATE.Failed);
		}
		else if (state == STATE.Failed) {
		}		
	}
	
	// Event method
	void Star() {
		if (state == STATE.Waiting) {
			Fail();
			changeState(STATE.Final);
		}
		else if (state == STATE.Processing) {
			Fail();
			changeState(STATE.Final);
		}
		else if (state == STATE.Passed) {
			Unlock();
			changeState(STATE.Final);
		}
		else if (state == STATE.Failed) {
			Fail();
			changeState(STATE.Final);
		}
	}

	// State transition method
	void changeState(STATE s) {
		state = s;
		
		if (state == STATE.Initial) {
			n = 0;
			changeState(STATE.Waiting);
		}
		else if (state == STATE.Waiting) {
		}
		else if (state == STATE.Processing) {
			if (n == key.length) {
				changeState(STATE.Passed);
			}
		}
		else if (state == STATE.Passed) {
		}
		else if (state == STATE.Failed) {
		}	
	}
	
	// Effect method
	void Unlock() {
		display("Unlock");
	}
	
	void Fail() {
		display("Fail");
	}
	
	// Utility method
	void display(String str) {
		displayField.setText(str);
	}
}

