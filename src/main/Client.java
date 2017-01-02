package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Client  {
	/**
	 * @wbp.parser.entryPoint
	 */
	
	static ViewMaps viewMaps;
	static ViewPlayers viewPlayers;

	private static void prepareGUI() {
		JFrame client = new JFrame("10 Man Application");
		viewMaps = new ViewMaps();
		viewPlayers = new ViewPlayers();
		
		client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client.setSize(new Dimension(500,500));
		
		JPanel panel = new JPanel();
		client.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JButton btnCreatePug = new JButton("Create PUG");
		/* Create Pug Button Press */
		btnCreatePug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO implement Create Pug 
			}
		});
		btnCreatePug.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(btnCreatePug);
		
		JButton btnViewMaps = new JButton("View Maps");
		btnViewMaps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewMaps.setVisible(true);
			}
		});
		btnViewMaps.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(btnViewMaps);
		
		JButton btnViewPlayers = new JButton("View Players");
		btnViewPlayers.setFont(new Font("Tahoma", Font.PLAIN, 32));
		/* View Players Button Press */
		btnViewPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPlayers.setVisible(true);
			}
		});
		panel.add(btnViewPlayers);
		client.setVisible(true);

		
	}

	public static void main(String[] args) throws IOException {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}	
		prepareGUI();
	}
}
