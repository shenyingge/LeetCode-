package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 提供输入方法
*/

public class InputUtils {
    public static Scanner getInput(InputStream inputStream){
        Scanner scanner = new Scanner(inputStream);
        return scanner;
    }
    public static Scanner getFileInput(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(new FileInputStream(file));
        return scanner;
    }
    public static Scanner getFileFromDesktop() throws FileNotFoundException {
        File file = new File("C:\\Users\\sheny\\Desktop\\in.txt");
        Scanner scanner = new Scanner(new FileInputStream(file));
        return scanner;
    }
}
