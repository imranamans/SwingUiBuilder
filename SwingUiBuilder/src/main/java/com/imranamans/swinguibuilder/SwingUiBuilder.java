package com.imranamans.swinguibuilder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Enumeration;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 * @author SHAHI
 * 
 */
public class SwingUiBuilder {

	private DefaultMutableTreeNode componentTreeNode = null;
	private boolean debugEnabled = false;

	private static void example1() {
		/* @formatter:off */
		SwingUiBuilder.getNewInstance(false)
			.createFrame(new GridBagLayout())
				.addPanel(GBC.init().rowCol(0, 0).stretch(1, 1).gbc(), new GridBagLayout())
					.addLabel("Label 0", GBC.init().rowCol(0, 0).gbc())
						.getParent()
					.addTextField("Label 0", GBC.init().rowCol(0, 1).gbc())
						.getParent()
					.addLabel("Label 1", GBC.init().rowCol(1, 0).gbc())
						.getParent()
					.addTextField("Label 1", GBC.init().rowCol(1, 1).gbc())
						.getParent()
					.getParent()
				.addRowSeparator(GBC.init().rowCol(1, 0).anchor(GridBagConstraints.WEST).fill(GridBagConstraints.BOTH).stretch(1, 0).gbc())
					.getParent()
				.addPanel(GBC.init().rowCol(2, 0).gbc(), new GridBagLayout())
					.addLabel("Forcing this to be a long lable so it goes beyond the length of its containers standard width ", GBC.init().rowCol(0, 0).gbc())
						.getParent()
					.addTextField("Label 5", GBC.init().rowCol(0, 1).gbc())
						.getParent()
					.getParent()
				.addRowSeparator(GBC.init().rowCol(3, 0).anchor(GridBagConstraints.SOUTHWEST).fill(GridBagConstraints.BOTH).stretch(1, 0).gbc())
					.getParent()
				.addPanel(GBC.init().rowCol(4, 0).fill(GridBagConstraints.HORIZONTAL).stretch(1, 0).gbc(), new GridBagLayout())
					.addButton("Button 1", GBC.init().anchor(GridBagConstraints.EAST).stretch(1, 0).gbc())
						.getParent()
					.addButton("Button 2", GBC.init().anchor(GridBagConstraints.EAST).gbc())
						.show();
		/* @formatter:on */
	}
	
	private static void example2() {
		/* @formatter:off */
		SwingUiBuilder.getNewInstance(false)
			.createFrame(new GridBagLayout())
				.addPanel(GBC.init().rowCol(0, 0).stretch(1, 1).gbc(), new GridBagLayout())
					.addLabel("Label 0", GBC.init().anchor(GridBagConstraints.EAST).rowCol(0, 0).gbc())
						.getParent()
					.addTextField("Label 0", GBC.init().rowCol(0, 1).gbc())
						.getParent()
					.addLabel("Label 1", GBC.init().anchor(GridBagConstraints.EAST).rowCol(1, 0).gbc())
						.getParent()
					.addTextField("Label 1", GBC.init().rowCol(1, 1).gbc())
						.getParent()
					.addLabel("Big Long Label 2", GBC.init().anchor(GridBagConstraints.EAST).rowCol(2, 0).gbc())
						.getParent()
					.addTextField("Big Long Label 2", GBC.init().rowCol(2, 1).gbc())
						.getParent()
					.addLabel("Workspace Path", GBC.init().anchor(GridBagConstraints.EAST).rowCol(3, 0).gbc())
						.getParent()
					.addTextField("Workspace Path", GBC.init().rowCol(3, 1).gbc())
						.getParent()
					.addFolderSelectionButton("Browse", "Workspace Path", GBC.init().rowCol(3, 2).gbc())
						.getParent()
					.getParent()
				.addPanel(GBC.init().rowCol(2, 0).fill(GridBagConstraints.HORIZONTAL).stretch(1, 0).gbc(), new GridBagLayout())
					.addRowSeparator(GBC.init().rowCol(0, 0).widthHeight(2, 1).anchor(GridBagConstraints.SOUTHWEST).fill(GridBagConstraints.HORIZONTAL).stretch(1, 0).gbc())
						.getParent()
					.addButton("Ok", GBC.init().rowCol(1, 0).anchor(GridBagConstraints.EAST).stretch(1, 0).gbc())
						.getParent()
					.addButton("Cancel", GBC.init().rowCol(1, 1).anchor(GridBagConstraints.EAST).gbc())
						.show();
		/* @formatter:on */
	}
	
