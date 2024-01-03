package cop2805;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		MyFrame frame = new MyFrame();
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}
		});
	}
}

class MyFrame extends JFrame {
	public JTextField num1;
	public JTextField num2;
	public JButton calcNum;
	public JLabel resultField;
	double result;

	public MyFrame() {
		super();
		init();
	}

	JComboBox myList;

	public void init() {
		num1 = new JTextField();
		num2 = new JTextField();

		calcNum = new JButton("Calculate");
		calcNum.addActionListener((new MyButtonListener(this)));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculator");
		this.setLayout(new GridLayout(5, 2));

		this.add(new JLabel("First Number:"));
		this.add(num1);

		this.add(new JLabel("Second Number:"));
		this.add(num2);

		this.add(new JLabel(""));
		// this.add(calcNum);

		this.add(new JLabel(""));

		String[] selections = { "Sum", "Subtraction", "Division", "Multiplication" };
		this.myList = new JComboBox(selections);
		this.add(myList);

	    resultField = new JLabel("Result: ");

		this.getContentPane().add(calcNum);
		this.add(resultField);

		int frameWidth = 300;
		int frameHeight = 300;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((int) (screenSize.getWidth() / 2) - frameWidth, (int) (screenSize.getHeight() / 2) - frameHeight,
				frameWidth, frameHeight);
		this.setVisible(true);
	}

	class MyButtonListener implements ActionListener {
		MyFrame fr;

		public MyButtonListener(MyFrame frame) {
			fr = frame;
		}

		public void actionPerformed(ActionEvent e) {

			JButton source = (JButton) e.getSource();
			if (num1.getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter numbers");
			} else {
				try {
					double first = Double.parseDouble(fr.num1.getText());
					double second = Double.parseDouble(fr.num2.getText());
					
					if (fr.myList.getSelectedItem().equals("Sum")) {
						fr.resultField.setText("Result: " + (first + second));
					} else if (fr.myList.getSelectedItem().equals("Subtraction")) {
						fr.resultField.setText("Result: " + (first - second));
					} else if (fr.myList.getSelectedItem().equals("Multiplication")) {
						fr.resultField.setText("Result: " + (first * second));
					} else if (fr.myList.getSelectedItem().equals("Division")) {
						fr.resultField.setText("Result: " + (first / second));
					}

				} catch (NumberFormatException x) {

					// if not in number format

					JOptionPane.showMessageDialog(null, "Please enter numbers only");

				}
			}
		}
	}

}

