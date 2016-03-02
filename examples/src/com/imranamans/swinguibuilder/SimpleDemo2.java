package com.imranamans.swinguibuilder;

import java.awt.*;

/**
 * Created by SHAHI on 1/5/2015.
 */
public class SimpleDemo2 {

    public static void main(String[] args) {

    /* @formatter:off */
        SwingUiBuilder.getNewInstance(false)
                .createFrame("simpleDemo2Frame", new GridBagLayout())
                        .addPanel("simpleDemo2Panel1", GBC.init().rowCol(0, 0).stretch(1, 1).gbc(), new GridBagLayout())
                                .addLabel("label1", "Label 0", GBC.init().anchor(GridBagConstraints.EAST).rowCol(0, 0).gbc())
                                        .getParent()
                                .addTextField("Label 0", GBC.init().rowCol(0, 1).gbc())
                                        .getParent()
                                .addLabel("label2", "Label 1", GBC.init().anchor(GridBagConstraints.EAST).rowCol(1, 0).gbc())
                                        .getParent()
                                .addTextField("Label 1", GBC.init().rowCol(1, 1).gbc())
                                        .getParent()
                                .addLabel("label3", "Big Long Label 2", GBC.init().anchor(GridBagConstraints.EAST).rowCol(2, 0).gbc())
                                        .getParent()
                                .addTextField("bigLongText", GBC.init().rowCol(2, 1).gbc())
                                        .getParent()
                                .addLabel("label4", "Workspace Path", GBC.init().anchor(GridBagConstraints.EAST).rowCol(3, 0).gbc())
                                        .getParent()
                                .addTextField("workspacePath", GBC.init().rowCol(3, 1).gbc())
                                        .getParent()
                                .addFolderSelectionButton("Browse", "Workspace Path", GBC.init().rowCol(3, 2).gbc())
                                        .getParent()
                                .getParent()
                        .addPanel("simpleDemo2Panel2", GBC.init().rowCol(2, 0).fill(GridBagConstraints.HORIZONTAL).stretch(1, 0).gbc(), new GridBagLayout())
                                .addRowSeparator("line1", GBC.init().rowCol(0, 0).widthHeight(2, 1).anchor(GridBagConstraints.SOUTHWEST).fill(GridBagConstraints.HORIZONTAL).stretch(1, 0).gbc())
                                        .getParent()
                                .addButton("button1", "Ok", GBC.init().rowCol(1, 0).anchor(GridBagConstraints.EAST).stretch(1, 0).gbc())
                                        .getParent()
                                .addButton("button2", "Cancel", GBC.init().rowCol(1, 1).anchor(GridBagConstraints.EAST).gbc())
                .show();
        /* @formatter:on */
    }
}
