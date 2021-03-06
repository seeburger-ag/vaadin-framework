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
package com.vaadin.tests.components.splitpanel;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.AbstractSplitPanel;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalSplitPanel;

/**
 * Test UI for duplicate primary style name in SplitPanel.
 *
 * @author Vaadin Ltd
 */
public class SplitPanelDuplicateStyleName extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        addSplitPanel(true);
        addSplitPanel(false);
    }

    private void addSplitPanel(final boolean horizontal) {
        AbstractSplitPanel splitPanel;
        if (horizontal) {
            splitPanel = new HorizontalSplitPanel();
        } else {
            splitPanel = new VerticalSplitPanel();
        }
        splitPanel.setWidth("200px");
        splitPanel.setHeight("200px");
        addComponent(splitPanel);
    }

    @Override
    protected String getTestDescription() {
        return "SplitPanel should not have duplicate primary style name";
    }

    @Override
    protected Integer getTicketNumber() {
        return 17846;
    }

}
