package br.com.rsinet.selenium_utils.utils.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsDriversUtils {
	public ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-first-run");
		options.addArguments("--no-check-default-driver");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--disable-infobars");
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-notifications");
		options.setExperimentalOption("useAutomationExtension", false);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.geolocation", 2);
		options.setExperimentalOption("prefs", prefs);
		return options;
	}

	public FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();

		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		profile.setPreference("network.proxy.type", 0);

		options.setCapability(FirefoxDriver.PROFILE, profile);
		return options;
	}
}