package examenBankonter.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import examenBankonter.controller.ContratoControlador;
import examenBankonter.controller.TipoContratoControlador;
import examenBankonter.controller.UsuarioControlador;
import examenBankonter.model.Contrato;
import examenBankonter.model.TipoContrato;
import examenBankonter.model.Usuario;



public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	private JTextField jtfSaldo;
	private JTextField jtfLimite;
	private JTextField jtfFechaFirma;
	private JRadioButton radio1Cuenta;
	private JRadioButton radio3TarjetaCredito;
	private JRadioButton radio2TarjetaDebito;
	private JRadioButton radio4Prestamo;
	private JComboBox<Usuario> jcbUsuario;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarContratoEnPantalla(ContratoControlador.findFirst());
			}
		});
		btnPrimero.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/examenes/examen20230518_Bankonter/view/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarContratoEnPantalla(ContratoControlador.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		btnAnterior.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/examenes/examen20230518_Bankonter/view/res/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarContratoEnPantalla(ContratoControlador.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		btnSiguiente.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/examenes/examen20230518_Bankonter/view/res/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarContratoEnPantalla(ContratoControlador.findLast());
			}
		});
		btnUltimo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/examenes/examen20230518_Bankonter/view/res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btnNuevo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/examenes/examen20230518_Bankonter/view/res/nuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/examenes/examen20230518_Bankonter/view/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/examenes/examen20230518_Bankonter/view/res/eliminar.png")));
		toolBar.add(btnEliminar);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Gestión de contratos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(10, 0, 10, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Tipo de contrato:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 2;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		radio1Cuenta = new JRadioButton("Cuenta bancaria");
		GridBagConstraints gbc_radio1Cuenta = new GridBagConstraints();
		gbc_radio1Cuenta.anchor = GridBagConstraints.WEST;
		gbc_radio1Cuenta.insets = new Insets(0, 0, 5, 5);
		gbc_radio1Cuenta.gridx = 0;
		gbc_radio1Cuenta.gridy = 0;
		panel_1.add(radio1Cuenta, gbc_radio1Cuenta);
		ButtonGroup buttonGroupTipoContrato = new ButtonGroup();
		buttonGroupTipoContrato.add(radio1Cuenta);
		
		radio3TarjetaCredito = new JRadioButton("Tarjeta crédito");
		GridBagConstraints gbc_radio3TarjetaCredito = new GridBagConstraints();
		gbc_radio3TarjetaCredito.anchor = GridBagConstraints.WEST;
		gbc_radio3TarjetaCredito.insets = new Insets(0, 0, 5, 0);
		gbc_radio3TarjetaCredito.gridx = 1;
		gbc_radio3TarjetaCredito.gridy = 0;
		panel_1.add(radio3TarjetaCredito, gbc_radio3TarjetaCredito);
		buttonGroupTipoContrato.add(radio3TarjetaCredito);
		
		radio2TarjetaDebito = new JRadioButton("Tarjeta débito");
		GridBagConstraints gbc_radio2TarjetaDebito = new GridBagConstraints();
		gbc_radio2TarjetaDebito.anchor = GridBagConstraints.WEST;
		gbc_radio2TarjetaDebito.insets = new Insets(0, 0, 0, 5);
		gbc_radio2TarjetaDebito.gridx = 0;
		gbc_radio2TarjetaDebito.gridy = 1;
		panel_1.add(radio2TarjetaDebito, gbc_radio2TarjetaDebito);
		buttonGroupTipoContrato.add(radio2TarjetaDebito);
		
		radio4Prestamo = new JRadioButton("Préstamo");
		GridBagConstraints gbc_radio4Prestamo = new GridBagConstraints();
		gbc_radio4Prestamo.anchor = GridBagConstraints.WEST;
		gbc_radio4Prestamo.gridx = 1;
		gbc_radio4Prestamo.gridy = 1;
		panel_1.add(radio4Prestamo, gbc_radio4Prestamo);
		buttonGroupTipoContrato.add(radio4Prestamo);
		
		JLabel lblNewLabel_2 = new JLabel("Descripción:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 3;
		panel.add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Usuario:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 4;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jcbUsuario = new JComboBox();
		GridBagConstraints gbc_jcbUsuario = new GridBagConstraints();
		gbc_jcbUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUsuario.gridx = 1;
		gbc_jcbUsuario.gridy = 4;
		panel.add(jcbUsuario, gbc_jcbUsuario);
		
		JButton btnUsuario = new JButton("Gestionar usuario");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirDialogo();
			}
		});
		GridBagConstraints gbc_btnUsuario = new GridBagConstraints();
		gbc_btnUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_btnUsuario.gridx = 2;
		gbc_btnUsuario.gridy = 4;
		panel.add(btnUsuario, gbc_btnUsuario);
		
		JLabel lblNewLabel_3 = new JLabel("Saldo (€):");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfSaldo = new JTextField();
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 2;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 1;
		gbc_jtfSaldo.gridy = 5;
		panel.add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Límite (€):");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfLimite = new JTextField();
		GridBagConstraints gbc_jtfLimite = new GridBagConstraints();
		gbc_jtfLimite.gridwidth = 2;
		gbc_jtfLimite.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLimite.gridx = 1;
		gbc_jtfLimite.gridy = 6;
		panel.add(jtfLimite, gbc_jtfLimite);
		jtfLimite.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de firma:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfFechaFirma = new JTextField();
		GridBagConstraints gbc_jtfFechaFirma = new GridBagConstraints();
		gbc_jtfFechaFirma.gridwidth = 2;
		gbc_jtfFechaFirma.anchor = GridBagConstraints.NORTH;
		gbc_jtfFechaFirma.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaFirma.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaFirma.gridx = 1;
		gbc_jtfFechaFirma.gridy = 7;
		panel.add(jtfFechaFirma, gbc_jtfFechaFirma);
		jtfFechaFirma.setColumns(10);
		
		
		cargarUsuariosEnJCombo();
		
		cargarContratoEnPantalla(ContratoControlador.findFirst());
	}
	
	/**
	 * 
	 * @param c
	 */
	private void cargarContratoEnPantalla(Contrato c) {
		if (c != null) {
			this.jtfId.setText("" + c.getId());
			this.jtfDescripcion.setText(c.getDescripcion());
			
			// Cargo el tipo de contrato
			if (c.getTipocontrato().getId() == 1) this.radio1Cuenta.setSelected(true);
			else if (c.getTipocontrato().getId() == 2) this.radio2TarjetaDebito.setSelected(true);
			else if (c.getTipocontrato().getId() == 3) this.radio3TarjetaCredito.setSelected(true);
			else if (c.getTipocontrato().getId() == 4) this.radio4Prestamo.setSelected(true);
			
			this.jtfLimite.setText("" + c.getLimite());
			this.jtfSaldo.setText("" + c.getSaldo());
			
			// Selecciono el usuario correcto
			for (int i = 0; i < this.jcbUsuario.getItemCount(); i++) {
				if (this.jcbUsuario.getItemAt(i).getId() == c.getUsuario().getId()) {
					this.jcbUsuario.setSelectedIndex(i);
				}
			}
			
			if (c.getFechaFirma() != null) {
				this.jtfFechaFirma.setText(sdf.format(c.getFechaFirma()));
			}
			else {
				this.jtfFechaFirma.setText("");
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	private Contrato cargarContratoDesdePantalla() throws Exception {
		Contrato c = new Contrato();
		
		c.setId( Integer.parseInt(this.jtfId.getText()));
		
		if (this.jtfDescripcion.getText().length() < 4) {
			throw new Exception ("La descripción debe tener una longitud mínima de 4 caracteres");
		}

		if (!this.jtfDescripcion.getText().matches(".{4,}")) {
			throw new Exception ("La descripción debe tener una longitud mínima de 4 caracteres");
		}
		
		c.setDescripcion(this.jtfDescripcion.getText());
		
		int idTipoContrato = 0;
		if (this.radio1Cuenta.isSelected()) idTipoContrato = 1; 
		else if (this.radio2TarjetaDebito.isSelected()) idTipoContrato = 2;
		else if (this.radio3TarjetaCredito.isSelected()) idTipoContrato = 3;
		else if (this.radio4Prestamo.isSelected()) idTipoContrato = 4;
		
		TipoContrato t = TipoContratoControlador.findById(idTipoContrato);
//		TipoContrato t = new TipoContrato();
//		t.setId(idTipoContrato);
		c.setTipocontrato(t);
		
		if (this.jcbUsuario.getSelectedItem() != null) {
			c.setUsuario((Usuario) this.jcbUsuario.getSelectedItem());
		}
		
		try {
			c.setSaldo(Float.parseFloat(this.jtfSaldo.getText()));
			c.setLimite(Float.parseFloat(this.jtfLimite.getText()));
		}
		catch (Exception ex) {
			throw new Exception("El saldo y el límite deben ser números");
		}
		
		try {
			c.setFechaFirma(sdf.parse(this.jtfFechaFirma.getText()));
		}
		catch (Exception ex) {
			throw new Exception("La fecha debe tener el formato dd/mm/aaaa");
		}
		
		return c;
	}
	
	/**
	 * 
	 */
	private void cargarUsuariosEnJCombo() {
		List<Usuario> usuarios = UsuarioControlador.findAll();
		for (Usuario usuario : usuarios) {
			this.jcbUsuario.addItem(usuario);
		}
	}
	
	/**
	 * 
	 */
	private void nuevo() {
		this.jtfId.setText("0");
		this.jtfDescripcion.setText("");
		this.jtfLimite.setText("0");
		this.jtfSaldo.setText("0");
		this.jtfFechaFirma.setText("");
		this.radio1Cuenta.setSelected(true);
		this.jcbUsuario.setSelectedIndex(0);
	}

	/**
	 * 
	 */
	private void guardar() {
		try {
			Contrato c = cargarContratoDesdePantalla();
			ContratoControlador.guardar(c);
			jtfId.setText("" + c.getId());
			JOptionPane.showMessageDialog(null, "Guardado correcto");
		}
		catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "No ha sido posible guardar el contrato: " + 
			ex.getMessage());
		}

	}
	
	
	/**
	 * 
	 */
	private void eliminar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", "Eliminación", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	try {
	    		Contrato pActual = cargarContratoDesdePantalla();
	    	  	ContratoControlador.eliminar(pActual);
	    	  
	    	  	JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    	  
				// Cargo otro registro en pantalla
				Contrato pAnterior = ContratoControlador.findPrevious(pActual.getId());
				if (pAnterior != null) {
					cargarContratoEnPantalla(pAnterior);
				}
				else {
					Contrato pSiguiente = ContratoControlador.findNext(pActual.getId());
					if (pSiguiente != null) {
						cargarContratoEnPantalla(pSiguiente);
					}
					else { // No quedan registros, has eliminado el único
						nuevo();
					}
				}
    		} catch (Exception e) {
    			JOptionPane.showMessageDialog(null, "Error al eliminar");
    		}          
	    }

	}

	/**
	 * 
	 */
	private void abrirDialogo() {
		JDialog dialogo = new JDialog();
		// El usuario no puede redimensionar el di�logo
		dialogo.setResizable(true);
		// t�tulo del d�alogo
		dialogo.setTitle("Gestión de usuarios");
		// Introducimos el panel creado sobre el di�logo
		dialogo.setContentPane(new PanelGestionUsuario((Usuario) this.jcbUsuario.getSelectedItem()));
		// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
	}
}

