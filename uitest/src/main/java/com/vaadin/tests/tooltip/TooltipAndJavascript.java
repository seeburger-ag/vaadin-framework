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
package com.vaadin.tests.tooltip;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;

public class TooltipAndJavascript extends AbstractTestUI {

    @JavaScript("tooltipandjavascript.js")
    public static class MyButton extends Button {

    }

    @Override
    protected void setup(VaadinRequest request) {
        MyButton b = new MyButton();
        b.setCaption("Hover for tooltip");
        b.setDescription("Tooltip for the button");
        addComponent(b);
    }

    @Override
    protected String getTestDescription() {
        return "Hover the button for a tooltip. It should be styled correctly";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14028;
    }

}
