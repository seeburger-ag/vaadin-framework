package com.vaadin.tests.components.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.TableElement;
import com.vaadin.testbench.elementsbase.ServerClass;

@ServerClass("com.vaadin.ui.Table")
public class CustomTableElement extends TableElement {

    public CollapseMenu openCollapseMenu() {
        getCollapseMenuToggle().click();
        WebElement cm = getDriver()
                .findElement(By.xpath("//*[@id='PID_VAADIN_CM']"));
        return wrapElement(cm, getCommandExecutor()).wrap(CollapseMenu.class);
    }

    public static class CollapseMenu extends TableElement.ContextMenuElement {
    }

    public WebElement getCollapseMenuToggle() {
        return findElement(By.className("v-table-column-selector"));
    }
}
