/*
 * Copyright 2000-2020 Vaadin Ltd.
 *
 * Licensed under the Commercial Vaadin Developer License version 4.0 (CVDLv4); 
 * you may not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 * https://vaadin.com/license/cvdl-4.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.client.ui.popupview;

import com.google.gwt.event.shared.GwtEvent;

public class VisibilityChangeEvent extends GwtEvent<VisibilityChangeHandler> {

    private static Type<VisibilityChangeHandler> TYPE;

    private boolean visible;

    public VisibilityChangeEvent(final boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public Type<VisibilityChangeHandler> getAssociatedType() {
        return getType();
    }

    public static Type<VisibilityChangeHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<VisibilityChangeHandler>();
        }
        return TYPE;
    }

    @Override
    protected void dispatch(final VisibilityChangeHandler handler) {
        handler.onVisibilityChange(this);
    }
}
