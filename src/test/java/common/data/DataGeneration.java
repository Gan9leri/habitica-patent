package common.data;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.UUID;

@Data
public class DataGeneration {
    Faker faker = new Faker();
    private String message = faker.name().firstName();
    private String task = faker.job().keySkills();
    private String taskId = UUID.randomUUID().toString();
}
