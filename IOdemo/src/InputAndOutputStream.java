import java.io.*;

/**
 * @author pengjw
 * @date 2019年12月20日 10:58
 * @description 字节流
 * @Version 1.0
 */

public class InputAndOutputStream {
    public static void main(String[] args) throws IOException {
        //二进制写入(直接打开会出现乱码)
        // outputStreamWriteTtxByte();
        //二进制读取
        //inputStream();
        //outputStreamWriteTtx();
        inputStreamReadTXT();

    }
    /**
     * @Description 写入二进制
     * @Date 2019/12/20 11:15
     */
    public static void outputStreamWriteBinary( ) throws IOException {
        byte[] bytes = {12,21,34,11,21};
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\IO\\FileOutputStreamBinary.txt"));
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }
    /**
     * @Description 读取二进制
     * @Date 2019/12/20 11:16
     */
    public static  void inputStreamReadBinary() throws IOException{
        FileInputStream fileInputStream = new FileInputStream(new File("E:/IO/FileOutputStreamBinary.txt"));
        int c = 0;
        while ((c = fileInputStream.read()) != -1) {
            System.out.println(c);
        }
    }

    public static void outputStreamWriteTtx( ) throws IOException {
        String content = "我是皮皮虾";
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\IO\\FileOutputStreamTXT.txt"));
        fileOutputStream.write(content.getBytes());
        fileOutputStream.close();
    }


    public static  void inputStreamReadTXT() throws IOException{
        FileInputStream fileInputStream = new FileInputStream(new File("E:/IO/FileOutputStreamTXT.txt"));
        byte[] car = new byte[1024];
        int len; // 接收 实际读取大小
        StringBuilder sb = new StringBuilder();
        while ((len = fileInputStream.read(car)) != -1) {
            String info = new String(car, 0, len);
            sb.append(info);
        }
        System.out.println(sb);
    }
}
