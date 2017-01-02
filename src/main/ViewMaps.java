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


public class ViewMaps {
	JFrame viewMaps;
	JList<String> list;
	String steamURL;
	JOptionPane inputURL;
	ArrayList<WorkshopMap> maps;
	String[] data = {"test value", "test value", "test value"};
	ArrayList<String> mapNames;
	WorkshopMap newMap, newMap2, testingMap;
	
	JScrollPane scrollPane;
	JList<String> list_1;
	DefaultListModel<String> listModel;
	
	int removeIndex = -1;
	

	
	public ViewMaps(){
		prepareGUI();
	}

	private void prepareGUI() {
		maps = new ArrayList<WorkshopMap>();
		viewMaps = new JFrame("View Maps");
		viewMaps.setLocationByPlatform(true);
		viewMaps.setResizable(false);
		viewMaps.setPreferredSize(new Dimension(700, 500));
		viewMaps.setBackground(new Color(255, 192, 203));
		viewMaps.setExtendedState(Frame.ICONIFIED);
		viewMaps.setSize(700, 500);
		viewMaps.getContentPane().setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 350, 450);
		viewMaps.getContentPane().add(leftPanel);
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
			}
		});
		
		list_1.setVisibleRowCount(-1);
		list_1.setBackground(Color.WHITE);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		scrollPane.setViewportView(list_1);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(350, 0, 335, 384);
		viewMaps.getContentPane().add(rightPanel);
		rightPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		/* Add Map Button Press */
		JButton btnAddMap = new JButton("Add Map");
		btnAddMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				steamURL = JOptionPane.showInputDialog("Enter SteamURL: ");
				addMap(steamURL);
			}
		});
		btnAddMap.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		btnAddMap.setBackground(new Color(0, 153, 0));
		rightPanel.add(btnAddMap);
		
		/* Remove Map Button Press */
		JButton btnRemoveMap = new JButton("Remove Map");
		btnRemoveMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeMap();
			}
		});
		
		rightPanel.add(btnRemoveMap);
		btnRemoveMap.setBackground(new Color(255, 192, 203));
		btnRemoveMap.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		
		JPanel panel = new JPanel();
		panel.setBounds(350, 383, 335, 67);
		viewMaps.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewMaps.setVisible(false);
			}
		});
		panel.add(btnBack);
		
		
	}
	
	public void setVisible(boolean val){
		viewMaps.setVisible(val);
		
	}
	
	
	public void addMap(String steamURL){
		newMap = new WorkshopMap(steamURL);
		maps.add(newMap);
		listModel.addElement(newMap.getWorkshopTitle());
		System.out.println("Current maps: " + maps);
		
	}
	
	private void removeMap() {
		if(removeIndex != -1){
			maps.remove(removeIndex);
			listModel.remove(removeIndex);
		}
		else{
			System.out.println("No map Selected");
		}
	}
	

	
}
