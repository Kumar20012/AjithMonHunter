package com.tatacliq.pages.web;

import com.tatacliq.utils.ConfigurationManager;

public class WebWelcomePage extends WebBasePage {

    public void openApplication() {
        driver.get(ConfigurationManager.getConfigValues("application.url"));
    }
}
