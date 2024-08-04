package models;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "auth")
public class HabitMobileSettings {
    String apiId, apiToken;

    public HabitMobileSettings(String apiId, String apiToken) {
        this.apiId = apiId;
        this.apiToken = apiToken;
    }
}
