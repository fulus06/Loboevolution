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
package org.lobobrowser.html.style;

/**
 * Additional state that may be set during rendering to override state
 * determined from elements.
 */
public class RenderThreadState {

	/** The Constant stateTL. */
	private static final ThreadLocal<RenderThreadState> stateTL = new ThreadLocal<RenderThreadState>();

	/** The override no wrap. */
	public boolean overrideNoWrap;

	/**
	 * Instantiates a new render thread state.
	 */
	private RenderThreadState() {
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public static RenderThreadState getState() {
		RenderThreadState ts = stateTL.get();
		if (ts == null) {
			ts = new RenderThreadState();
			stateTL.set(ts);
		}
		return ts;
	}
}
