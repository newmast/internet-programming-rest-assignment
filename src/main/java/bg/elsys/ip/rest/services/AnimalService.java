package bg.elsys.ip.rest.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import bg.elsys.ip.rest.data.AnimalRepository;
import bg.elsys.ip.rest.models.Animal;

public class AnimalService {

	private AnimalRepository animalRepository = AnimalRepository.getInstance();
	
	public List<Animal> getAnimals(int page, String species, String numberOfLegs, String color, String age) {
		int pageSize = 10;

		List<Animal> animals = animalRepository.all()
				.stream()
				.filter(animal -> {
					if (species != null) {
						return (animal.getSpecies().toLowerCase().contains(species.toLowerCase()));
					}
					
					return true;
				})
				.filter(animal -> {
					if (numberOfLegs != null) {
						return (animal.getNumberOfLegs() == Integer.parseInt(numberOfLegs));
					}
					
					return true;
				})
				.filter(animal -> {
					if (color != null) {
						return (animal.getColor().toLowerCase().contains(color.toLowerCase()));
					}
					
					return true;
				})
				.filter(animal -> {
					if (age != null) {
						return (animal.getAge() == Integer.parseInt(age));
					}
					
					return true;
				})
				.skip((page - 1) * pageSize)
				.limit(pageSize)
				.collect(Collectors.toList());
		
		return Collections.unmodifiableList(animals);
	}
	
	public List<String> getSpeciesNames() {
		List<String> names = animalRepository.all()
				.stream()
				.map(animal -> animal.getSpecies())
				.distinct()
				.collect(Collectors.toList());
		
		return Collections.unmodifiableList(names);
	}

	public Animal addAnimal(String species, int numberOfLegs, String color, int age) {
		Animal animal = new Animal(-1, species, numberOfLegs, color, age);
		return animalRepository.add(animal);
	}
}
