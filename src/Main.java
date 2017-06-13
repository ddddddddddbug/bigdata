import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PhoneNumber phoneNumber1 = new PhoneNumber(200, 311,400);
        PhoneNumber phoneNumberClone = null;
        Person person1 = new Person("kavin");
        phoneNumber1.setPerson(person1);
        try {
            phoneNumberClone = phoneNumber1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("clone之后phonenumber是否相等："
            +(phoneNumberClone == phoneNumber1));
        System.out.println("clone后的电话号码是："+phoneNumberClone.getAreaCode()+""
            +phoneNumberClone.getPrefix()+phoneNumberClone.getLineNumber());
        System.out.println("深拷贝之后的person是否相等:"
            +(phoneNumber1.getPerson() == phoneNumberClone.getPerson()));
        System.out.println("clone之后的PhoneNumber的person的name是："
            +phoneNumberClone.getPerson().getName());
    }

}

class PhoneNumber implements  Cloneable{
    private int areaCode;
    private int prefix;
    private int lineNumber;
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    PhoneNumber(int areaCode, int prefix, int lineNumber){
        this.areaCode =  areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }
    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }


    @Override
    protected PhoneNumber clone() throws CloneNotSupportedException {
        PhoneNumber result = (PhoneNumber) super.clone();
        result.person = new Person(result.person.getName());
        return result;
    }
}

class Person{
    private String name;
    Person(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}