package com.imranamans.swinguibuilder;

import java.awt.*;

/**
 * Created by SHAHI on 1/5/2015.
 */
public class SimpleDemo2 {

    public static void main(String[] args) {

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
}
