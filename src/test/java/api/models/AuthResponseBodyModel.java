package api.models;

import lombok.Data;

@Data
public class AuthResponseBodyModel {
    Boolean success;
    UserData data;
    String appVersion;

    @Data
    public static class UserData {
        String id, apiToken;
        Boolean newUser;
        String username;
    }
}
