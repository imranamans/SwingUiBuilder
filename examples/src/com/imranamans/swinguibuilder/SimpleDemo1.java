package com.imranamans.swinguibuilder;

import java.awt.*;

/**
 * Created by SHAHI on 1/4/2015.
 */
public class SimpleDemo1 {

    public static void main(String[] args) {
        /* @formatter:off */
        SwingUiBuilder.getNewInstance(false)
                .createFrame("simpleDemo1Frame", new GridBagLayout())
                        .addPanel("simpleDemo1Panel1", GBC.init().rowCol(0, 0).stretch(1, 1).gbc(), new GridBagLayout())
                                .addLabel("label1", "Label 0", GBC.init().rowCol(0, 0).gbc())
                                        .getParent()
                                .addTextField("Label 0", GBC.init().rowCol(0, 1).gbc())
                                        .getParent()
                                .addLabel("label2", "Label 1", GBC.init().rowCol(1, 0).gbc())
                                        .getParent()
                                .addTextField("Label 1", GBC.init().rowCol(1, 1).gbc())
                                        .getParent()
                                .getParent()

                        .addRowSeparator("line1", GBC.init().rowCol(1, 0).anchor(GridBagConstraints.WEST).fill(GridBagConstraints.BOTH).stretch(1, 0).gbc())
                                    .getParent()
                            .addPanel("simpleDemo1Panel2", GBC.init().rowCol(2, 0).gbc(), new GridBagLayout())
                                    .addLabel("label3", "Forcing this to be a long label so it goes beyond the length of its containers standard width ", GBC.init().rowCol(0, 0).gbc())
                                            .getParent()
                                    .addTextField("Label 5", GBC.init().rowCol(0, 1).gbc())
                                            .getParent()
                                    .getParent()
                            .addRowSeparator("line2", GBC.init().rowCol(3, 0).anchor(GridBagConstraints.SOUTHWEST).fill(GridBagConstraints.BOTH).stretch(1, 0).gbc())
                                    .getParent()
                            .addPanel("simpleDemo1Panel3", GBC.init().rowCol(4, 0).fill(GridBagConstraints.HORIZONTAL).stretch(1, 0).gbc(), new GridBagLayout())
                                    .addButton("button1", "Button 1", GBC.init().anchor(GridBagConstraints.EAST).stretch(1, 0).gbc())
                                            .getParent()
                                    .addButton("button2", "Button 2", GBC.init().anchor(GridBagConstraints.EAST).gbc())
                            .show();
        /* @formatter:on */
    }
}
