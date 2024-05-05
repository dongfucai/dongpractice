package xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2021/1/21 下午10:44
 * @Version 1.0
 **/

@Data
public class Score {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(localName = "YUNWEN")
    private String yuwen;

    @JacksonXmlProperty(localName = "SHUXUE")
    private String shuxue;
}
