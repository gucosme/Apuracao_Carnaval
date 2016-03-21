package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;

public class VerQuesitos {
	private JFrame frame;
	private JTable table;
	
	public VerQuesitos(){
		frame = new JFrame("Quesitos");
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNotasPorQuesito = new JLabel("APURAÇÃO PARCIAL");
		lblNotasPorQuesito.setForeground(Color.GRAY);
		lblNotasPorQuesito.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNotasPorQuesito.setBounds(10, 11, 564, 27);
		frame.getContentPane().add(lblNotasPorQuesito);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBounds(10, 36, 564, 2);
		frame.getContentPane().add(separator);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBounds(10, 49, 564, 301);
		frame.getContentPane().add(table);
	}
	public static void main(String[] args) {
		new VerQuesitos();
	}
}
