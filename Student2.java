import java.io.Serializable;

public class Student2 implements Serializable {
	private String name;
	private int age;
	private int grade;
	private String sex;
	private int serialID;
	private int birthday;

	public Student2(String name, int age, int grade, String sex, int serialID, int birthday) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public int getGrade() {
		return this.grade;
	}

	public Student2() {

	}

	public String toString() {
		return name + " " + age + " " + grade;
	}

}
