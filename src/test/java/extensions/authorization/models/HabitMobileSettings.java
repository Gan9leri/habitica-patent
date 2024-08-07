package extensions.authorization.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonRootName;

@Data
@JsonRootName(value = "auth")
@AllArgsConstructor
public class HabitMobileSettings {
    String apiId, apiToken;
}
