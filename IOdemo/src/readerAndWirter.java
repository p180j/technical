import java.io.*;

/**
 * @author pengjw
 * @date 2019年12月20日 10:59
 * @description 字符流
 * @Version 1.0
 */

public class readerAndWirter {

    public static void main(String[] args) throws  IOException{
        fileReader();
    }
    /**
     * @Description 写入文本txt OutputStreamWriter
     * @Date 2019/12/20 11:25
     */
    public static void outputStreamWriterTtx() throws  IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/IO/outputStreamWriteTtx.txt"));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"gbk");
        outputStreamWriter.write("这是第一行");
        outputStreamWriter.append("这是追加的呢");
        outputStreamWriter.close();
    }

    /**
     * @Description 读取 InputStreamReader
     * @Date 2019/12/20 11:25
     */
    public static void inputStreamReaderTtx() throws  IOException{
        FileInputStream fileInputStream = new FileInputStream(new File("E:/IO/outputStreamWriteTtx.txt"));
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println("str=" + str);
        }
    }

    /**
    * @Description fileWriter 写文本
    * @Date 2019/12/20 15:03
    */
    public static void fileWriter() throws  IOException{
        FileWriter fileWriter = new FileWriter(new File("E:/IO/fileWriter.txt"));
        fileWriter.write("这是fileWriter 写的第一行");
        fileWriter.append("这是追加的哦");
        fileWriter.close();
    }

    /**
     * @Description fileWriter 写文本
     * @Date 2019/12/20 15:03
     */
    public static void fileReader() throws  IOException{
        FileReader fileReader = new FileReader(new File("E:/IO/fileWriter.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = bufferedReader.readLine()) != null) {
            sb.append(str);
        }
        System.out.println(sb);
    }
}
