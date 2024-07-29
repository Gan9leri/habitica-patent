package data;
import com.github.javafaker.Faker;

public class DataGeneration {

    Faker faker = new Faker();
    public String message = faker.name().firstName();
    public String task = faker.job().keySkills();

}
