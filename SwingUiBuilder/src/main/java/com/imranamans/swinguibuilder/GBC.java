package com.imranamans.swinguibuilder;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/*
 * This class helps create GridBagConstraint objects.
 * The instance variables are set to the Default values of GridBagConstraint.
 * The constructor of this class initializes some of these variables to desired values.
 */
public class GBC {

	public static GBC init() {
		GBC gbc = new GBC();
		// Override defaults
		gbc.margin(3, 3, 5, 3);
		gbc.ipadx = 3;
		gbc.ipady = 3;
		return gbc;
	}

	public GBC rowCol(int row, int column) {
		this.gridx = column;
		this.gridy = row;
		return this;
	}

	public GBC widthHeight(int gridwidth, int gridheight) {
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
		return this;
	}

	public GBC margin(int top, int right, int bottom, int left) {
		// this.insets = new Insets(5, 5, 10, 5); // top, left, bottom, right
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}

	public GBC padding(int topBottom, int leftRight) {
		this.ipadx = topBottom;
		this.ipady = leftRight;
		return this;
	}

	public GBC stretch(double leftRight, double topBottom) {
		this.weightx = leftRight;
		this.weighty = topBottom;
		return this;
	}

	public GBC anchor(int compass) {
		this.anchor = compass;
		return this;
	}

	public GBC fill(int fill) {
		this.fill = fill;
		return this;
	}

	public GridBagConstraints gbc() {
		return new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, insets, ipadx, ipady);
	}

	// http://docstore.mik.ua/orelly/java/awt/ch07_07.htm
	/*
	 * The gridx and gridy variables specify the grid position where this
	 * component will be placed. (0,0) specifies the cell at the origin of the
	 * screen.
	 * 
	 * It isn't necessary to set gridx and gridy to a specific location; if you
	 * set these fields to RELATIVE (the default), the system calculates the
	 * location for you. According to the comments in the source code, if gridx
	 * is RELATIVE, the component appears to the right of the last component
	 * added to the layout. If gridy is RELATIVE, the component appears below
	 * the last component added to the layout. However, this is misleadingly
	 * simple. RELATIVE placement works best if you are adding components along
	 * a row or a column. In this case, there are four possibilities to
	 * consider:
	 * 
	 * gridx and gridy RELATIVE: components are placed in one row. gridx
	 * RELATIVE, gridy constant: components are placed in one row, each to the
	 * right of the previous component. gridx constant, gridy RELATIVE:
	 * components are placed in one column, each below the previous component.
	 * Varying gridx or gridy while setting the other field to RELATIVE appears
	 * to start a new row, placing the component as the first element in the
	 * row.
	 */
	// The component associated with this constraint will be positioned relative
	// to the last item added. If all components have gridx and gridy RELATIVE,
	// they will be placed in a single row.
	private int gridx = GridBagConstraints.RELATIVE;
	// The component associated with this constraint will be positioned relative
	// to the last item added.
	private int gridy = GridBagConstraints.RELATIVE;
	/*
	 * gridwidth and gridheight set the number of rows (gridwidth) and columns
	 * (gridheight) a particular component occupies. If gridwidth or gridheight
	 * is set to REMAINDER, the component will be the last element of the row or
	 * column occupying any space that's remaining. Table 7.2 shows the
	 * gridwidth and gridheight values for the screen in Figure 7.8. For the
	 * components in the last column, the gridwidth values could be REMAINDER.
	 * Likewise, gridheight could be set to REMAINDER for the components in the
	 * last row.
	 * 
	 * gridwidth and gridheight may also have the value RELATIVE, which forces
	 * the component to be the next to last component in the row or column.
	 * Looking back to Figure 7.8: if button six has a gridwidth of RELATIVE,
	 * button seven won't appear because button five is the last item in the
	 * row, and six is already next to last. If button five has a gridheight of
	 * RELATIVE, the layout manager will reserve space below it, so the button
	 * can be the next to last item in the column.
	 */
	// The component will occupy a single cell within the layout.
	private int gridwidth = 1;
	// The component will occupy a single cell within the layout.
	private int gridheight = 1;
	/*
	 * The weightx and weighty variables describe how to distribute any
	 * additional space within the container. They allow you to control how
	 * components grow (or shrink) when the user resizes the container. If
	 * weightx is 0, the component won't get any additional space available in
	 * its row. If one or more components in a row have weightx values greater
	 * than 0, any extra space is distributed proportionally between them. For
	 * example, if one component has a weightx value of 1 and the others are all
	 * 0, that one component will get all the additional space. If four
	 * components in a row each have weightx values of 1 and the other
	 * components have weightx values of 0, the four components each get one
	 * quarter of the additional space. weighty behaves similarly. Because
	 * weightx and weighty control the distribution of extra space in any row or
	 * column, setting either for one component may affect the position of other
	 * components.
	 */
	// The component will not get any extra space, if it is available.
	private double weightx = 0.0;
	// The component will not get any extra space, if it is available.
	private double weighty = 0.0;
	/*
	 * The anchor specifies the direction in which the component will drift in
	 * the event that it is smaller than the space available for it. CENTER is
	 * the default. Others available are NORTH, SOUTH, EAST, WEST, NORTHEAST,
	 * NORTHWEST, SOUTHEAST, and SOUTHWEST.
	 */
	// If the component is smaller than the space available, it will be centered
	// within its region.
	private int anchor = GridBagConstraints.CENTER;
	/*
	 * The value of fill controls the component's resize policy. If fill is NONE
	 * (the default), the layout manager tries to give the component its
	 * preferred size. If fill is VERTICAL, it resizes in height if additional
	 * space is available. If fill is HORIZONTAL, it resizes in width. If fill
	 * is BOTH, the layout manager takes advantage of all the space available in
	 * either direction.
	 */
	// The component should not resize itself if extra space is available within
	// its region.
	private int fill = GridBagConstraints.NONE;
	/*
	 * The insets field specifies the external padding in pixels around the
	 * component (i.e., between the component and the edge of the cell, or
	 * cells, allotted to it). An Insets object can specify different padding
	 * for the top, bottom, left, and right sides of the component.
	 */
	// No extra space is added around the edges of the component.
	private Insets insets = new Insets(0, 0, 0, 0); // top, left, bottom, right
	/*
	 * ipadx and ipady specify the internal padding within the component. ipadx
	 * specifies the extra space to the right and left of the component (so the
	 * minimum width increases by 2*ipadx pixels). ipady specifies the extra
	 * space above and below the component (so the minimum height increases by
	 * 2*ipady pixels).
	 * 
	 * The difference between insets (external padding) and the ipadx, ipady
	 * variables (internal padding) is confusing. The insets don't add space to
	 * the component itself; they are external to the component. ipadx and ipady
	 * change the component's minimum size, so they do add space to the
	 * component itself.
	 */
	// There is no internal padding for the component.
	private int ipadx = 0;
	// There is no internal padding for the component.
	private int ipady = 0;

}
