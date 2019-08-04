package other.javabasice.class_loader;

import java.io.*;

/**
 * @author yuan
 * @date 2019/3/18
 * @description 自定义ClassLoader
 */
public class MyClassLoader extends ClassLoader {
    private String path;
    private String classLoaderName;


    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    /**
     * 寻找类文件
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        return super.findClass(name);
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    /**
     * 加载类文件
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        name = path + name + ".class";
        try (FileInputStream in = new FileInputStream(new File(name));
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int i = 0;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            return out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
