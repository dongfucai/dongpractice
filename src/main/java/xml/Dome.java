package xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2021/1/21 下午11:49
 * @Version 1.0
 **/
@Data
public class Dome {

    @JacksonXmlProperty(isAttribute = true)
    private String name;


    @JacksonXmlProperty(localName = "ROW")
    private List<Score> scoreList;


}
