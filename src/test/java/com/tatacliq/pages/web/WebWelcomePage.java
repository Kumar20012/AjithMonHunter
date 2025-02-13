package com.tatacliq.pages.web;

public class WebWelcomePage extends {
    public void openApplication() {
        driver.get(ConfigurationManager.getConfigValues("application.url"));
    }
}
