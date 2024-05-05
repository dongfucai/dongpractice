package xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2021/1/21 下午10:32
 * @Version 1.0
 **/
@Data
@JacksonXmlRootElement(localName = "stream")
public class Students {

    @JacksonXmlProperty(isAttribute = true)
    private String Id;

    @JacksonXmlCData
    private String name;

    private String age;
//
//    @JacksonXmlElementWrapper(localName = "LIST", namespace = "aaaaaa", useWrapping = false)
//    @JacksonXmlProperty(localName = "ROW")
//    private List<Score> list;

   @JacksonXmlProperty(localName = "LIST")
    private Dome dome;

}
