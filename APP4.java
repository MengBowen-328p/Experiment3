import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class APP4 {

	static ArrayList<Student2> s = new ArrayList<Student2>(); // 静态化

	public static void main(String[] args) {
		try {
			System.out.println("-----学籍信息系统-----");
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(".//Files//obj.bat"));
			try {
				s = ((ArrayList<Student2>) in.readObject());
				System.out.println("Loading...");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			in.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (true) {
			menu();
			try {
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(".\\Files\\obj.bat"));
				out.writeObject(s);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void menu() {
		Scanner in = new Scanner(System.in);
		System.out.println("1:增加 " + "2:删除 " + "3:查找 " + "4:列出 " + "5.退出");
		System.out.println("输入数字选择操作:");
		int flag = Integer.parseInt(in.nextLine());
		// in.close();
		switch (flag) {
			case 1:
				add();
				break;
			case 2:
				rm();
				break;
			case 3:
				find();
				break;
			case 4:
				show();
				break;
			case 5:
				quit();
				break;
		}

	}

	public static void add() {
		Scanner in = new Scanner(System.in);
		Student2 s1 = new Student2();
		System.out.println("请输入姓名: ");
		s1.setName(in.nextLine());
		System.out.println("请输入年龄: ");
		s1.setAge(Integer.parseInt(in.nextLine()));
		System.out.println("请输入年级: ");
		s1.setGrade(Integer.parseInt(in.nextLine()));
		System.out.println("请输入性别:");
		s1.setSex(in.nextLine());
		System.out.println("请输入学号:");
		s1.setSerialID(in.nextLine());
		System.out.println("请输入生日:");
		s1.setBirthday(Integer.parseInt(in.nextLine()));
		s.add(s1);
		// in.close();
		System.out.println("完了");
	}

	public static void show() {
		System.out.println("当前记载了如下信息:");
		Student2[] s_all = new Student2[s.size()];
		s.toArray(s_all);
		for (Student2 s1 : s_all) {
			System.out.println(s1.toString());
		}
	}

	public static void quit() {
		System.out.println("溜了溜了");
		System.exit(0);
	}

	public static void find() {
		System.out.println("输入学号来索引:");
		byte[] temp = new byte[20];
		String name = "";
		try {
			System.in.read(temp);
			name = new String(temp);
		} catch (IOException e) {
		}
		Student2[] s_all = new Student2[s.size()];
		s.toArray(s_all);
		int flag = 0;		//轮询标志位
		for (Student2 s1 : s_all) {

			if (s1.getSerialID().trim().equals(name.trim())) {
				System.out.println(s1.toString());
				flag++;
			}
		}
		if (flag == 0){
			System.out.println("查无此人!");
		}
	}

	public static void rm() {
		System.out.println("输入学号用于踢人:");
		byte[] temp = new byte[20];
		String name = "";
		try {
			System.in.read(temp);
			name = new String(temp);
		} catch (IOException e) {
		}
		Student2[] s_all = new Student2[s.size()];
		s.toArray(s_all);
		for (Student2 s1 : s_all) {

			if (s1.getSerialID().trim().equals(name.trim())) {
				System.out.println(s.indexOf(s1));
				System.out.println(s1.toString());
				s.remove(s.indexOf(s1));
				System.out.println(s1.getName() + "被踢出数据库");
			}
		}
	}
}
