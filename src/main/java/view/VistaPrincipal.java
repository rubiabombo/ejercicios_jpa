package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorMunicipio;
import controller.ControladorProvincia;
import model.Municipio;
import model.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField jtfBusqueda;
	private JTextField jtfMunicipio;
	private JComboBox<Municipio> jcbMunicipio;
	private List<Municipio> municipios;
	private JComboBox<Provincia> jcbProvincia;
	private List<Provincia> provincias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
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
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		jtfBusqueda = new JTextField();
		GridBagConstraints gbc_jtfBusqueda = new GridBagConstraints();
		gbc_jtfBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_jtfBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBusqueda.gridx = 0;
		gbc_jtfBusqueda.gridy = 0;
		contentPane.add(jtfBusqueda, gbc_jtfBusqueda);
		jtfBusqueda.setColumns(10);

		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jcbMunicipio.removeAllItems();
				String municipio = jtfBusqueda.getText();

				municipio = municipio.toLowerCase();

				municipios = ControladorMunicipio.municipioDescripcion(municipio);
				for (int i = 0; i < municipios.size(); i++) {
					jcbMunicipio.addItem(municipios.get(i));
				}

			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		jcbMunicipio = new JComboBox<Municipio>();
		GridBagConstraints gbc_jcbMunicipio = new GridBagConstraints();
		gbc_jcbMunicipio.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMunicipio.gridx = 0;
		gbc_jcbMunicipio.gridy = 1;
		contentPane.add(jcbMunicipio, gbc_jcbMunicipio);

		JButton btnNewButton_1 = new JButton("Seleccionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Municipio munEscogido = (Municipio) jcbMunicipio.getSelectedItem();
				jtfMunicipio.setText(munEscogido.getNombre());
				Provincia prov = munEscogido.getProvincia();

				for (int i = 0; i < provincias.size(); i++) {

					if (prov.getId() == provincias.get(i).getId()) {

						jcbProvincia.setSelectedIndex(i);
						break;
					}

				}

			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

		JLabel lblMunicipioSeleccionado = new JLabel("Municipio Seleccionado:");
		GridBagConstraints gbc_lblMunicipioSeleccionado = new GridBagConstraints();
		gbc_lblMunicipioSeleccionado.insets = new Insets(0, 0, 5, 5);
		gbc_lblMunicipioSeleccionado.gridx = 0;
		gbc_lblMunicipioSeleccionado.gridy = 2;
		contentPane.add(lblMunicipioSeleccionado, gbc_lblMunicipioSeleccionado);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel labelMunicipio = new JLabel("Nombre del municipio:");
		GridBagConstraints gbc_labelMunicipio = new GridBagConstraints();
		gbc_labelMunicipio.anchor = GridBagConstraints.EAST;
		gbc_labelMunicipio.insets = new Insets(0, 0, 5, 5);
		gbc_labelMunicipio.gridx = 0;
		gbc_labelMunicipio.gridy = 0;
		panel.add(labelMunicipio, gbc_labelMunicipio);

		jtfMunicipio = new JTextField();
		GridBagConstraints gbc_jtfMunicipio = new GridBagConstraints();
		gbc_jtfMunicipio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfMunicipio.gridx = 1;
		gbc_jtfMunicipio.gridy = 0;
		panel.add(jtfMunicipio, gbc_jtfMunicipio);
		jtfMunicipio.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Provincia del municipio");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbProvincia = new JComboBox<Provincia>();
		GridBagConstraints gbc_jcbProvincia = new GridBagConstraints();
		gbc_jcbProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProvincia.gridx = 1;
		gbc_jcbProvincia.gridy = 1;
		panel.add(jcbProvincia, gbc_jcbProvincia);

		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Provincia prov = (Provincia) jcbProvincia.getSelectedItem();
				Municipio mun = (Municipio) jcbMunicipio.getSelectedItem();
				
				mun.setProvincia(prov);
				
				ControladorMunicipio.modificar(mun);
				
				
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 2;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);

		provincias = new ArrayList<Provincia>();
		provincias = ControladorProvincia.findAll();
		for (int i = 0; i < provincias.size(); i++) {
			jcbProvincia.addItem(provincias.get(i));
		}

	}

}
