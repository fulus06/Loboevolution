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

package org.lobobrowser.w3c;


/**
 * The Interface ObjectArray.
 *
 * @param <E> the element type
 */
public interface ObjectArray<E> {
	
	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	int getLength();

	/**
	 * Sets the length.
	 *
	 * @param length
	 *            the new length
	 */
	void setLength(int length);

	/**
	 * Gets the element.
	 *
	 * @param index the index
	 * @return the element
	 */
	E getElement(int index);

	/**
	 * Sets the element.
	 *
	 * @param index the index
	 * @param value the value
	 */
	void setElement(int index, E value);
}
