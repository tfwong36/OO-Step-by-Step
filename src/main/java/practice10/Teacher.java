package practice10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Teacher  extends Person {
    LinkedList<Klass> Classes = null;

    public LinkedList<Klass> getClasses() {
        return Classes;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> linkedList) {
        super(id, name, age);
        this.Classes = linkedList;
        for (Klass klass : this.Classes) {
            klass.setTeacher(this);
        }
    }
    public void printStudentBecomeLeader(Student student, int classNumber){
        System.out.printf("I am %s. I know %s become Leader of Class %d.\n", this.getName(), student.getName(), classNumber);
    }
    public void printStudentJoin(Student student, int classNumber){
        System.out.printf("I am %s. I know %s has joined Class %d.\n", this.getName(), student.getName(), classNumber);
    }
    public String introduce() {
        if (Classes != null){
            String teachingClass = "";
            for (Klass klass : this.Classes) {
                teachingClass += klass.getNumber() + ", ";
            }
            teachingClass = teachingClass.substring(0, teachingClass.length() - 2); //remove last two ', '
            return super.introduce() + " I am a Teacher. I teach Class " + teachingClass + ".";
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public String introduceWith(Student student) {
        boolean result = false;
        String outputString = super.introduce() + " I am a Teacher.";
        if (Classes != null) {
            if (this.isTeaching(student))
                return String.format(outputString + " I teach %s.", student.getName());
        }
        return String.format(outputString + " I don't teach %s.", student.getName());
    }

    public boolean isTeaching(Student student){
        if (Classes != null) {
            //#todo replace by stream api
            List<Integer> teachingClass = new ArrayList<>();
            for (Klass klass : this.Classes) {
                teachingClass.add(klass.getNumber());
            }
            return teachingClass.contains(student.getKlass().getNumber());
        }
        return false;
    }
}
