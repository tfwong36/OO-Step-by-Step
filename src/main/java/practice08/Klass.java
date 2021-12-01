package practice08;
import java.util.*;

public class Klass {
    private int number;
    private Student leader;
    private final List<Student> members= new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public Student getLeader() {
        return leader;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName(){
        return "Class " + this.number;
    }

    public void assignLeader(Student student){
        if (!members.contains(student))
            System.out.printf("It is not one of us.\n");
        else
            this.leader = student;
    }

    public void appendMember(Student student){
        if (!members.contains(student))
            members.add(student);
    }
}
