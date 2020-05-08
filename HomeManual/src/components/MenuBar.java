package components;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import utilities.About;
import view.ManualGUI;

/**
 * Creates a menu bar 
 * @author Anthony Nguyen
 * @author Tyke Sykes
 */
public class MenuBar extends JMenuBar{
	
	
	/** default serial id */
	private static final long serialVersionUID = 1L;
	
	/** main GUI*/
	private ManualGUI myGUI; 
	
	/**
	 * Creates a menu bar for the GUI. 
	 * @param theGUI the main display 
	 */
	public MenuBar(final ManualGUI theGUI) {
		myGUI = theGUI;
		add(createFile());
		add(createEdit());
		add(createHelp());
	}
	
	/**
	 * Creates the File menu.
	 * @return File menu.
	 */
	private JMenu createFile() {
		final JMenu file = new JMenu("File");
		// TODO: add file toolbar options
		return file;
	}
	
	/**
	 * Creates the Edit menu.
	 * @return the Edit menu.
	 */
	private JMenu createEdit() {
		final JMenu edit = new JMenu("Edit");
		// TODO: add edit toolbar options
		return edit;
	}
	
	/**
	 * Creates the Help menu. Contains the About menu item
	 * that displays the authors and version of the app.
	 * @return the Help menu.
	 */
	private JMenu createHelp() {
		final JMenu help = new JMenu("Help");
		final JMenuItem about = new JMenuItem("About...");
		help.add(about);
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theE) {
				try {
					String about = "Version: " + About.getVersion();
					about += "\nAuthors: " + Arrays.toString(About.getAuthors()).substring(1,
							Arrays.toString(About.getAuthors()).length() - 1);
					
					JOptionPane.showMessageDialog(myGUI, about);
				} catch (HeadlessException | IOException e) {
					JOptionPane.showMessageDialog(myGUI, "Cannot find version file.");
					e.printStackTrace();
				}
			}
		});
		return help;
	}
}
