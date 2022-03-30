package demoqa.config;


import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:property/user.properties"
)
public interface AuthConfig extends Config {
    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();
}
