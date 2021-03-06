/*
    GNU GENERAL LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 - 2016 Lobo Evolution

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    verion 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General License for more details.

    You should have received a copy of the GNU General Public
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */
/*
 * Created on Oct 9, 2005
 */
package org.lobobrowser.html.js;

import java.util.Collection;
import java.util.Iterator;

import org.lobobrowser.html.domfilter.ObjectFilter;
import org.lobobrowser.js.AbstractScriptableDelegate;

/**
 * The Class FilteredObjectList.
 */
public class FilteredObjectList extends AbstractScriptableDelegate {

	/** The source node list. */
	private final Collection sourceNodeList;

	/** The filter. */
	private final ObjectFilter filter;

	/** The lock. */
	private final Object lock;

	/**
	 * Instantiates a new filtered object list.
	 *
	 * @param filter
	 *            the filter
	 * @param list
	 *            the list
	 * @param lock
	 *            the lock
	 */
	public FilteredObjectList(ObjectFilter filter, Collection list, Object lock) {
		super();
		this.filter = filter;
		sourceNodeList = list;
		this.lock = lock;
	}

	/**
	 * Item.
	 *
	 * @param index
	 *            the index
	 * @return the object
	 */
	public Object item(int index) {
		synchronized (this.lock) {
			int count = 0;
			Iterator i = this.sourceNodeList.iterator();
			while (i.hasNext()) {
				Object node = i.next();
				if (this.filter.accept(node)) {
					if (count == index) {
						return node;
					}
					count++;
				}
			}
			return null;
		}
	}

	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public int getLength() {
		synchronized (this.lock) {
			int count = 0;
			Iterator i = this.sourceNodeList.iterator();
			while (i.hasNext()) {
				Object node = i.next();
				if (this.filter.accept(node)) {
					count++;
				}
			}
			return count;
		}
	}
}
