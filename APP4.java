import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class APP4 {
	
	static ArrayList<Student2> s = new ArrayList<Student2>();   //静态化
	
	public static void main(String[] args) {
		try {
			System.out.println("-----学籍信息系统-----");
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("obj.bat"));
			try {
				s = ((ArrayList<Student2>)in.readObject());
				System.out.println("Loading...");
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			in.close();
		} catch (FileNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		while(true) {
			choose() ;
			try {
				ObjectOutputStream out = new ObjectOutputStream(
							new FileOutputStream("obj.bat"));
				out.writeObject(s);
				out.close();
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	public static void choose() {
			Scanner in = new Scanner(System.in);
            System.out.println("1:增 " + "2:删 " + "\n" + "3:查 " + "4:退" );
            int flag = Integer.parseInt(in.nextLine());
            //in.close();
            switch(flag) {
            case 1 : add(); break ;
            case 2 : rm(); break ;
            case 3 : show(); break ;
            case 4 : quit(); break ;
            }
         
	}
	
	public static void add() {
		Scanner in = new Scanner(System.in);
		Student2 s1 = new Student2();
		System.out.println("请输入姓名: ");
		s1.setName( in.nextLine() );
		System.out.println("请输入年龄: ");
		s1.setAge(Integer.parseInt(in.nextLine()));
		System.out.println("请输入年级: ");
		s1.setGrade(Integer.parseInt(in.nextLine())) ;
		s.add(s1);
		//in.close();
		System.out.println("over");
	}
	
	public static void show() {
		Student2 [] s_all = new Student2[s.size()] ;
		s.toArray(s_all);
		for(Student2 s1 : s_all) {
			System.out.println(s1.toString());
		}
	}
	
	public static void quit() {
		System.out.println("溜了溜了");
		System.exit(0);
	}
	
	public static void rm() {
		byte [] temp = new byte[20];
		String name = "";
		try {
			System.in.read(temp);
			name = new String(temp);
		}catch(IOException e) {
		}
		Student2 [] s_all = new Student2[s.size()];
		s.toArray(s_all);
		for(Student2 s1 : s_all) {
			
			if(s1.getName().trim().equals(name.trim())) {
				System.out.println(s.indexOf(s1));
				s.remove(s.indexOf(s1));
				System.out.println(s1.getName()+"被踢出数据库");
			}
		}
	}
}
