package com.imranamans.swinguibuilder;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

import static org.junit.Assert.assertThat;

public class SwingUiBuilderTest {

	@Test
	public void test_SwingUiBuilder_cannot_be_initialized_using_constructor() {

		// SwingUiBuilder swingUiBuilder = new SwingUiBuilder();
	}

	@Test
	public void test_find() {
		
		/* @formatter:off */
		DefaultMutableTreeNode componentTreeNode = SwingUiBuilder.getNewInstance(false)
			.createFrame("frameId", new GridBagLayout())
				.addPanel("panelId", GBC.init().rowCol(0, 0).stretch(1, 1).gbc(), new GridBagLayout())
					.addLabel("labelId", "Workspace Path", GBC.init().anchor(GridBagConstraints.EAST).rowCol(3, 0).gbc())
						.getParent()
					.addTextField("workspacePath", GBC.init().rowCol(3, 1).gbc())
						.getParent()
					.addFolderSelectionButton("Browse", "workspacePath", GBC.init().rowCol(3, 2).gbc())
						.getCurrentNode();
		DefaultMutableTreeNode actual = SwingUiBuilder.getNewInstance(false).find((DefaultMutableTreeNode) componentTreeNode.getRoot(), "workspacePath");
		
		assertThat(((Component)actual.getUserObject()).getName(), CoreMatchers.is("workspacePath"));
		/* @formatter:on */
	}

}
