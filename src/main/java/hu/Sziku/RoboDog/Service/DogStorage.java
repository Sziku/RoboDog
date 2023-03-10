package hu.Sziku.RoboDog.Service;

import hu.Sziku.RoboDog.Model.Breed;
import hu.Sziku.RoboDog.Model.Dog;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class DogStorage {
    private List<Dog> dogs = new ArrayList<>(){{
        add(new Dog(0,"teszt",Breed.AFRICANHAIRLESSDOG));
    }};
    private DogCreator dogCreator;

    @Autowired
    public DogStorage(DogCreator dogCreator) {
        this.dogCreator = dogCreator;
    }

    public void addDog(Dog dog){
        dogs.add(dog);
    }

    public void addRandomDog(){
        dogs.add(dogCreator.createRandomDog());
    }

    public void updateDog(String name, int age, Breed breed){
        dogs.stream()
                .filter(dog -> dog.getName().equals(name))
                .findFirst()
                .ifPresent(dog -> {dog.setAge(age); dog.setBreed(breed);});
    }


}
