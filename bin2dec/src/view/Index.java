package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;

import control.Calculadora;

import javax.swing.event.CaretEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class Index extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumBinario;
	private JTextField txtNumDecimalResposta;
	private JTextField txtNumDecimal;
	private JTextField txtNumBinarioResposta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Index() {
		setTitle("Calculadora Bin\u00E1ria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(224, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTextPane txtPIntro = new JTextPane();
		txtPIntro.setMargin(new Insets(0, 0, 0, 0));
		txtPIntro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPIntro.setBackground(new Color(224, 255, 255));
		txtPIntro.setBorder(null);
		txtPIntro.setEditable(false);
		txtPIntro.setText(
				"A calculadora para convers\u00E3o binaria converte facilmente n\u00FAmeros decimais em bin\u00E1rios e vice-versa");
		txtPIntro.setBounds(57, 11, 350, 34);
		panel.add(txtPIntro);

		JPanel pnlBin2Dec = new JPanel();
		pnlBin2Dec.setBorder(new TitledBorder(null, "Bin\u00E1rio para Decimal", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		pnlBin2Dec.setBounds(52, 68, 370, 125);
		panel.add(pnlBin2Dec);
		pnlBin2Dec.setLayout(null);

		JLabel lblNumBinario = new JLabel("N\u00FAmero Bin\u00E1rio:");
		lblNumBinario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumBinario.setBounds(10, 25, 101, 14);
		pnlBin2Dec.add(lblNumBinario);

		JLabel lblNumDecimal = new JLabel("N\u00FAmero Decimal:");
		lblNumDecimal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumDecimal.setBounds(10, 64, 101, 14);
		pnlBin2Dec.add(lblNumDecimal);

		txtNumBinario = new JTextField();
		txtNumBinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculadora c = new Calculadora();
				if (txtNumBinario.getText().isEmpty()) {
					txtNumBinario.setText("0");
					txtNumDecimalResposta.setText(c.getResposta() + "");
				} else if (c.converterBin2Dec(txtNumBinario.getText())) {

					txtNumDecimalResposta.setText(c.getResposta() + "");
				} else {
					JOptionPane.showMessageDialog(null, "Número Binário Inválido!", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		txtNumBinario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					if (Integer.parseInt(txtNumBinario.getText()) == 0) {
						txtNumBinario.setText("");
					}
				} catch (Exception e) {
					txtNumBinario.setText("");
				}

			}
		});
		lblNumBinario.setLabelFor(txtNumBinario);
		txtNumBinario.setText("0");
		txtNumBinario.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				String bin = txtNumBinario.getText();
				if (bin.isEmpty()) {
				} else if (bin.charAt(bin.length() - 1) != '1' && bin.charAt(bin.length() - 1) != '0') {
					JOptionPane.showMessageDialog(null, "Caractere invalido. Insira somente 0 ou 1", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		txtNumBinario.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumBinario.setBounds(121, 22, 156, 20);
		pnlBin2Dec.add(txtNumBinario);
		txtNumBinario.setColumns(10);

		txtNumDecimalResposta = new JTextField();
		lblNumDecimal.setLabelFor(txtNumDecimalResposta);
		txtNumDecimalResposta.setText("0");
		txtNumDecimalResposta.setEditable(false);
		txtNumDecimalResposta.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumDecimalResposta.setColumns(10);
		txtNumDecimalResposta.setBounds(121, 61, 156, 20);
		pnlBin2Dec.add(txtNumDecimalResposta);

		JButton btnConverter = new JButton("Converter");
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calculadora c = new Calculadora();
				if (txtNumBinario.getText().isEmpty()) {
					txtNumBinario.setText("0");
					txtNumDecimalResposta.setText(c.getResposta() + "");
				} else if (c.converterBin2Dec(txtNumBinario.getText())) {

					txtNumDecimalResposta.setText(c.getResposta() + "");
				} else {
					JOptionPane.showMessageDialog(null, "Número Binário Inválido!", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnConverter.setMargin(new Insets(2, 6, 2, 6));
		btnConverter.setBounds(60, 91, 89, 23);
		pnlBin2Dec.add(btnConverter);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNumBinario.setText("0");
				txtNumDecimalResposta.setText("0");
			}
		});
		btnLimpar.setMargin(new Insets(2, 6, 2, 6));
		btnLimpar.setBounds(210, 92, 89, 23);
		pnlBin2Dec.add(btnLimpar);

		JPanel pnlDec2Bin = new JPanel();
		pnlDec2Bin.setLayout(null);
		pnlDec2Bin.setBorder(
				new TitledBorder(null, "Binário para Decimal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDec2Bin.setBounds(52, 201, 370, 125);
		panel.add(pnlDec2Bin);

		JLabel lblNumDecimal2 = new JLabel("Número Decimal:");
		lblNumDecimal2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumDecimal2.setBounds(10, 25, 101, 14);
		pnlDec2Bin.add(lblNumDecimal2);

		JLabel lblNumBinario2 = new JLabel("Número Bin\u00E1rio:");
		lblNumBinario2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumBinario2.setBounds(10, 64, 101, 14);
		pnlDec2Bin.add(lblNumBinario2);

		txtNumDecimal = new JTextField();
		txtNumDecimal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					if (Integer.parseInt(txtNumBinario.getText()) == 0) {
						txtNumDecimal.setText("");
					}
				} catch (Exception e1) {
					txtNumDecimal.setText("");
				}
			}
		});
		txtNumDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculadora c = new Calculadora();
				if (txtNumBinario.getText().isEmpty()) {
					txtNumBinario.setText("0");
					txtNumDecimalResposta.setText(c.getResposta() + "");
				} else if (c.converterDec2Bin(txtNumDecimal.getText())) {

					txtNumBinarioResposta.setText(c.getRespostaBin() + "");
				} else {
					JOptionPane.showMessageDialog(null, "Número Decimal Inválido!", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		lblNumDecimal2.setLabelFor(txtNumDecimal);
		txtNumDecimal.setText("0");
		txtNumDecimal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumDecimal.setColumns(10);
		txtNumDecimal.setBounds(121, 22, 156, 20);
		pnlDec2Bin.add(txtNumDecimal);

		txtNumBinarioResposta = new JTextField();
		lblNumBinario2.setLabelFor(txtNumBinarioResposta);
		txtNumBinarioResposta.setText("0");
		txtNumBinarioResposta.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumBinarioResposta.setEditable(false);
		txtNumBinarioResposta.setColumns(10);
		txtNumBinarioResposta.setBounds(121, 61, 156, 20);
		pnlDec2Bin.add(txtNumBinarioResposta);

		JButton btnConverter_1 = new JButton("Converter");
		btnConverter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculadora c = new Calculadora();
				if (txtNumBinario.getText().isEmpty()) {
					txtNumBinario.setText("0");
					txtNumDecimalResposta.setText(c.getResposta() + "");
				} else if (c.converterDec2Bin(txtNumDecimal.getText())) {

					txtNumBinarioResposta.setText(c.getRespostaBin() + "");
				} else {
					JOptionPane.showMessageDialog(null, "Número Decimal Inválido!", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnConverter_1.setMargin(new Insets(2, 6, 2, 6));
		btnConverter_1.setBounds(60, 91, 89, 23);
		pnlDec2Bin.add(btnConverter_1);

		JButton btnLimpar_1 = new JButton("Limpar");
		btnLimpar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNumDecimal.setText("0");
				txtNumBinarioResposta.setText("0");
			}
		});
		btnLimpar_1.setMargin(new Insets(2, 6, 2, 6));
		btnLimpar_1.setBounds(210, 92, 89, 23);
		pnlDec2Bin.add(btnLimpar_1);
	}
}
