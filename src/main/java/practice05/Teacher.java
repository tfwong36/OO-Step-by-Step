package practice05;

public class Teacher extends Person{
    private Integer klass = null;

    public int getKlass() {
        return klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    @Override
    public String introduce(){
        String outputString = super.introduce() + " I am a Teacher. I teach Class ";
        return  this.klass != null? outputString + klass + "." : outputString + " No Class." ;
    }
}
