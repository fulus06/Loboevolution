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
package org.lobobrowser.html.layout;

import org.lobobrowser.html.control.CanvasControl;
import org.lobobrowser.html.control.RCanvasControl;
import org.lobobrowser.html.domimpl.HTMLCanvasElementImpl;
import org.lobobrowser.html.domimpl.HTMLElementImpl;
import org.lobobrowser.html.renderer.RBlockViewport;
import org.lobobrowser.html.renderer.RElement;
import org.lobobrowser.html.renderer.UIControl;

/**
 * The Class CanvasLayout.
 */
public class CanvasLayout extends CommonWidgetLayout {

	public CanvasLayout() {
		super(ADD_AS_BLOCK, true);
	}

	@Override
	protected RElement createRenderable(RBlockViewport bodyLayout, HTMLElementImpl markupElement) {
		UIControl control = new CanvasControl((HTMLCanvasElementImpl) markupElement);
		return new RCanvasControl(markupElement, control, bodyLayout.getContainer(), bodyLayout.getFrameContext(),
				bodyLayout.getUserAgentContext());
	}
}
