package hu.Sziku.RoboDog.Model;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Dog {
    private int age;
    private String name;
    private Breed breed;
}
