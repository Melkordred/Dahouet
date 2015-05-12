package UIVoilier;


import UIVoilier.SaisieInfos;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class Enregistrement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BufferedImage b;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					
					Enregistrement frame = new Enregistrement();
					
					b = ImageIO.read(new File("img/caravelle.jpg"));
					
					 JPanel panel = new JPanel()
			        {
			            /**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						@Override
			            protected void paintComponent(Graphics g)
			            {
			                Graphics g2 = g.create();
			                g2.drawImage(b, 0, 0, getWidth(), getHeight(), null);
			                g2.dispose();
			            }

			            @Override
			            public Dimension getPreferredSize(){
			                return new Dimension(b.getWidth(), b.getHeight());
			            }
			        };

			        frame.getContentPane().add(panel);
			        frame.pack();
			        frame.setLocationRelativeTo(null);
			        frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Enregistrement() 
	{
		setFont(new Font("Dialog", Font.BOLD, 22));
		setTitle("Enregistrement d'un voilier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEnregistrement = new JMenu("Enregistrement");
		menuBar.add(mnEnregistrement);
		
		JMenuItem mntmNouvelEnregistrement = new JMenuItem("Nouvel enregistrement");
		mntmNouvelEnregistrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				  SaisieInfos newFrame = new SaisieInfos();
				  newFrame.pack();
				  newFrame.setVisible(true);
			}
		});
		mnEnregistrement.add(mntmNouvelEnregistrement);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		JSeparator separator = new JSeparator();
		mnEnregistrement.add(separator);
		mnEnregistrement.add(mntmQuitter);
		
		JMenu menu = new JMenu("?");
		menuBar.add(menu);
		
		JMenuItem mntmInfos = new JMenuItem("Infos");
		mntmInfos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ImageIcon img = new ImageIcon("img/bateau.png");
				JOptionPane.showMessageDialog(null, "Programme pour la gestion des régate de Dahouët.\n Melko.®.", "Dindhouët 3.0", JOptionPane.INFORMATION_MESSAGE, img);
			}
		});
		menu.add(mntmInfos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

}
