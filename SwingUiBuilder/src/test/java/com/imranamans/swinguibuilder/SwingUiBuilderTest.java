package com.imranamans.swinguibuilder;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

import static org.junit.Assert.assertThat;

public class SwingUiBuilderTest {

	@Test
	public void testFind2() {
		
		/* @formatter:off */
		DefaultMutableTreeNode componentTreeNode = SwingUiBuilder.getNewInstance(false)
			.createFrame(new GridBagLayout())
				.addPanel(GBC.init().rowCol(0, 0).stretch(1, 1).gbc(), new GridBagLayout())
					.addLabel("Workspace Path", GBC.init().anchor(GridBagConstraints.EAST).rowCol(3, 0).gbc())
						.getParent()
					.addTextField("Workspace Path", GBC.init().rowCol(3, 1).gbc())
						.getParent()
					.addFolderSelectionButton("Browse", "Workspace Path", GBC.init().rowCol(3, 2).gbc())
						.getCurrentNode();
		DefaultMutableTreeNode actual = SwingUiBuilder.getNewInstance(false).find((DefaultMutableTreeNode) componentTreeNode.getRoot(), "Workspace Path_txt");
		
		assertThat(((Component)actual.getUserObject()).getName(), CoreMatchers.is("Workspace Path_txt"));
		/* @formatter:on */
	}

}
