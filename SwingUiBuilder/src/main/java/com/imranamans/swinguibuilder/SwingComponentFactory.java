/**
 * 
 */
package com.imranamans.swinguibuilder;

import javax.swing.*;
import java.awt.*;

/**
 * @author SHAHI
 * 
 */
public class SwingComponentFactory {

	private SwingComponentFactory() {
	}

	public static JFrame createFrame() {
		JFrame jFrame = new JFrame();
		return jFrame;
	}

	public static JPanel createPanel() {
		JPanel jPanel = new JPanel(); // default is flow layout.
		return jPanel;
	}
	
	public static Dimension createDimension(int width, int height) {
		Dimension dimension = new Dimension();
		dimension.width = width;
		dimension.height = height;
		return dimension;
	}

	public static JLabel createLabel(String text) {
		JLabel jLabel = new JLabel();
		// text does not wrap automatically and so work around.
		jLabel.setText("<html><body><table><tr><td>" + text
				+ "</td></tr></table></body></html>"); 
		jLabel.setName(text+"_lbl");
		// jLabel.setPreferredSize(createDimension(120, 25));
		jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		return jLabel;
	}

	public static JFileChooser createFileChooser() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		return jFileChooser;
	}
	
	public static JFileChooser createFolderChooser() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		return jFileChooser;
	}
	
	public static JTextField createTextField(String name) {
		JTextField jTextField = new JTextField();
		jTextField.setName(name + "_txt");
		jTextField.setPreferredSize(createDimension(240, 25));
		return jTextField;
	}
	
	public static JSeparator createHorizontalSeparator() {
		JSeparator jSeparator = new JSeparator(SwingConstants.HORIZONTAL);
		//jSeparator.setPreferredSize()
		return jSeparator;
	}
	
	public static JButton createButton(String text) {
		JButton jButton = new JButton(text);
		jButton.setPreferredSize(createDimension(80, 26));
		return jButton;
	}
}
