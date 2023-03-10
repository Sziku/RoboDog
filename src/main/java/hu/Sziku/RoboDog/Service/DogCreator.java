package hu.Sziku.RoboDog.Service;

import com.github.javafaker.Faker;
import hu.Sziku.RoboDog.Model.Breed;
import hu.Sziku.RoboDog.Model.Dog;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DogCreator {

    final int DOGMAXLIVESPANYEARS = 13;
    public Dog createRandomDog(){
        return new Dog(randomAge(), randomName(), randomBreed());
    }

    private int randomAge(){
        return randomInt(DOGMAXLIVESPANYEARS);
    }

    private int randomInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max + 1);
    }

    private String randomName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    private Breed randomBreed(){
        List<Breed> breeds = List.of(Breed.values());
        return breeds.get(randomInt(breeds.size()-1));
    }
}
