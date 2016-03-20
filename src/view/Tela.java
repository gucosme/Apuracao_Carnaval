package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela {
	
	private JFrame frame;
	
	private JButton btnInserir;
	private JButton btnInserir_1;
	private JButton btnVerQuesito;
	private JButton btnVerQuesito_1;
	private JButton btnVerTotal;
	private JButton btnVerTotal_1;
	private JTextField textField;
	
	public Tela(){
		btnInserir = new JButton("Inserir");
		btnVerQuesito = new JButton("Ver quesito");
		btnVerTotal = new JButton("Ver total");

		frame = new JFrame("Apuração");
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEscola = new JLabel("Escola");
		lblEscola.setBounds(54, 43, 46, 14);
		frame.getContentPane().add(lblEscola);
		
		JLabel lblJurado = new JLabel("Jurado");
		lblJurado.setBounds(54, 80, 46, 14);
		frame.getContentPane().add(lblJurado);
		
		JLabel lblQuesito = new JLabel("Quesito");
		lblQuesito.setBounds(54, 121, 46, 14);
		frame.getContentPane().add(lblQuesito);
		
		JComboBox<?> comboBox = new JComboBox();
		comboBox.setBounds(110, 40, 342, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox<?> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setBounds(110, 77, 342, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox<?> comboBox_2 = new JComboBox<Object>();
		comboBox_2.setBounds(110, 118, 280, 20);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblNota_1 = new JLabel("Nota");
		lblNota_1.setBounds(54, 202, 46, 14);
		frame.getContentPane().add(lblNota_1);
		
		textField = new JTextField();
		textField.setBounds(110, 199, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnInserir_1 = new JButton("Inserir");
		btnInserir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInserir_1.setBounds(207, 198, 110, 23);
		frame.getContentPane().add(btnInserir_1);
		
		btnVerQuesito_1 = new JButton("Ver Quesito");
		btnVerQuesito_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerQuesito_1.setBounds(207, 265, 110, 23);
		frame.getContentPane().add(btnVerQuesito_1);
		
		btnVerTotal_1 = new JButton("Ver total");
		btnVerTotal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerTotal_1.setBounds(342, 265, 110, 23);
		frame.getContentPane().add(btnVerTotal_1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Tela();
	}
}
