package UIVoilier;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.List;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import DAO.ClasseDAO;
import DAO.ProprioDAO;
import DAO.SerieDAO;
import DAO.VoilierDAO;
import ModelUI.Voilier;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JTextField;

public class SaisieInfos extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JComboBox<String> serie = new JComboBox<String>();
	public static JComboBox<String> classe = new JComboBox<String>();
	public static JComboBox<String> proprietaires = new JComboBox<String>();
	private JTextField textNumvoile;
	private JTextField textNomVoilier;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SaisieInfos() 
	{
		setBackground(Color.BLUE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSlectionSrie = new JLabel("S\u00E9lection S\u00E9rie :");
		lblSlectionSrie.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblSlectionSrie = new GridBagConstraints();
		gbc_lblSlectionSrie.insets = new Insets(0, 0, 5, 5);
		gbc_lblSlectionSrie.anchor = GridBagConstraints.EAST;
		gbc_lblSlectionSrie.gridx = 0;
		gbc_lblSlectionSrie.gridy = 0;
		contentPane.add(lblSlectionSrie, gbc_lblSlectionSrie);
		
		serie = new JComboBox<String>();
		
		List<String> listSerie = SerieDAO.getListSerie();
		

		  for (String seri: listSerie)
		  {
			  serie.addItem(seri);
		  }
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		contentPane.add(serie, gbc_comboBox);
		
		JLabel lblSlectionClasse = new JLabel("S\u00E9lection Classe :");
		lblSlectionClasse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblSlectionClasse = new GridBagConstraints();
		gbc_lblSlectionClasse.anchor = GridBagConstraints.EAST;
		gbc_lblSlectionClasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblSlectionClasse.gridx = 0;
		gbc_lblSlectionClasse.gridy = 2;
		contentPane.add(lblSlectionClasse, gbc_lblSlectionClasse);
		
		classe = new JComboBox<String>();
		
		List<String> listClasse = ClasseDAO.getListClasse(1);
		
		for (String cla: listClasse)
		{
			classe.addItem(cla);
		}
		
		serie.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e) // je remplis ma comboBox classe suivant la série sélectionnée
			{
				String choix = valcomboSerie();
				
				switch(choix)
				{
				case "Habitables" : 		classe.removeAllItems();
										//	ClasseDAO.rempli_comboBoxClasse(1);
				
											List<String> listClasse = ClasseDAO.getListClasse(1);
				
											for (String cla: listClasse)
											{
												classe.addItem(cla);
											}
											break;
											
				case "Quillards de sport" : classe.removeAllItems();
										//	ClasseDAO.rempli_comboBoxClasse(2);
				
											List<String> listClasse2 = ClasseDAO.getListClasse(2);
				
											for (String cla: listClasse2)
											{
												classe.addItem(cla);
											}
											break;
				}
			}
		});

		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 2;
		contentPane.add(classe, gbc_comboBox_1);
		
		JLabel lblNewLabel = new JLabel("S\u00E9lection d'un propri\u00E9taire :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 4;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		proprietaires = new JComboBox<String>();
		
		
		proprietaires.removeAllItems();
		proprietaires.addItem("Nouveau Proprietaire");

		
		List<String> listProp = ProprioDAO.getListProprietaire();

		  for (String proprio: listProp)
		  {
			  proprietaires.addItem(proprio);
		  }
		
		
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 2;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 4;
		contentPane.add(proprietaires, gbc_comboBox_2);
		
		JLabel lblNumroDeVoile = new JLabel("Num\u00E9ro de Voile :");
		lblNumroDeVoile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblNumroDeVoile = new GridBagConstraints();
		gbc_lblNumroDeVoile.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDeVoile.gridx = 0;
		gbc_lblNumroDeVoile.gridy = 5;
		contentPane.add(lblNumroDeVoile, gbc_lblNumroDeVoile);
		
		textNumvoile = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 5;
		contentPane.add(textNumvoile, gbc_textField);
		textNumvoile.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom du Voilier :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 6;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textNomVoilier = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 6;
		contentPane.add(textNomVoilier, gbc_textField_1);
		textNomVoilier.setColumns(10);
		
		JButton btnNewButton = new JButton("Enregistrer Nouveau Voilier");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ctlVoilier();
				setVisible(false);
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 8;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
		});
		
		JButton btnNouveauProprietaire = new JButton("Nouveau Proprietaire");
		btnNouveauProprietaire.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				NewProprio prop = new NewProprio();
				prop.pack();
				prop.setVisible(true);
			//	dispose();
			}
		});
		GridBagConstraints gbc_btnNouveauProprietaire = new GridBagConstraints();
		gbc_btnNouveauProprietaire.insets = new Insets(0, 0, 0, 5);
		gbc_btnNouveauProprietaire.gridx = 2;
		gbc_btnNouveauProprietaire.gridy = 8;
		contentPane.add(btnNouveauProprietaire, gbc_btnNouveauProprietaire);
		btnAnnuler.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.gridx = 3;
		gbc_btnAnnuler.gridy = 8;
		contentPane.add(btnAnnuler, gbc_btnAnnuler);
	}
	

public String valcomboSerie( ){return (String)SaisieInfos.serie.getSelectedItem();} //on récupère la valeur affichée dans la comboBox Serie
public String valcomboClasse( ){return (String)SaisieInfos.classe.getSelectedItem();}
public static String valcomboProprio( ){return (String)SaisieInfos.proprietaires.getSelectedItem();}


private void ctlVoilier() 
{
	
	String classe = valcomboClasse();
	String nom_voilier = textNomVoilier.getText();
	String nompro = valcomboProprio();
	
	if ((textNumvoile.getText().equals(""))) 
	{
		JOptionPane.showMessageDialog(this, "Veuillez saisir un numéro de voile", "Erreur saisie",
				JOptionPane.WARNING_MESSAGE);
		return;
	}
	
	if ((textNomVoilier.getText().equals(""))) 
	{
		JOptionPane.showMessageDialog(this, "Veuillez saisir le nom du voilier", "Erreur saisie",
				JOptionPane.WARNING_MESSAGE);
		return;
	}
	
	int num_voile = Integer.parseInt(textNumvoile.getText());
	int num_proprio = ProprioDAO.recupNumProprio(nompro);
	

	Voilier voil = new Voilier(num_voile,num_proprio,classe,nom_voilier);
	

	VoilierDAO.createVoilier(voil);
	

} 
}
