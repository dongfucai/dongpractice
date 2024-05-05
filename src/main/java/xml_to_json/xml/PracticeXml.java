//package xml_to_json.xml;
//
//import ch.qos.logback.core.joran.spi.XMLUtil;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.dom4j.io.OutputFormat;
//import org.dom4j.io.SAXReader;
//import org.dom4j.io.XMLWriter;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * @Author dongfucai/1766318593@qq.com
// * @Description //TODO
// * @Date 2019/8/20 下午5:02
// * @Version 1.0
// **/
//
//public class PracticeXml {
//
//
//    public static Document readXmlDocument(String filePath) throws Exception{
//
//        InputStream in = null;
//        Document doc = null;
//
//        // 解析xml文档内容
//        try {
//            SAXReader reader = new SAXReader();
//            //in = XMLUtil.class.getClassLoader().getResourceAsStream(filePath);// 获取到xml文件
//            in = new FileInputStream(new File(filePath));
//            doc = reader.read(in);
//        } catch (Exception e) {
//
//            System.out.println(e.getMessage());
//            return null;
//        } finally {
//            //close(null,null,in);
//            in.close();
//        }
//        return doc;
//    }
//
//    public static List<Element> readXml(String filePath) throws Exception{
//
//        List<Element> elementList = null;
//        InputStream in = null;
//        String module_id = "1";
//        // 解析xml文档内容
//        try {
//            SAXReader reader = new SAXReader();
//            //in = XMLUtil.class.getClassLoader().getResourceAsStream(filePath);// 获取到xml文件
//
//            in = new FileInputStream(new File(filePath));
//            Document doc = reader.read(in);
//
//
//            Element root = doc.getRootElement();
//            elementList = root.elements();
//            System.out.println("XMLUtil.readXml root name:" + root.getName());
//
//            if (elementList != null) {
//                for (Element ele : elementList) {
//
//                    String index = ele.attributeValue("id");
//
//                    if (module_id.equals(index)) {
//
//                        List<Element> userList = ele.elements();
//
//                        if (userList != null && userList.size() > 0) {
//                            for (Element user : userList) {
//
//                                HashMap<String, String> hashMap = new HashMap<String, String>();
//
//                                Element name = user.element("name");
//                                Element password = user.element("password");
//
//                                String nameValue = name.getText();
//                                String passwordValue = password.getText();
//
//                                hashMap.put("name", nameValue);
//                                hashMap.put("password", passwordValue);
//
//                                //users.add(hashMap);
//                            }
//                        }
//
//                        //logger.debug("XMLFileServiceImpl.readUserDotXML Element module_id:" + module_id + ",users size:" + users.size());
//                        break;
//                    }
//                }
//            }
//
//
//        } catch (Exception e) {
//            System.out.println("XMLUtil.readXml error: "+ e);
//            return null;
//        } finally {
//            //close(null,null,in);
//            in.close();
//
//        }
//        return elementList;
//    }
//
//
//    public boolean createUserDotXML(String path,String type) throws Exception{
//
//        boolean writen = true;
//        OutputStream outputStream = null;
//        XMLWriter xmlWriter = null;
//        Document document = null;
//
//        String rootPath = "/Users/dongfucai/Downloads/code/dongpractice/src/main/java/xml_to_json/xml";
//
//        try {
//            document = DocumentHelper.createDocument();
//            Element new_root_node = DocumentHelper.createElement(type);
//            Element new_module_1_node = DocumentHelper.createElement("module");
//
//            new_module_1_node.addAttribute("id","1");
//            new_root_node.add(new_module_1_node);
//            document.add(new_root_node);
//
//            OutputFormat outputFormat = new OutputFormat();
//            outputFormat.setEncoding("UTF-8");
//
//            outputStream = new FileOutputStream(rootPath);
//            xmlWriter = new XMLWriter(outputStream,outputFormat);
//
//            xmlWriter.write(document);
//
//        } catch (IOException e){
//            //logger.error("ConfigFileServiceImpl.createServerDotXML error: "+ e);
//            return false;
//        } catch (Exception e){
//            //logger.error("ConfigFileServiceImpl.createServerDotXML error: "+ e);
//            return false;
//        } finally {
//            outputStream.close();
//            xmlWriter.close();
//            //XMLUtil.close(xmlWriter,outputStream,null);
//        }
//
//        return writen;
//    }
//
//    public boolean writeUserDotXML(String path, String module_id, String userName, String passWord) {
//
//        boolean writen = true;
//        OutputStream outputStream = null;
//        XMLWriter xmlWriter = null;
//        Document document;
//
//        String rootPath = "/Users/dongfucai/Downloads/code/dongpractice/src/main/java/xml_to_json/xml";
//
//        try {
//            document = XMLUtil.readXmlDocument(rootPath);
//            if (document != null) {
//                Element root = document.getRootElement();
//                List<Element> elementList = root.elements();
//
//                for (Element ele : elementList) {
//
//                    String id = ele.attributeValue("id");
//                    if (id.equals(module_id)) {
//
//                        List<Element> userList = ele.elements();
//
//                        if (userList != null && userList.size() > 0) {
//
//                            // 进行比对，是否已存在数据
//                            for (Element user : userList) {
//
//                                Element name = user.element("name");
//                                String nameValue = name.getText();
//
//                                if (nameValue.equals(userName)) {
//                                    writen = false;
//                                    break;
//                                }
//                            }
//
//                            // 有需求才新增
//                            if (writen) {
//
//                                Element new_user_node = DocumentHelper.createElement("user");
//                                Element new_name_node = DocumentHelper.createElement("name");
//                                Element new_pass_node = DocumentHelper.createElement("password");
//                                Element new_date_node = DocumentHelper.createElement("date");
//
//                                new_name_node.setText(userName);
//                                new_pass_node.setText(passWord);
//                                new_date_node.setText(DateUtil.getCurrentDataString());
//                                new_user_node.addAttribute("index", userList.size() + 1 + "");
//
//                                new_user_node.add(new_name_node);
//                                new_user_node.add(new_pass_node);
//                                new_user_node.add(new_date_node);
//
//                                ele.add(new_user_node);
//                            }
//                        } else {
//
//                            Element new_user_node = DocumentHelper.createElement("user");
//                            Element new_name_node = DocumentHelper.createElement("name");
//                            Element new_pass_node = DocumentHelper.createElement("password");
//                            Element new_date_node = DocumentHelper.createElement("date");
//
//                            new_name_node.setText(userName);
//                            new_pass_node.setText(passWord);
//                            new_date_node.setText(DateUtil.getCurrentDataString());
//                            new_user_node.addAttribute("index", "1");
//
//                            new_user_node.add(new_name_node);
//                            new_user_node.add(new_pass_node);
//                            new_user_node.add(new_date_node);
//
//                            ele.add(new_user_node);
//                        }
//                        break;
//                    }
//                }
//            }
//
//            if (writen){
//                OutputFormat outputFormat = new OutputFormat();
//                outputFormat.setEncoding("UTF-8");
//
//                outputStream = new FileOutputStream(rootPath);
//                xmlWriter = new XMLWriter(outputStream,outputFormat);
//
//                xmlWriter.write(document);
//            }
//        } catch (IOException e){
//            logger.error("XMLFileServiceImpl.writeChangeDotXML error: "+ e);
//        } catch (Exception e){
//            logger.error("XMLFileServiceImpl.writeChangeDotXML error: "+ e);
//        } finally {
//            XMLUtil.close(xmlWriter,outputStream,null);
//        }
//
//        return writen;
//    }
//
//
//    public static void main(String[] args) throws Exception{
//
//
//        String filePath = "/Users/dongfucai/Downloads/code/dongpractice/src/main/java/xml_to_json/xml/xml";
//        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<users>\n" +
//                "    <module id=\"1\">\n" +
//                "        <user index=\"1\">\n" +
//                "            <name>tom</name>\n" +
//                "            <password>12345</password>\n" +
//                "            <date>20150526</date>\n" +
//                "        </user>\n" +
//                "        <user index=\"2\">\n" +
//                "            <name>jack</name>\n" +
//                "            <password>5%</password>\n" +
//                "            <date>20150526</date>\n" +
//                "        </user>\n" +
//                "        <user index=\"3\">\n" +
//                "            <name>john</name>\n" +
//                "            <password>5%</password>\n" +
//                "            <date>20150526</date>\n" +
//                "        </user>\n" +
//                "    </module>\n" +
//                "</users>";
//
//        readXml(filePath);
//
//    }
//}
