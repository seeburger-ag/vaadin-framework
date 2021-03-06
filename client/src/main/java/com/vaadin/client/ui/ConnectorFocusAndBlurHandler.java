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
package com.vaadin.client.ui;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.EventHelper;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.communication.StateChangeEvent.StateChangeHandler;
import com.vaadin.shared.EventId;
import com.vaadin.shared.communication.FieldRpc.FocusAndBlurServerRpc;

/**
 * A handler for focus and blur events which uses {@link FocusAndBlurServerRpc}
 * to transmit received events to the server. Events are only handled if there
 * is a corresponding listener on the server side.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public class ConnectorFocusAndBlurHandler
        implements StateChangeHandler, FocusHandler, BlurHandler {

    private final AbstractComponentConnector connector;
    private final Widget widget;
    private HandlerRegistration focusRegistration = null;
    private HandlerRegistration blurRegistration = null;

    public static void addHandlers(AbstractComponentConnector connector) {
        addHandlers(connector, connector.getWidget());
    }

    public static void addHandlers(AbstractComponentConnector connector,
            Widget widget) {
        connector.addStateChangeHandler("registeredEventListeners",
                new ConnectorFocusAndBlurHandler(connector, widget));
    }

    private ConnectorFocusAndBlurHandler(AbstractComponentConnector connector,
            Widget widget) {
        this.connector = connector;
        this.widget = widget;
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        focusRegistration = EventHelper.updateHandler(connector, this,
                EventId.FOCUS, focusRegistration, FocusEvent.getType(), widget);
        blurRegistration = EventHelper.updateHandler(connector, this,
                EventId.BLUR, blurRegistration, BlurEvent.getType(), widget);
    }

    @Override
    public void onFocus(FocusEvent event) {
        // updateHandler ensures that this is called only when
        // there is a listener on the server side
        getRpc().focus();
    }

    @Override
    public void onBlur(BlurEvent event) {
        // updateHandler ensures that this is called only when
        // there is a listener on the server side
        getRpc().blur();
    }

    private FocusAndBlurServerRpc getRpc() {
        return connector.getRpcProxy(FocusAndBlurServerRpc.class);
    }
}
