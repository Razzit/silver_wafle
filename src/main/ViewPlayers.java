package main;


import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


public class ViewPlayers {
	JFrame viewPlayers;
	JList<String> list;
	String playerName;
	JOptionPane inputURL;
	ArrayList<Players> players;
	String[] data = {"test value", "test value", "test value"};
	Players newPlayer;
	
	JScrollPane scrollPane;
	JList<String> list_1;
	DefaultListModel<String> listModel;
	
	int removeIndex = -1;
	
	/* Write to file */
	String file_name = "playerList.txt";
	
	
	
	public ViewPlayers(){
		prepareGUI();
		readFile();
	}


	private void prepareGUI() {
		players = new ArrayList<Players>();
		viewPlayers = new JFrame("View Maps");
		viewPlayers.setLocationByPlatform(true);
		viewPlayers.setResizable(false);
		viewPlayers.setPreferredSize(new Dimension(700, 500));
		viewPlayers.setBackground(new Color(255, 192, 203));
		viewPlayers.setExtendedState(Frame.ICONIFIED);
		viewPlayers.setSize(700, 500);
		viewPlayers.getContentPane().setLayout(null);
		viewPlayers.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 350, 450);
		viewPlayers.getContentPane().add(leftPanel);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[]{300, 0};
		gbl_leftPanel.rowHeights = new int[]{400, 0};
		gbl_leftPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_leftPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		leftPanel.setLayout(gbl_leftPanel);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(350, 450));
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.NORTHWEST;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		leftPanel.add(scrollPane, gbc_scrollPane);
		
		

		// TESTING STUFF HERE 
				
		
		listModel = new DefaultListModel<String>();
		
		list_1 = new JList<String>(listModel);
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				removeIndex = list_1.getSelectedIndex();
				System.out.println(removeIndex);
			}
		});
		
		list_1.setVisibleRowCount(-1);
		list_1.setBackground(Color.WHITE);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		scrollPane.setViewportView(list_1);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(350, 0, 335, 384);
		viewPlayers.getContentPane().add(rightPanel);
		rightPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		/* Add Player Button Press */
		JButton btnAddPlayer = new JButton("Add Player");
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerName = JOptionPane.showInputDialog("Enter Name: ");
				addPlayer(playerName);
			}
		});
		btnAddPlayer.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		btnAddPlayer.setBackground(new Color(0, 153, 0));
		rightPanel.add(btnAddPlayer);
		
		/* Remove Player Button Press */
		JButton btnRemovePlayer = new JButton("Remove Player");
		btnRemovePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removePlayer();
			}
		});
		
		rightPanel.add(btnRemovePlayer);
		btnRemovePlayer.setBackground(new Color(255, 192, 203));
		btnRemovePlayer.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		
		JPanel panel = new JPanel();
		panel.setBounds(350, 383, 335, 67);
		viewPlayers.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		/* Back Button Press */
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeToFile();
				viewPlayers.setVisible(false);
			}
		});
		panel.add(btnBack);
		
		
	}
	
	/* set the JFrame visibility state */
	public void setVisible(boolean val){
		viewPlayers.setVisible(val);
	}
	
	/* Add a new Player */
	private void addPlayer(String playerName){
		newPlayer = new Players(playerName);
		players.add(newPlayer);
		listModel.addElement(playerName);
		System.out.println("Current players: " + players);
		
	}
	
	private void removePlayer() {
		if(removeIndex != -1){
			players.remove(removeIndex);
			listModel.remove(removeIndex);
		}
		else{
			System.out.println("No player Selected");
		}
	}
	
	private void writeToFile() {
		try {
			WriteFile writePlayers = new WriteFile(file_name, false);
			writePlayers.writeToPlayersFile(players);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void readFile() {
		try {
			ReadFile file = new ReadFile(file_name);
			players = file.OpenPlayersFile();
			
			
			for(int i = 0; i<players.size();i++){
				listModel.addElement(players.get(i).getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
