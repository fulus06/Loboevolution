/*
 * Copyright (C) 1999-2016 David Schweinsberg.  All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.steadystate.css.parser.selectors;

import java.io.Serializable;

import org.w3c.css.sac.DescendantSelector;
import org.w3c.css.sac.Selector;
import org.w3c.css.sac.SimpleSelector;

import com.steadystate.css.format.CSSFormat;
import com.steadystate.css.format.CSSFormatable;
import com.steadystate.css.parser.Locatable;
import com.steadystate.css.parser.LocatableImpl;

/**
 * @author <a href="mailto:davidsch@users.sourceforge.net">David Schweinsberg</a>
 * @author rbri
 */
public class ChildSelectorImpl extends LocatableImpl implements DescendantSelector, CSSFormatable, Serializable {

    private static final long serialVersionUID = -5843289529637921083L;

    private Selector ancestorSelector_;
    private SimpleSelector simpleSelector_;

    public void setAncestorSelector(final Selector ancestorSelector) {
        ancestorSelector_ = ancestorSelector;
        if (ancestorSelector instanceof Locatable) {
            setLocator(((Locatable) ancestorSelector).getLocator());
        }
        else if (ancestorSelector == null) {
            setLocator(null);
        }
    }

    public void setSimpleSelector(final SimpleSelector simpleSelector) {
        simpleSelector_ = simpleSelector;
    }

    public ChildSelectorImpl(final Selector parent, final SimpleSelector simpleSelector) {
        setAncestorSelector(parent);
        setSimpleSelector(simpleSelector);
    }

    public short getSelectorType() {
        return Selector.SAC_CHILD_SELECTOR;
    }

    public Selector getAncestorSelector() {
        return ancestorSelector_;
    }

    public SimpleSelector getSimpleSelector() {
        return simpleSelector_;
    }

    /**
     * {@inheritDoc}
     */
    public String getCssText(final CSSFormat format) {
        final StringBuilder sb = new StringBuilder();

        if (null != ancestorSelector_) {
            sb.append(((CSSFormatable) ancestorSelector_).getCssText(format));
        }

        sb.append(" > ");

        if (null != simpleSelector_) {
            sb.append(((CSSFormatable) simpleSelector_).getCssText(format));
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return getCssText(null);
    }
}
