package ba.bitcamp.gui;

import javax.swing.DefaultListSelectionModel;

public class SelectionModel extends DefaultListSelectionModel{
	private static final long serialVersionUID = -5545004606202168782L;
	@Override
	public void setSelectionInterval(int index0, int index1) {
		if (index0 == index1) {
			if (isSelectedIndex(index0)) {
				removeSelectionInterval(index0, index0);
				return;
			}
		}
		super.setSelectionInterval(index0, index1);
	}
	@Override
	public void addSelectionInterval(int index0, int index1) {
		if (index0 == index1) {
			if (isSelectedIndex(index0)) {
				removeSelectionInterval(index0, index0);
				return;
			}
			super.addSelectionInterval(index0, index1);
		}
	}

}
