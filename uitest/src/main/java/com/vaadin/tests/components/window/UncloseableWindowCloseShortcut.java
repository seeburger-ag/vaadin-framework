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
package com.vaadin.tests.components.window;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class UncloseableWindowCloseShortcut extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Window uncloseable = new Window("Uncloseable",
                new Label("Try and close me with esc"));
        uncloseable.setClosable(false);
        addWindow(uncloseable);

        uncloseable.center();
        uncloseable.focus();
    }

    @Override
    protected String getTestDescription() {
        return "An uncloseable Window should not be closed with esc key.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 19700;
    }

}
