package examenBankonter.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import examenBankonter.controller.UsuarioControlador;
import examenBankonter.model.Usuario;



public class PanelGestionUsuario extends JPanel {
	private JTextField jtfId;
	private JTextField jtfUsuario;
	private JPasswordField jtfPassword;
	private JTextField jtfEmail;
	private Usuario usuario;
	private JComboBox<String> jcbColor;
	
	/**
	 * Create the panel.
	 */
	public PanelGestionUsuario(Usuario usuario) {
		this.usuario = usuario;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(10, 0, 10, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfUsuario = new JTextField();
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 2;
		add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfPassword = new JPasswordField();
		GridBagConstraints gbc_jtfPassword = new GridBagConstraints();
		gbc_jtfPassword.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPassword.gridx = 1;
		gbc_jtfPassword.gridy = 3;
		add(jtfPassword, gbc_jtfPassword);
		
		JLabel lblNewLabel_4 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 4;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Color preferido:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jcbColor = new JComboBox();
		jcbColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcbColor.getSelectedItem() != null) {
					setBackground(Color.decode( (String) jcbColor.getSelectedItem()));
				}
			}
		});
		GridBagConstraints gbc_jcbColor = new GridBagConstraints();
		gbc_jcbColor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbColor.gridx = 1;
		gbc_jcbColor.gridy = 5;
		add(jcbColor, gbc_jcbColor);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 6;
		add(btnGuardar, gbc_btnGuardar);

		cargarValoresJComboColores();
		
		cargarDatosAPantalla();
	}
	
	/**
	 * 
	 */
	private void cargarValoresJComboColores() {
		this.jcbColor.addItem("#FF00FF");
		this.jcbColor.addItem("#9890A5");
		this.jcbColor.addItem("#765456");
		this.jcbColor.addItem("#879876");
	}
	
	
	/**
	 * 
	 */
	private void cargarDatosAPantalla() {
		this.jtfId.setText("" + this.usuario.getId());
		this.jtfUsuario.setText(this.usuario.getNombreUsuario());
		this.jtfPassword.setText(this.usuario.getPassword());
		this.jtfEmail.setText(this.usuario.getEmail());
		
		for (int i = 0; i < this.jcbColor.getItemCount(); i++) {
			if (this.usuario.getColorPreferido().equals(jcbColor.getItemAt(i))) {
				this.jcbColor.setSelectedIndex(i);
			}
		}
		
		this.setBackground(Color.decode(this.usuario.getColorPreferido()));
	}

	
	/**
	 * 
	 */
	private void cargarDatosDesdePantalla() {
		this.usuario.setNombreUsuario(this.jtfUsuario.getText());
		this.usuario.setPassword(this.jtfPassword.getText());
		this.usuario.setEmail(this.jtfEmail.getText());
		this.usuario.setColorPreferido((String) this.jcbColor.getSelectedItem());
	}
	
	
	/**
	 * 
	 */
	private void guardar() {
		try {
			cargarDatosDesdePantalla();
			
			if (this.usuario.getNombreUsuario().trim().equals("")) {
				throw new Exception ("El nombre de usuario no puede estar vacío");
			}
			
			if (this.usuario.getPassword().trim().equals("")) {
				throw new Exception ("Password no puede estar vacío");
			}
			
			if (!this.usuario.getEmail().matches(".+[@].+[.].+")) {
				throw new Exception ("El correo electrónico no es válido");
			}
			
			UsuarioControlador.modificar(this.usuario);
			JOptionPane.showMessageDialog(null, "Guardado correcto");
		}
		catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "No ha sido posible guardar el usuario: " + 
			ex.getMessage());
		}

	}
	
	
}
