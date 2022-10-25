import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class APP1
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        try 
        (
        FileInputStream input = new FileInputStream(".\\Files\\pic.jpg");
        FileOutputStream output = new FileOutputStream(".\\Files\\pic_bak.jpg");
        )
        {
            byte[] b = new  byte[input.available()];
            output.write(b);
            System.out.println("文件已经复制");
        }
    }
}