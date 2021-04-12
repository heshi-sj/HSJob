package server;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassLoader extends ClassLoader{

    protected Class<?> findClass(String name, String servlet){
        byte[] datas = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(name);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int b = 0;
            while((b=fis.read()) != -1){
                bos.write(b);
            }
            datas = bos.toByteArray();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return defineClass(servlet,datas,0,datas.length);
    }
}
