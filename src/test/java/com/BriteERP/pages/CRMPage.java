package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMPage {
    public CRMPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[@class='oe_menu_text' and contains(text(),'CRM')]")
    public WebElement CRMModuleTab;

    @FindBy(css = "button[data-view-type='pivot']")
    public WebElement pivotView;

    @FindBy(xpath = "//td[@class='o_pivot_header_cell_opened']")
    public WebElement closePivotCell;

    @FindBy(xpath = "//td[@class='o_pivot_header_cell_closed']")
    public WebElement openPivotCell;

    @FindBy(linkText = "Opportunity")
    public WebElement opportunityButton;

    @FindBy(xpath = "//table/tbody/tr[3]/td[1]")
    public WebElement tableRowTwoFirstValue;

    @FindBy(xpath = "//table/tbody/tr[3]/td[2]")
    public WebElement tableRowTwoPriceValue;

    @FindBy(css = "button[data-view-type='list']")
    public WebElement listView;

    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    public  WebElement sumAllOpportunitiresActual;



    public int getNumberOfRows() {
        return Driver.get().findElements(By.cssSelector("tbody tr")).size();
    }

    public String findValue(String value) {
        CRMPage crmPage = new CRMPage();
        String listViewPriceValue = "";
        for (int a = 1; a < getNumberOfRows(); a++) {
            if (Driver.get().findElement(By.xpath("//table/tbody/tr[" + a + "]/td[3]")).getText().equals(value)) {
                listViewPriceValue = Driver.get().findElement(By.xpath("//table/tbody/tr[" + a + "]/td[9]")).getText();
            }
        }
        return listViewPriceValue;
    }

    public double addSum() {
        CRMPage crmPage = new CRMPage();
        double sum = 0.0;
        for (int i = 2; i <= getNumberOfRows(); i++) {
            double num = Integer.parseInt(Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText());
            sum += num;
        }
        return sum;
    }
}
