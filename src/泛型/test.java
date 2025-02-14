package 泛型;

class Animal {}
class Dog extends Animal {}

class Generic<T> {}

public class test {
    public static void main(String[] args) {
        Generic<Animal> animalContainer = new Generic<>();
        Generic<Dog> dogContainer = new Generic<>();

        // 编译错误！Generic<Dog> 不能赋值给 Generic<Animal>
        // animalContainer = dogContainer;
    }
}

