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
package com.vaadin.tests.widgetset.client.grid;

import com.vaadin.shared.communication.ClientRpc;
import com.vaadin.tests.widgetset.client.grid.GridClientColumnRendererConnector.Renderers;

public interface GridClientColumnRendererRpc extends ClientRpc {

    /**
     * Adds a new column with a specific renderer to the grid
     *
     */
    void addColumn(Renderers renderer);

    /**
     * Detaches and attaches the client side Grid
     */
    void detachAttach();

    /**
     * Used for client-side sorting API test
     */
    void triggerClientSorting();

    /**
     * @since
     */
    void triggerClientSortingTest();

    /**
     * @since
     */
    void shuffle();
}
