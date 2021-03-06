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

import com.vaadin.client.connectors.AbstractRendererConnector;
import com.vaadin.client.renderers.Renderer;
import com.vaadin.client.widget.grid.RendererCellReference;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.widgetset.client.SimpleTestBean;

@Connect(com.vaadin.tests.components.grid.BeanRenderer.class)
public class PojoRendererConnector
        extends AbstractRendererConnector<SimpleTestBean> {

    public static class BeanRenderer implements Renderer<SimpleTestBean> {
        @Override
        public void render(RendererCellReference cell, SimpleTestBean bean) {
            cell.getElement().setInnerText(bean.toString());
        }
    }

    @Override
    public BeanRenderer getRenderer() {
        return (BeanRenderer) super.getRenderer();
    }
}
