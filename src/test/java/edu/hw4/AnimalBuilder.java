package edu.hw4;

public class AnimalBuilder {
    private AnimalBuilder() {
    }

    public static Animal createAnimalByHeight(int height) {
        return new Animal("Sasha", Animal.Type.DOG, Animal.Sex.F, 20, height, 50, false);
    }

    public static Animal createAnimalByHeightBites(int height, boolean bites) {
        return new Animal("Sasha", Animal.Type.DOG, Animal.Sex.F, 20, height, 50, bites);
    }

    public static Animal createAnimalByTypeBites(Animal.Type type, boolean bites) {
        return new Animal("Sasha", type, Animal.Sex.F, 20, 170, 50, bites);
    }

    public static Animal createAnimalByWeight(int weight) {
        return new Animal("Sasha", Animal.Type.DOG, Animal.Sex.F, 20, 170, weight, false);
    }

    public static Animal createAnimalByType(Animal.Type type) {
        return new Animal("Sasha", type, Animal.Sex.F, 20, 170, 50, false);
    }

    public static Animal createAnimalByWeightType(int weight, Animal.Type type) {
        return new Animal("Sasha", type, Animal.Sex.F, 20, 170, weight, false);
    }

    public static Animal createAnimalByWeightTypeAge(int weight, Animal.Type type, int age) {
        return new Animal("Sasha", type, Animal.Sex.F, age, 170, weight, false);
    }

    public static Animal createAnimalByHeightType(int height, Animal.Type type) {
        return new Animal("Sasha", type, Animal.Sex.F, 20, height, 50, false);
    }

    public static Animal createAnimalByWeightHeight(int weight, int height) {
        return new Animal("Sasha", Animal.Type.DOG, Animal.Sex.F, 20, height, weight, false);
    }

    public static Animal createAnimalByName(String name) {
        return new Animal(name, Animal.Type.DOG, Animal.Sex.F, 20, 170, 50, false);
    }

    public static Animal createAnimalByTypeNameSex(Animal.Type type, String name, Animal.Sex sex) {
        return new Animal(name, type, sex, 20, 170, 50, false);
    }

    public static Animal createAnimalBySex(Animal.Sex sex) {
        return new Animal("Sasha", Animal.Type.DOG, sex, 20, 170, 50, false);
    }

    public static Animal createAnimalByAge(int age) {
        return new Animal("Sasha", Animal.Type.DOG, Animal.Sex.F, age, 170, 50, false);
    }

    public static Animal createAnimalByAgeType(int age, Animal.Type type) {
        return new Animal("Sasha", type, Animal.Sex.F, age, 170, 50, false);
    }
}