	public static void main(String[] args) {

//		example1();
		example2();
	}
	
	public SwingUiBuilder(boolean debugEnabled) {
		try {
			UIManager
				.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		this.debugEnabled = debugEnabled;
	}
	
	public SwingUiBuilder addFolderSelectionButton(String buttonName,
			final String textFieldName, Object constraints) {

		final JPanel jPanel = (JPanel) getCurrentObject();

		JButton jButton = SwingComponentFactory.createButton(buttonName);
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jFileChooser = SwingComponentFactory
						.createFolderChooser();
				int returnVal = jFileChooser.showOpenDialog(jPanel);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					JTextField jTextField = (JTextField) getComponent(textFieldName + "_txt");
					jTextField.setText(file.getPath());
				}
				// Reset the file chooser for the next time it's shown.
				jFileChooser.setSelectedFile(null);
			}
		});
		if (constraints != null) {
			jPanel.add(jButton, constraints);
		} else {
			jPanel.add(jButton);
		}
		setCurrentObject(jButton);
		return this;
	}

	public SwingUiBuilder addTextInput(String label) {

		JPanel jPanel = (JPanel) getCurrentObject();
		JLabel jLabel = SwingComponentFactory.createLabel(label);
		jPanel.add(jLabel);
		setCurrentObject(jLabel);
		getParent();
		JTextField jTextField = SwingComponentFactory.createTextField(label);
		jPanel.add(jTextField);
		setCurrentObject(jTextField);
		return this;
	}

	public SwingUiBuilder addRowSeparator(Object constraints) {

		JPanel jPanel = (JPanel) getCurrentObject();
		JSeparator jSeparator = SwingComponentFactory.createHorizontalSeparator();
		if (constraints != null) {
			jPanel.add(jSeparator, constraints);
		} else {
			jPanel.add(jSeparator);
		}
		setCurrentObject(jSeparator);

		return this;
	}
	
	public SwingUiBuilder addTextField(String name, Object constraints) {
		
		JPanel jPanel = (JPanel) getCurrentObject();
		JTextField jTextField = SwingComponentFactory.createTextField(name);
		if (constraints != null) {
			jPanel.add(jTextField, constraints);
		} else {
			jPanel.add(jTextField);
		}
		setCurrentObject(jTextField);
		
		return this;
	}
	
	public SwingUiBuilder addButton(String name, Object constraints) {

		JPanel jPanel = (JPanel) getCurrentObject();
		JButton jButton = SwingComponentFactory.createButton(name);
		if (constraints != null) {
			jPanel.add(jButton, constraints);
		} else {
			jPanel.add(jButton);
		}
		setCurrentObject(jButton);

		return this;
	}

	public SwingUiBuilder addLabel(String text, Object constraints) {

		JPanel jPanel = (JPanel) getCurrentObject();
		JLabel jLabel = SwingComponentFactory.createLabel(text);
		if (constraints != null) {
			jPanel.add(jLabel, constraints);
		} else {
			jPanel.add(jLabel);
		}
		setCurrentObject(jLabel);

		return this;
	}

	public SwingUiBuilder addPanel(Object constraints,
			LayoutManager layoutManager) {

		JPanel jPanel = SwingComponentFactory.createPanel();
		if (layoutManager != null) {
			jPanel.setLayout(layoutManager);
		}
		Container container = (Container) getCurrentObject();

		if (constraints != null) {
			container.add(jPanel, constraints);
		} else {
			container.add(jPanel);
		}
		setCurrentObject(jPanel);

		return this;
	}

	public void show() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Container root = getRoot();
					if (root instanceof JFrame) {
						JFrame rootFrame = ((JFrame) root);
						rootFrame.pack();
						Dimension dimension =  rootFrame.getPreferredSize();
						rootFrame.setMinimumSize(dimension);
					}
					root.setVisible(true);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}

	public SwingUiBuilder createFrame(LayoutManager layoutManager) {

		JFrame jframe = SwingComponentFactory.createFrame();
		jframe.setLayout(new BorderLayout());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jPanel = SwingComponentFactory.createPanel();
		jPanel.setLayout(layoutManager);
		jframe.getContentPane().add(jPanel, BorderLayout.CENTER);
		setRoot(jframe);
		setCurrentObject(jPanel);

		return this;
	}

	public SwingUiBuilder getParent() {
		componentTreeNode = (DefaultMutableTreeNode) componentTreeNode
				.getParent();
		return this;
	}
	
	private Component getComponent(String componentName) {
		DefaultMutableTreeNode node = find(
				(DefaultMutableTreeNode) getCurrentNode().getRoot(),
				componentName);
		return (Component) node.getUserObject();
	}

	private Component getCurrentObject() {
		return (Component) componentTreeNode.getUserObject();
	}

	public DefaultMutableTreeNode getCurrentNode() {
		return componentTreeNode;
	}

	private void setCurrentObject(Component component) {

		if (componentTreeNode != null) {
			MutableTreeNode treeNode = new DefaultMutableTreeNode(component);
			componentTreeNode.add(treeNode);
			componentTreeNode = (DefaultMutableTreeNode) treeNode;
		} else {
			componentTreeNode = new DefaultMutableTreeNode(component, true);
		}
		checkDebugEnabled(component);
		print(getName(component));
	}
	
	private void checkDebugEnabled(Component component) {
		if (this.debugEnabled) {
			if (component instanceof JComponent) {
				((JComponent) component).setBorder(BorderFactory
						.createLineBorder(Color.RED));
			}
		}
	}

	private void setRoot(Container container) {

		setCurrentObject(container);
	}

	public Container getRoot() {
		prettyPrintTree();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) this.componentTreeNode
				.getRoot();
		return (Container) node.getUserObject();
	}

	public static SwingUiBuilder getNewInstance(boolean debugEnabled) {

		return new SwingUiBuilder(debugEnabled);
	}

	private String getName(Component component) {

		return String.format("%s (%s)", component.getClass().getSimpleName(),
				component.getName());
	}

	private void print(String output) {

		System.out.printf("%s - %s\n", this.getClass().getSimpleName(), output);
	}

	private void prettyPrintTree() {

		if (componentTreeNode != null) {
			DefaultMutableTreeNode treeRoot = (DefaultMutableTreeNode) componentTreeNode
					.getRoot();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("\n");
			prettyPrintTree(treeRoot, stringBuilder);
			print(stringBuilder.toString());
		}
	}

	@SuppressWarnings("unchecked")
	private void prettyPrintTree(DefaultMutableTreeNode node,
			StringBuilder stringBuilder) {

		stringBuilder.append(getName((Component) node.getUserObject()) + "\n");
		Enumeration<DefaultMutableTreeNode> children = node.children();
		while (children.hasMoreElements()) {
			node = (DefaultMutableTreeNode) children.nextElement();
			for (int i = 0; i < node.getLevel(); i++) {
				stringBuilder.append("    ");
			}
			prettyPrintTree(node, stringBuilder);
		}
	}
	
	protected DefaultMutableTreeNode find(DefaultMutableTreeNode node,
			String userObjectName) {
		Stack<DefaultMutableTreeNode> stack = new Stack<DefaultMutableTreeNode>();
		stack.push(node);

		DefaultMutableTreeNode temp = null;
		// contextSet.add(rootNode.getType());
		found: {
			while (!stack.isEmpty()) {
				DefaultMutableTreeNode r = stack.pop();
				for (int i = 0; i < r.getChildCount(); i++) {
					temp = (DefaultMutableTreeNode) r.getChildAt(i);
					if (userObjectName
							.equals(((Component) temp.getUserObject())
									.getName())) {
						break found;
					}
					stack.push(temp);
				}
			}
		}
		return temp;
	}
}
