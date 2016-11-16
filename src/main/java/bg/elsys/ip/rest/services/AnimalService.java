package bg.elsys.ip.rest.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import bg.elsys.ip.rest.data.AnimalRepository;
import bg.elsys.ip.rest.models.Animal;

public class AnimalService {

	private AnimalRepository animalRepository = AnimalRepository.getInstance();
	
	public List<Animal> getAnimals(int page) {
		int pageSize = 10;

		List<Animal> animals = animalRepository.all()
				.stream()
				.skip((page - 1) * pageSize)
				.limit(pageSize)
				.collect(Collectors.toList());
		
		return Collections.unmodifiableList(animals);
	}

	public Animal addAnimal(String species, int numberOfLegs, String color, int age) {
		Animal animal = new Animal(-1, species, numberOfLegs, color, age);
		return animalRepository.add(animal);
	}
}
