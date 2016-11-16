package bg.elsys.ip.rest.data;

import java.util.ArrayList;
import java.util.List;

import bg.elsys.ip.rest.models.Animal;
import bg.elsys.ip.rest.services.AnimalService;

public class AnimalRepository {

    private static final AnimalRepository instance = new AnimalRepository();
	private List<Animal> animals = new ArrayList<>();
	private int id = 0;

	private void Seed() {
		for (int i = 1; i < 20; i++) {
			animals.add(new Animal(getNextId(), "Cat", 4, "Black", 2 * i));
			if (i % 3 == 0) {
				animals.add(new Animal(getNextId(), "Spider", 8, "Dark gray", 1 * i));
			}
			
			if (i % 2 == 0) {
				animals.add(new Animal(getNextId(), "Dog", 2, "Orange", 12 * i));
			}

			animals.add(new Animal(getNextId(), "Worm", 0, "Pink", 1 * i));
			animals.add(new Animal(getNextId(), "Whale", 0, "Blue", 7 * i));
		}
	}
	
	private AnimalRepository() {
		Seed();
	}
	
	public List<Animal> all() {
		return animals;
	}
	
	public Animal add(Animal animal) {
		animal.setId(getNextId());
		animals.add(animal);
		return animal;
	}

	public int getNextId() {
		return ++id;
	}
	
	public static AnimalRepository getInstance() {
        return instance;
	}
	
}
