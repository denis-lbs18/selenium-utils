package br.com.denisluna.selenium_utils.utils.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

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

	public InternetExplorerOptions getInternetExplorerOptions() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
		options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		options.setCapability("nativeEvents", false);
		options.setCapability("disabled-popup-blocking", true);
		options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		options.setCapability("acceptSslCerts", true);

		return options;
	}
}