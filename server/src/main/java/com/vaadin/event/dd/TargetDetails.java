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
package com.vaadin.event.dd;

import java.io.Serializable;

import com.vaadin.ui.Tree.TreeTargetDetails;

/**
 * TargetDetails wraps drop target related information about
 * {@link DragAndDropEvent}.
 * <p>
 * When a TargetDetails object is used in {@link DropHandler} it is often
 * preferable to cast the TargetDetails to an implementation provided by
 * DropTarget like {@link TreeTargetDetails}. They often provide a better typed,
 * drop target specific API.
 *
 * @since 6.3
 *
 */
public interface TargetDetails extends Serializable {

    /**
     * Gets target data associated with the given string key
     *
     * @param key
     * @return The data associated with the key
     */
    public Object getData(String key);

    /**
     * @return the drop target on which the {@link DragAndDropEvent} happened.
     */
    public DropTarget getTarget();

}
