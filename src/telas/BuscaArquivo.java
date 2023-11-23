package telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class BuscaArquivo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtBuscar; 
	private JButton btnBuscar;
	private JLabel lblCdigo;
	private JLabel lblCdigo_1;
	private JTextField txtCodigoorigem;
	private JTextField txtCodigodestino;
	private JLabel lblCidade;
	private JLabel lblCidade_1;
	private JTextField txtCidadeorigem;
	private JTextField txtCidadedestino;
	private JLabel lblorigem;
	private JLabel lbldestino;
	private JLabel lblKm;
	private JTextField txtKm;
	private JButton btnMais;
	private JButton btnSalvar;
	private JButton btnProcessar;

	/**
	 * Create the panel.
	 */
	public BuscaArquivo() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{80, 0, 56, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{40, 40, 40, 0, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Buscar:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtBuscar = new JTextField();
		GridBagConstraints gbc_txtBuscar = new GridBagConstraints();
		gbc_txtBuscar.gridwidth = 5;
		gbc_txtBuscar.fill = GridBagConstraints.BOTH;
		gbc_txtBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_txtBuscar.gridx = 1;
		gbc_txtBuscar.gridy = 0;
		add(txtBuscar, gbc_txtBuscar);
		txtBuscar.setColumns(6);
		
		btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.fill = GridBagConstraints.VERTICAL;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.gridx = 6;
		gbc_btnBuscar.gridy = 0;
		add(btnBuscar, gbc_btnBuscar);
		
		lblCdigo = new JLabel("Código:");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 1;
		add(lblCdigo, gbc_lblCdigo);
		
		txtCodigoorigem = new JTextField();
		txtCodigoorigem.setText("codigoOrigem");
		GridBagConstraints gbc_txtCodigoorigem = new GridBagConstraints();
		gbc_txtCodigoorigem.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigoorigem.fill = GridBagConstraints.BOTH;
		gbc_txtCodigoorigem.gridx = 1;
		gbc_txtCodigoorigem.gridy = 1;
		add(txtCodigoorigem, gbc_txtCodigoorigem);
		txtCodigoorigem.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 2;
		gbc_lblCidade.gridy = 1;
		add(lblCidade, gbc_lblCidade);
		
		txtCidadeorigem = new JTextField();
		txtCidadeorigem.setText("cidadeOrigem");
		GridBagConstraints gbc_txtCidadeorigem = new GridBagConstraints();
		gbc_txtCidadeorigem.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidadeorigem.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidadeorigem.gridx = 3;
		gbc_txtCidadeorigem.gridy = 1;
		add(txtCidadeorigem, gbc_txtCidadeorigem);
		txtCidadeorigem.setColumns(10);
		
		lblorigem = new JLabel("(origem)");
		GridBagConstraints gbc_lblorigem = new GridBagConstraints();
		gbc_lblorigem.insets = new Insets(0, 0, 5, 5);
		gbc_lblorigem.gridx = 4;
		gbc_lblorigem.gridy = 1;
		add(lblorigem, gbc_lblorigem);

		lblCdigo_1 = new JLabel("Código:");
		GridBagConstraints gbc_lblCdigo_1 = new GridBagConstraints();
		gbc_lblCdigo_1.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo_1.gridx = 0;
		gbc_lblCdigo_1.gridy = 2;
		add(lblCdigo_1, gbc_lblCdigo_1);
		
		txtCodigodestino = new JTextField();
		txtCodigodestino.setText("codigoDestino");
		GridBagConstraints gbc_txtCodigodestino = new GridBagConstraints();
		gbc_txtCodigodestino.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigodestino.fill = GridBagConstraints.BOTH;
		gbc_txtCodigodestino.gridx = 1;
		gbc_txtCodigodestino.gridy = 2;
		add(txtCodigodestino, gbc_txtCodigodestino);
		txtCodigodestino.setColumns(10);
		
		lblCidade_1 = new JLabel("Cidade:");
		GridBagConstraints gbc_lblCidade_1 = new GridBagConstraints();
		gbc_lblCidade_1.anchor = GridBagConstraints.EAST;
		gbc_lblCidade_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade_1.gridx = 2;
		gbc_lblCidade_1.gridy = 2;
		add(lblCidade_1, gbc_lblCidade_1);
		
		txtCidadedestino = new JTextField();
		txtCidadedestino.setText("cidadeDestino");
		GridBagConstraints gbc_txtCidadedestino = new GridBagConstraints();
		gbc_txtCidadedestino.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidadedestino.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidadedestino.gridx = 3;
		gbc_txtCidadedestino.gridy = 2;
		add(txtCidadedestino, gbc_txtCidadedestino);
		txtCidadedestino.setColumns(10);
		
		lbldestino = new JLabel("(destino)");
		GridBagConstraints gbc_lbldestino = new GridBagConstraints();
		gbc_lbldestino.insets = new Insets(0, 0, 5, 5);
		gbc_lbldestino.gridx = 4;
		gbc_lbldestino.gridy = 2;
		add(lbldestino, gbc_lbldestino);
		
		lblKm = new JLabel("Km:");
		GridBagConstraints gbc_lblKm = new GridBagConstraints();
		gbc_lblKm.anchor = GridBagConstraints.EAST;
		gbc_lblKm.insets = new Insets(0, 0, 5, 5);
		gbc_lblKm.gridx = 0;
		gbc_lblKm.gridy = 3;
		add(lblKm, gbc_lblKm);
		
		txtKm = new JTextField();
		txtKm.setText("km");
		GridBagConstraints gbc_txtKm = new GridBagConstraints();
		gbc_txtKm.insets = new Insets(0, 0, 5, 5);
		gbc_txtKm.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKm.gridx = 1;
		gbc_txtKm.gridy = 3;
		add(txtKm, gbc_txtKm);
		txtKm.setColumns(10);
		
		btnMais = new JButton("+");
		GridBagConstraints gbc_btnMais = new GridBagConstraints();
		gbc_btnMais.insets = new Insets(0, 0, 5, 0);
		gbc_btnMais.gridx = 6;
		gbc_btnMais.gridy = 3;
		add(btnMais, gbc_btnMais);
		
		
		String[][] dados = {};
		String[] colunas = {"Código Origem", "Cidade Origem", "Código Destino", "Cidade Destino", "Distância"};
		table = new JTable(dados,colunas);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Origem", "Cidade Origem", "C\u00F3digo Destino", "Cidade Destino", "Dist\u00E2ncia"
			}
		));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 7;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 4;
		add(new JScrollPane(table), gbc_table);
		
		btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 4;
		gbc_btnSalvar.gridy = 5;
		add(btnSalvar, gbc_btnSalvar);
		
		btnProcessar = new JButton("Processar");
		GridBagConstraints gbc_btnProcessar = new GridBagConstraints();
		gbc_btnProcessar.gridx = 6;
		gbc_btnProcessar.gridy = 5;
		add(btnProcessar, gbc_btnProcessar);

	}

}
