package practice09;

public class Person {
    private String name;
    private int age;
    private int id;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String introduce(){
        return String.format("My name is %s. I am %d years old.", name, age);
    }
}
