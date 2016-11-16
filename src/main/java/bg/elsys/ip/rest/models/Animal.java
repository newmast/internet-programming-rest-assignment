package bg.elsys.ip.rest.models;

import io.swagger.annotations.ApiModelProperty;

public class Animal {

	@ApiModelProperty(required = true)
	private int id;
	
	@ApiModelProperty
	private String species;
	
	@ApiModelProperty
	private int numberOfLegs;
	
	@ApiModelProperty
	private String color;
	
	@ApiModelProperty
	private int age;
	
	public Animal() {
	}

	public Animal(int id, String species, int numberOfLegs, String color, int age) {
		super();
		this.id = id;
		this.species = species;
		this.numberOfLegs = numberOfLegs;
		this.color = color;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
