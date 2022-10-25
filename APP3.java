import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class APP3 {
  static int Num = 100;

  public static void main(String[] args) throws Exception {
    DataOutputStream dos = null;
    File f = new File(".//Files//score.dat");
    dos = new DataOutputStream(new FileOutputStream(f));
    int num[] = new int[Num];
    for (int i = 0; i < num.length; i++) {
      double d = Math.random();
      int t = (int) (d * 100);
      dos.writeChar(t);
    }
    dos.close();

    DataInputStream dis = null;
    dis = new DataInputStream(new FileInputStream(f));

    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();

    int t[] = new int[Num];
    int len = 0;
    int c = 0;
    int flag = 0;
    while (true) {
      c = dis.readChar();
      t[len] = c;
      System.out.print(t[len] + "\t");
      if (len == t.length - 1) break;
      len++;

      // 制表
      flag++;
      flag %= 10;
      if (flag == 0) System.out.println();
    }
    System.out.println("\n第" + n + "个数为" + t[n - 1]);
  }
}