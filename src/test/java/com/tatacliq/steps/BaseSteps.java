package com.tatacliq.steps;

import com.tatacliq.pages.android.AndroidFilterPage;
import com.tatacliq.pages.android.AndroidHomePage;
import com.tatacliq.pages.android.AndroidLoginPage;
import com.tatacliq.pages.android.AndroidProductPage;
import com.tatacliq.pages.web.WebHomePage;
import com.tatacliq.pages.web.WebLoginPage;
import com.tatacliq.pages.web.WebProductPage;
import com.tatacliq.utils.ConfigurationManager;

public class BaseSteps {
    AndroidFilterPage filterPage;
    WebProductPage productPage;
    AndroidProductPage productPage;
    BaseSteps(){
        if(ConfigurationManager.getConfigValues("application.type").equals("web")) {
            productPage = new WebProductPage();

        }
        else{
            productPage = new AndroidFilterPage();
        }
    }
}
