import java.io.Serializable;

public class Students implements Serializable {
	private String name;
	private int age;
	private int grade;
	private String sex;
	private String serialID;
	private int birthday;

	public Students(String name, int age, int grade, String sex, String serialID, int birthday) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.sex = sex;
		this.serialID = serialID;
		this.birthday = birthday;
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

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setSerialID(String serialID) {
		this.serialID = serialID;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
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

	public String getSex() {
		return this.sex;
	}

	public String getSerialID() {
		return this.serialID;
	}

	public int getBirthday() {
		return this.birthday;
	}

	public Students() {

	}

	public String toString() {
		return "姓名:" + name + " " + "年龄:" + age + " " + "年级:" + grade + " " + "性别:" + sex + " " + "ID:" + serialID + " "
				+ "生日:" + birthday;
	}

}
