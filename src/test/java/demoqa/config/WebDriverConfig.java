package demoqa.config;

import org.aeonbits.owner.Config;

public interface WebDriverConfig extends Config{

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    String getRemoteUrl();

}
