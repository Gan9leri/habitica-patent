package api.models;

import lombok.Data;

@Data
public class NotAuthRequestBodyModel {
    Boolean success;
    String error;
    String message;
}
