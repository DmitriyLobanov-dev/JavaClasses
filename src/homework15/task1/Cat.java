package homework15.task1;

import java.util.Objects;

public final class Cat {

    private final String eyesColor;
    private final String breed;

    public Cat(String eyesColor, String breed) {
        this.eyesColor = eyesColor;
        this.breed = breed;
    }

    public String getEyes() {
        return eyesColor;
    }

    public Cat setEyes(String eyesColor) {
        return new Cat(eyesColor, this.breed);
    }

    public String getBreed() {
        return breed;
    }

    public Cat setBreed(String breed) {
        return new Cat(this.eyesColor, breed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(eyesColor, cat.eyesColor) &&
                Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eyesColor, breed);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "eyes='" + eyesColor + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
