import java.io.*;

/**
 * @author pengjw
 * @date 2019年12月20日 11:42
 * @description 复制文件、
 * @Version 1.0
 */

public class CopyFile {
    public static void main(String[] args) {

    }
    //复制文件
    public static void copyFile() throws IOException {
        // 输入和输出都使用缓冲流
        FileInputStream in = new FileInputStream("E:\\视频资料\\大数据原理与应用\\1.1大数据时代.mp4");
        BufferedInputStream inBuffer = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream("1.1大数据时代.mp4");
        BufferedOutputStream outBuffer = new BufferedOutputStream(out);
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len = inBuffer.read(bs)) != -1) {
            outBuffer.write(bs, 0, len);
        }
        System.out.println("复制文件所需的时间：" + (System.currentTimeMillis() - begin)); // 平均时间约 200 多毫秒
        inBuffer.close();
        in.close();
        outBuffer.close();
        out.close();
    }
}
