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
package com.vaadin.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.impl.DOMImplStandard;
import com.vaadin.client.event.PointerEvent.EventType;

/**
 * Pointer event support class for IE 11+ (unprefixed pointer events)
 *
 * @since 7.2
 * @author Vaadin Ltd
 */

public class PointerEventSupportImplModernIE extends PointerEventSupportImpl {

    protected static boolean inited = false;

    @Override
    protected boolean isSupported() {
        return true;
    }

    @Override
    protected void init() {
        if (!inited) {
            JavaScriptObject eventDispatcherMapExtensions = JavaScriptObject
                    .createObject();
            JavaScriptObject captureEventDispatcherMapExtensions = JavaScriptObject
                    .createObject();
            for (EventType e : EventType.values()) {
                addEventDispatcher(e.getNativeEventName(),
                        eventDispatcherMapExtensions);
                getPointerEventCaptureDispatchers(e.getNativeEventName(),
                        captureEventDispatcherMapExtensions);
            }
            DOMImplStandard
                    .addBitlessEventDispatchers(eventDispatcherMapExtensions);
            DOMImplStandard.addCaptureEventDispatchers(
                    captureEventDispatcherMapExtensions);

            inited = true;
        }
    }

    private static native void addEventDispatcher(String eventName,
            JavaScriptObject jso)
    /*-{
        jso[eventName] = @com.google.gwt.user.client.impl.DOMImplStandard::dispatchEvent(*);
    }-*/;

    private static native void getPointerEventCaptureDispatchers(
            String eventName, JavaScriptObject jso)
    /*-{
        jso[eventName] = @com.google.gwt.user.client.impl.DOMImplStandard::dispatchCapturedMouseEvent(*);
    }-*/;

}
