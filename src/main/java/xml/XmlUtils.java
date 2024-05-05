package xml;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.util.Strings;
import util.JacksonUtil;

import java.util.List;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2021/1/21 下午10:24
 * @Version 1.0
 **/

public class XmlUtils {


    private static XmlMapper xmlMapper;

    static{
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        xmlMapper = new XmlMapper(module);

        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        xmlMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

       // xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        //xmlMapper.setSerializationInclusion(Include.NON_DEFAULT);
       // xmlMapper.setSerializationInclusion(Include.ALWAYS);

        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    /**
     * Object to XML
     * @param object
     * @param rootName
     * @return
     */
    public static String toXml(Object object) {
        try {
            return xmlMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * XML to Object
     * @param xmlStr
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> T fromXml(String xmlStr, Class<T> clazz) throws Exception{
        if(Strings.isNotBlank(xmlStr)){
            return xmlMapper.readValue(xmlStr, clazz);
        }
        return null;
    }


    public static void main(String[] args) throws Exception{

        String head = "<?xml version='1.0' encoding='GBK'?>";

        Students s = new Students();

        s.setId("2323");
        s.setName("董付财dongfucai");



        Score score = new Score();
        score.setShuxue("1111");
        score.setId("1");
        Score score1 = new Score();
        score1.setShuxue("222");
        score1.setId("2");

        List list = Lists.newArrayList();
        list.add(score);
        list.add(score1);

        Dome dome = new Dome();
        dome.setName("WECHATLIST");
        dome.setScoreList(list);
        s.setDome(dome);





        System.out.println(JacksonUtil.toJsonStrWithEmptyDefault(s));
        System.out.println(XmlUtils.toXml(s));


        Students students = XmlUtils.fromXml(head + XmlUtils.toXml(s), Students.class);
        System.out.println(JacksonUtil.toJsonStrWithEmptyDefault(students));







    }


}
