package com.BriteERP.tests;

import com.BriteERP.pages.CRMPage;
import com.BriteERP.pages.LoginPage;
import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 extends TestBase {

    @BeforeMethod
    public void setup2() {
        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.usernameConsole.sendKeys(ConfigurationReader.get("username"));
        loginPage.passwordConsole.sendKeys(ConfigurationReader.get("password"));
        loginPage.submitButton.click();
        //tests
    }

    @Test
    public void test1() {
        CRMPage crmPage = new CRMPage();
        // clicking on CRM Module PAge
        crmPage.CRMModuleTab.click();
        //choose pivot view
        crmPage.pivotView.click();
        //actions to choose opportunity view
        crmPage.closePivotCell.click();
        crmPage.openPivotCell.click();
        crmPage.opportunityButton.click();
        //store information from second row name and price
        String tableROwTwo = crmPage.tableRowTwoFirstValue.getText();
        String pivotViewPriceValue = crmPage.tableRowTwoPriceValue.getText();
        //change to List view
        crmPage.listView.click();

        // Assigning to String
        BrowserUtils.waitFor(3);
        String listViewPriceValue = crmPage.findValue(tableROwTwo);

        Assert.assertEquals(pivotViewPriceValue, listViewPriceValue);
    }

    @Test
    public void test2() {
        CRMPage crmPage = new CRMPage();
        // clicking on CRM Module PAge
        crmPage.CRMModuleTab.click();
        //choose pivot view
        crmPage.pivotView.click();
        //actions to choose opportunity view
        crmPage.closePivotCell.click();
        crmPage.openPivotCell.click();
        crmPage.opportunityButton.click();


        // store summary of all oportunities
        double sumOfOportunities = crmPage.addSum();

        double actualSum=Integer.parseInt(crmPage.sumAllOpportunitiresActual.getText().replace(",",""));

        Assert.assertEquals(sumOfOportunities,actualSum);

    }
}
