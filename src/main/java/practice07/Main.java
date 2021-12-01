package practice07;

public class Main {
    public static void main(String args[]){
        Klass klass;
        klass = new Klass(2);
        Student tom = new Student(1, "Tom", 21, klass);
        tom.introduce();
    }
}
