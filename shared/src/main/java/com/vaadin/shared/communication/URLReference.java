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
package com.vaadin.shared.communication;

import java.io.Serializable;

public class URLReference implements Serializable {

    private String URL;

    /**
     * Returns the URL that this object refers to.
     * <p>
     * Note that the URL can use special protocols like theme://
     *
     * @return The URL for this reference or null if unknown.
     */
    public String getURL() {
        return URL;
    }

    /**
     * Sets the URL that this object refers to
     *
     * @param URL
     */
    public void setURL(String URL) {
        this.URL = URL;
    }
}
