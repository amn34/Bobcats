/*
 * 
 */


package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.*;

import utilities.About;

/**
 * ManualGUI is the GUI for the HomeManual app.
 * 
 * @author tikes
 * @version 1 May 2020
 */
public class ManualGUI extends JFrame {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	       EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                final ManualGUI frame = new ManualGUI();
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setVisible(true);
	                frame.start();
	            }
	        });
	}

	ManualGUI() {
		super();
		
	}
	
	private void start() {
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		createMenuBar();
		add(displayPanel(), BorderLayout.CENTER);
	}
	
	private void createMenuBar() {
		final JMenuBar menuBar = new JMenuBar();
		
		menuBar.add(createFile());
		menuBar.add(createEdit());
		menuBar.add(createHelp());
		
		setJMenuBar(menuBar);
	}
	
	private JMenu createFile() {
		final JMenu file = new JMenu("File");
		// TODO: add file toolbar options
		return file;
	}
	
	private JMenu createEdit() {
		final JMenu edit = new JMenu("Edit");
		// TODO: add edit toolbar options
		return edit;
	}
	
	private JMenu createHelp() {
		final JMenu help = new JMenu("Help");
		final JMenuItem about = new JMenuItem("About...");
		help.add(about);
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theE) {
				try {
					String about = "Version: " + About.getVersion();
					about += "\nAuthors: " + Arrays.toString(About.getAuthors());
					
					JOptionPane.showMessageDialog(ManualGUI.this, about);
				} catch (HeadlessException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		return help;
	}
	
	private JPanel displayPanel() {
		JPanel display = new JPanel();
		
		return display;
	}
}
