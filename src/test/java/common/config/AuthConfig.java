package common.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {
    String login();

    String password();

    String browserstackUser();

    String browserstackKey();
}
