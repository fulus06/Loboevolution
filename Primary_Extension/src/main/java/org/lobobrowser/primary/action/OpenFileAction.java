/*
    GNU GENERAL LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 - 2016 Lobo Evolution

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    verion 2 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General License for more details.

    You should have received a copy of the GNU General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */
package org.lobobrowser.primary.action;

import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;

import org.lobobrowser.primary.ext.ActionPool;
import org.lobobrowser.primary.ext.ComponentSource;
import org.lobobrowser.primary.settings.ToolsSettings;
import org.lobobrowser.ua.NavigatorWindow;
import org.lobobrowser.ua.RequestType;

/**
 * The Class OpenFileAction.
 */
public class OpenFileAction extends ActionPool {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The component source. */
	private ComponentSource componentSource;

	/** The window. */
	private NavigatorWindow window;

	/**
	 * Instantiates a new open file action.
	 *
	 * @param componentSource
	 *            the component source
	 * @param window
	 *            the window
	 */
	public OpenFileAction(ComponentSource componentSource, NavigatorWindow window) {
		super(componentSource, window);
		this.componentSource = componentSource;
		this.window = window;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		ToolsSettings settings = ToolsSettings.getInstance();
		java.io.File directory = settings.getOpenFileDirectory();
		if (directory != null) {
			fileChooser.setSelectedFile(directory);
		}
		int returnValue = fileChooser.showOpenDialog(window.getTopFrame().getComponent());
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			java.io.File selectedFile = fileChooser.getSelectedFile();
			componentSource.navigate(selectedFile.toURI().toString(), RequestType.PROGRAMMATIC);
			settings.setOpenFileDirectory(selectedFile);
			settings.save();
		}
	}

}
