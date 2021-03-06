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
package com.vaadin.shared;

import java.io.Serializable;

public interface EventId extends Serializable {
    public static final String BLUR = "blur";
    public static final String FOCUS = "focus";
    public static final String CLICK_EVENT_IDENTIFIER = "click";
    public static final String LAYOUT_CLICK_EVENT_IDENTIFIER = "lClick";
    public static final String POLL = "poll";
    public static final String CHANGE = "change";
    public static final String CONTEXT_CLICK = "cClick";
}
