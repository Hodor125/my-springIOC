package org.springframework.container;

import org.springframework.xml.SpringConfigPaser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hodor007
 * @date ：Created in 2021/2/7
 * @description ：
 * @version: 1.0
 */
public class ClassPathXmlApplicationContext {
    //传入配置文件名
    private String springConfig;

    private List<String> classPathes = new ArrayList<>();

    public ClassPathXmlApplicationContext(String springConfig) {
        this.springConfig = springConfig;
        init();
    }

    private void init() {
        String basePackage = SpringConfigPaser.getBasePackage(springConfig);
        System.out.println("component-scan<=======>" + basePackage);
        loadClasses(basePackage);
    }

    /**
     * 获取需要扫描的包的文件路径
     * @param basePackage
     */
    private void loadClasses(String basePackage) {
        //扫描con.hodor下的包
        //将.替换为\
        basePackage = basePackage.replace(".", File.separator);
        System.out.println("replace<========>" + basePackage);
        URL url = ClassPathXmlApplicationContext.class.getResource("");
        String replace_url = url.toString().replace("file:/", "");
//        System.out.println("replace url<=======>" + replace_url);
        int index = replace_url.lastIndexOf("/classes");
        //裁取正确的文件路径
        File file = new File(replace_url.substring(0, index + 8), basePackage);
        System.out.println("file<=========>" + file);
        findAllClasses(file);
    }

    /**
     * 扫描文件路径下所有的class文件，输出文件的全路径，需要进行替换才能用于反射创建对象
     * 将类的全路径存入集合中
     */
    private void findAllClasses(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isDirectory()) {
                findAllClasses(f);
            } else {
                String path = f.getPath();
                if(path.endsWith(".class")) {
                    int index1 = path.lastIndexOf("\\classes");
                    int index2 = path.lastIndexOf(".class");
                    path = path.substring(index1 + 9, index2).replace("\\", ".");
                    classPathes.add(path);
                    //得到类的路径，用于反射创建对象
//                    System.out.println(path);
                }
            }
        }

        //拿到文件的路径    E:\code\git\my-springIOC\target\classes\com\hodor\service\impl\OrderServiceImpl.class
        //通过反射创建类    只需要com后面的路径，类似于com.hodor.service.impl.OrderServiceImpl
    }
}
