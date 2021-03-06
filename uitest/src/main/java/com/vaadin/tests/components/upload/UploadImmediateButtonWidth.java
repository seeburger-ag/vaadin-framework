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
package com.vaadin.tests.components.upload;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

// We're explicitly testing only immediate uploads here because non-immediate
// width issues still require planning before we can provide a fix.
public class UploadImmediateButtonWidth extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {

        // Let's use a separate layout without margins to make the
        // button widths not dependent on the selected theme.
        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("500px");

        layout.addComponent(getImmediateUpload("upload1", "300px"));
        layout.addComponent(getImmediateUpload("upload2", "50%"));
        layout.addComponent(getImmediateUpload("upload3", ""));

        addComponent(layout);
    }

    private Upload getImmediateUpload(String id, String width) {
        Upload upload = new Upload();

        upload.setId(id);
        upload.setWidth(width);
        upload.setImmediate(true);

        return upload;
    }

    @Override
    protected String getTestDescription() {
        return "Width of the upload button should obey setWidth() when using immediate";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14485;
    }

}
