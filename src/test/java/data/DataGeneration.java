package data;
import com.github.javafaker.Faker;

import java.util.UUID;

public class DataGeneration {

    Faker faker = new Faker();
    public String message = faker.name().firstName();
    public String task = faker.job().keySkills();
    public String taskName = faker.funnyName().name();
    public String taskId = UUID.randomUUID().toString();

}
