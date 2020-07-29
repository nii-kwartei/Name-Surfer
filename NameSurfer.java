
/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
public class NameSurfer extends ConsoleProgram implements NameSurferConstants {

	// First declare the instance variables
	private JTextField readName;
	private JButton graph;
	private JButton clear;
	private JLabel labelName;
	private NameSurferDataBase entry;

	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base and
	 * initializing the interactors at the bottom of the window.
	 */
	public void init() {

		// set size
		setSize(500, 200);
		
		setup();
		entry = new NameSurferDataBase(NAMES_DATA_FILE);
		addActionListeners();
	}

	// setup method
	private void setup() {
		labelName = new JLabel("Name:");
		add(labelName, SOUTH);

		readName = new JTextField(10);
		add(readName, SOUTH);
		readName.addActionListener(this);

		graph = new JButton("Graph");
		add(graph, SOUTH);

		clear = new JButton("Clear");
		add(clear, SOUTH);
	}

	/* Method: actionPerformed(e) */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Clear")) {
			readName.setText("");
		} else {
			println(entry.findEntry(readName.getText().toLowerCase()));

		}

	}
}
