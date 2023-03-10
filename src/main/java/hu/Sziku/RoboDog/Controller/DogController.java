package hu.Sziku.RoboDog.Controller;

import hu.Sziku.RoboDog.Model.Dog;
import hu.Sziku.RoboDog.Service.DogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@RequestMapping("dog")
public class DogController {

    private DogStorage dogStorage;
    @Autowired
    public DogController(DogStorage dogStorage) {
        this.dogStorage = dogStorage;

    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/alldogs")
    public String allStoredDog(Model model){
        dogStorage.addRandomDog();
        dogStorage.addRandomDog();
        dogStorage.addRandomDog();
        dogStorage.addRandomDog();
        dogStorage.addRandomDog();
        dogStorage.addRandomDog();
        dogStorage.addRandomDog();
        dogStorage.addRandomDog();

        model.addAttribute("dogs", dogStorage.getDogs());

        return "alldogs";
    }

    @GetMapping("/alldogslist")
    public List<Dog> allStoredDogList(){
        return dogStorage.getDogs();
    }

    @GetMapping("/randomdog")
    public Dog getRandomDog(){
        dogStorage.addRandomDog();
        return dogStorage.getDogs().get(dogStorage.getDogs().size()-1);
    }

    @PostMapping("/adddog")
    public String addDog(@RequestBody Dog dog){
        dogStorage.addDog(dog);
        return "OK:" + dogStorage.getDogs().get(dogStorage.getDogs().size()-1);
    }

    @PutMapping("/updatedog")
    public String editDog(@RequestBody Dog dog){
        dogStorage.updateDog(dog.getName(), dog.getAge(), dog.getBreed());
        return"OK:";
    }
}
