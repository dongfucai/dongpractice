package random.test.read_file;

import com.google.common.collect.Lists;
import random.test.dto.ReadDataObject;

import java.io.File;
import java.util.List;
import java.util.Random;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2020/11/12 上午10:19
 * @Version 1.0
 **/

public class ReadFileHandler {

    static private Random random = new Random(100);

    static public List<ReadDataObject> readGetData(File file) {

        List<ReadDataObject> readDataObjects = Lists.newArrayList();


        for (int i = 0; i < 10; i++) {
            ReadDataObject  readDataObject = new ReadDataObject();
            List list = Lists.newArrayList();

            for (int j = 0; j < 10; j++) {
                list.add(Math.abs(random.nextInt()) % 1000);
            }
            readDataObject.setReadData(list);
            readDataObjects.add(readDataObject);
        }

        System.out.println(readDataObjects.size());

        return readDataObjects;
    }
}
