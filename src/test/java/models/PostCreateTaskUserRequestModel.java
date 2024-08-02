package models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCreateTaskUserRequestModel {
    private String type;
    private String text;
    private String _id;
    private String notes;
    private ArrayList<Object> tags;
    private Integer value;
    private Integer priority;
    private Challenge challenge;
    private Group group;
    private ArrayList<Object> reminders;
    private String attribute;
    private Date createdAt;
    private Date updatedAt;
    private Boolean completed;
    private Boolean collapseChecklist;
    private ArrayList<Object> checklist;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Challenge{
        private String shortName;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Group{
        private Approval approval;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Approval{
            private Boolean required;
            private Boolean approved;
            private Boolean requested;
        }
    }
}
