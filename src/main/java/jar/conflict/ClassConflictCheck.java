package jar.conflict;

import java.io.File;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2020/11/17 下午9:56
 * @Version 1.0
 **/

public class ClassConflictCheck {


    private static Map<String, HashSet<String>> classMap = new HashMap<String, HashSet<String>>();

    public static void check(String classPath) throws Exception {
        File dir = new File(classPath);
        File[] jarFiles = dir.listFiles();
        for (File jarFile : jarFiles) {
            if (jarFile.getName().endsWith(".jar")) {
                JarFile jar = new JarFile(jarFile);
                Enumeration<JarEntry> enumeration = jar.entries();
                while (enumeration.hasMoreElements()) {
                    JarEntry jarEntry = enumeration.nextElement();
                    if (jarEntry.getName().endsWith(".class")) {
                        storeClassAndJarRel(jarEntry.getName(), jar.getName());
                    }
                }
            }
        }
    }

    private static void storeClassAndJarRel(String className, String jarName) {
        HashSet<String> jarSet = classMap.get(className);
        if (jarSet == null) {
            jarSet = new HashSet<String>();
        }
        jarSet.add(jarName.substring(jarName.lastIndexOf("/") + 1));
        classMap.put(className, jarSet);
    }


    public static void main(String[] args) throws Exception {
        //args = new String[] { "/Users/yuekuo/soft/taobao-tomcat-7.0.54.1/deploy/cloud-mobile-cloudapi-gateway/WEB-INF/lib" };

        args = new String[] {"/Users/dongfucai/Downloads/code/csc-pacific/csc-pacific-portal-web/target/csc-pacific-portal-web-1.0-SNAPSHOT/WEB-INF/lib"};
        for (String arg : args) {
            check(arg);
        }

        boolean isConflict = false;
        for (Iterator<Map.Entry<String, HashSet<String>>> iterator = classMap.entrySet().iterator(); iterator
                .hasNext();) {
            Map.Entry<String, HashSet<String>> entry = iterator.next();
            HashSet<String> jarSet = entry.getValue();
            if (jarSet.size() > 1) {
                if (!isConflict) {
                    isConflict = true;
                }
                List<String> jarList = Arrays.asList(jarSet.toArray(new String[] {}));
                System.out.println("Class conflict!!! the class :" + entry.getKey()
                        + " has been duplicate inclusioned in the jars : " + jarList);
            }
        }

        if(!isConflict) {
            System.out.println("oh,good! there are no class conflict in the jars");
        }
    }



}
