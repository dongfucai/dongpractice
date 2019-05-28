package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年09月07日上午11:52
 * @Function : todo
 */
public class JacksonUtil {


    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER;

    private JacksonUtil() {
    }

    static {
        OBJECT_MAPPER = new ObjectMapper();
        //如果json中的key在目标对象中没有对应的setter方法, 是否抛出异常, 反序列化失败
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    /**
     * 将Json字符串转成JsonNode对象
     *
     * @param jsonStr 待转换的json字符串
     *
     * @return JsonNode对象 或 Null(转换失败时 或 字符串为空)
     *
     * @throws IOException
     */
    public static JsonNode toJsonNode(String jsonStr) throws IOException {
        if (StringUtils.isBlank(jsonStr)){
            return null;
        }

        return OBJECT_MAPPER.readTree(jsonStr);
    }

    /**
     * 获取JsonNode中key的textValue值
     *
     * @param node jsonNode
     * @param key 获取的值
     *
     * @return 串
     *
     * @throws IOException
     */
    public static String getTextValueWithDefault(JsonNode node, String key) throws IOException {
        if (StringUtils.isEmpty(key) || node == null) {
            return "";
        }
        return node.get(key) == null ? "" : node.get(key).textValue();
    }

    /**
     * 获取JsonNode中key的intValue值
     *
     * @param node jsonNode
     * @param key 获取的值
     *
     * @return int
     *
     * @throws IOException
     */
    public static int getIntValueWithDefault(JsonNode node, String key) throws IOException {
        if (StringUtils.isEmpty(key) || node == null) {
            return 0;
        }
        return node.get(key) == null ? 0 : node.get(key).intValue();
    }

    /**
     * 将对象转成Json格式字符串
     *
     * @param obj 待转换对象
     *
     * @return JSON字符串, 如果对象为null或转换异常则返回""
     */
    public static String toJsonStrWithEmptyDefault(Object obj) {
        String jsonStr = "";
        try {
            jsonStr = toJsonStr(obj);
        } catch (Exception e) {
            LOGGER.warn("将对象转成Json字符串抛出异常, obj: {}", jsonStr, obj, e);
        }

        return jsonStr;
    }

    /**
     * 将对象转成Json格式字符串
     *
     * @param obj 待转换对象
     *
     * @return JSON字符串, 如果对象为null则返回null
     *
     * @throws JsonProcessingException
     */
    public static String toJsonStr(Object obj) throws JsonProcessingException {
        if (obj == null) {
            return null;
        }

        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    /**
     * 将Json字符串转成指定类型的对象
     *
     * @param jsonStr     待转换的Json字符串
     * @param targetClass 目标类型
     *
     * @return 对象, 如果转换失败 或 字符串为空串 则返回null
     */
    public static <T> T toBeanWithNullDefault(String jsonStr, Class<T> targetClass) {
        T bean = null;
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }

        try {
            bean = toBean(jsonStr, targetClass);
        }
        catch (IOException e) {
            LOGGER.warn("将Json字符串转成对象抛出异常, JsonString: {} , targetClass: {}", jsonStr, targetClass, e);
        }

        return bean;
    }

    /**
     * 将Json字符串转成指定类型的对象
     *
     * @param jsonStr     Json字符串
     * @param targetClass 目标类型
     *
     * @return Java对象
     *
     * @throws IOException
     */
    public static <T> T toBean(String jsonStr, Class<T> targetClass) throws IOException {
        return OBJECT_MAPPER.readValue(jsonStr, targetClass);
    }

    /**
     * 将Json字符串转成包含指定类型元素的Set集合
     *
     * @param jsonStr   待转换的Json字符串
     * @param itemClass 要转换成的Set集合中元素的类型
     *
     * @return Json字符串为空时返回空的集合(size等于0, 不是null)
     *
     * @throws IOException
     */
    public static <T> Set<T> toSetWithEmptyDefault(String jsonStr, Class<T> itemClass) throws IOException {
        if (StringUtils.isBlank(jsonStr)) {
            return new HashSet<>(0);
        }

        return toSet(jsonStr, itemClass);
    }

    /**
     * 将Json字符串转成包含指定类型元素的Set集合
     *
     * @param jsonStr   待转换的Json字符串
     * @param itemClass 要转换成的Set集合中元素的类型
     *
     * @return 包含指定类型元素的Set集合
     *
     * @throws IOException
     */
    public static <T> Set<T> toSet(String jsonStr, Class<T> itemClass) throws IOException {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(Set.class, itemClass);
        return OBJECT_MAPPER.readValue(jsonStr, javaType);
    }

    /**
     * 将Json字符串转成包含指定类型元素的List集合
     *
     * @param jsonStr   待转换的Json字符串
     * @param itemClass 要转换成的List集合中元素的类型
     *
     * @return Json字符串为空时返回null
     *
     * @throws IOException
     */
    public static <T> List<T> toListWithEmptyDefault(String jsonStr, Class<T> itemClass) throws IOException {
        if (StringUtils.isBlank(jsonStr)) {
            return Lists.newArrayList();
        }

        return toList(jsonStr, itemClass);
    }

    /**
     * 将Json字符串转成包含指定类型元素的List集合
     *
     * @param jsonStr   待转换的Json字符串
     * @param itemClass 要转换成的List集合中元素的类型
     *
     * @return 包含指定类型元素的List集合
     *
     * @throws IOException
     */
    public static <T> List<T> toList(String jsonStr, Class<T> itemClass) throws IOException {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, itemClass);
        return OBJECT_MAPPER.readValue(jsonStr, javaType);
    }

    /**
     * 将Json字符串转成包含指定类型元素的Map
     *
     * @param jsonStr    待转换的Json字符串
     * @param keyClass   要转换成的Map中的Key的类型
     * @param valueClass 要转换成的Map中的Value的类型
     *
     * @return Json字符串为空时返回空的Map(不是null)
     *
     * @throws IOException
     */
    public static <K, V> Map<K, V> toMapWithEmptyDefault(String jsonStr, Class<K> keyClass, Class<V> valueClass) throws IOException {
        if (StringUtils.isBlank(jsonStr)) {
            return new HashMap<>(0);
        }

        return toMap(jsonStr, keyClass, valueClass);
    }

    /**
     * 将Json字符串转成包含指定类型元素的Map
     *
     * @param jsonStr    待转换的Json字符串
     * @param keyClass   要转换成的Map中的Key的类型
     * @param valueClass 要转换成的Map中的Value的类型
     *
     * @return 包含指定类型元素的Map
     *
     * @throws IOException
     */
    public static <K, V> Map<K, V> toMap(String jsonStr, Class<K> keyClass, Class<V> valueClass) throws IOException {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructMapType(Map.class, keyClass, valueClass);
        return OBJECT_MAPPER.readValue(jsonStr, javaType);
    }

    /**
     * 将Json字符串转成包含指定类型元素的ConcurrentHashMap
     *
     * @param jsonStr    待转换的Json字符串
     * @param keyClass   要转换成的Map中的Key的类型
     * @param valueClass 要转换成的Map中的Value的类型
     *
     * @return 包含指定类型元素的Map
     *
     * @throws IOException
     */
    public static <K, V> ConcurrentHashMap<K, V> toConcurrentMap(String jsonStr, Class<K> keyClass, Class<V> valueClass) throws IOException {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructMapType(ConcurrentHashMap.class, keyClass, valueClass);
        return OBJECT_MAPPER.readValue(jsonStr, javaType);
    }



    /**
     * 将Object对象为Json字符串
     *
     * @param object
     * @return
     */
    public static String getJsonStrByObject(Object object) {
        String jsonStr;
        try {
            jsonStr = OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception e) {
            jsonStr = "";
            LOGGER.error("[Jackson-String转换失败] param:{}", object);
            LOGGER.error("[Jackson-String转换失败] error:", e);
        }
        return jsonStr;
    }

    /**
     * 将Json字符串转成包含指定类型元素的ConcurrentHashMap, 且元素的value为List类型
     *
     * @param jsonStr    待转换的Json字符串
     * @param keyClass   要转换成的Map中的Key的类型
     * @param valueClass 要转换成的Map中的作为Value的list中元素的类型
     *
     * @return 包含指定类型元素的Map
     *
     * @throws IOException
     */
    public static <K, V> ConcurrentHashMap<K, List<V>> toConcurrentMapWithListValue(String jsonStr, Class<K> keyClass, Class<V> valueClass)
            throws IOException {
        JavaType keyJavaType = OBJECT_MAPPER.getTypeFactory().constructType(keyClass);
        JavaType valueJavaType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, valueClass);
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructMapType(ConcurrentHashMap.class, keyJavaType, valueJavaType);
        return OBJECT_MAPPER.readValue(jsonStr, javaType);
    }

    /**
     * 获取对象属性
     * <b>只获取儿子属性</b>
     *
     * @param jsonNode json对象
     * @param propName 属性名称
     *
     * @return null: 属性不存在 或 属性值为null
     *  <p>
     *  eg: <code>{a: "1", b: {a: "2", c: 3} }</code> 获取"a"返回"1", 获取"c"返回null
     */
    public static JsonNode getProp(JsonNode jsonNode, String propName) {
        if (jsonNode != null && StringUtils.isNotBlank(propName)) {
            JsonNode propNode = jsonNode.get(propName);
            if (propNode != null && !propNode.isNull()) {
                return propNode;
            }
        }

        return null;
    }

    /**
     * 获取对象属性, 并转换成指定类型
     *
     * @param jsonNode json对象
     * @param propName 属性名称
     * @param clazz    属性值要转成的类型, 可选值: Integer, Long, Float, Double, BigDecimal, String
     *
     * @return null: 属性不存在 或 属性值为null 或 转换失败
     */
    public static <T> T getProp(JsonNode jsonNode, String propName, Class<T> clazz) {
        JsonNode propNode = null;
        if (clazz == null || (propNode = getProp(jsonNode, propName)) == null) {
            return null;
        }

        // 转Boolean
        if (Objects.equals(Boolean.class, clazz)) {
            if (propNode.isBoolean()) {
                return (T) Boolean.valueOf(propNode.booleanValue());
            }
        }

        // 转Integer
        if (Objects.equals(Integer.class, clazz)) {
            if (propNode.canConvertToInt()) {
                return (T) Integer.valueOf(propNode.asInt());
            }

            try {
                return (T) Integer.valueOf(propNode.asText());
            }
            catch (Exception e) {
                return null;
            }
        }

        // 转Long
        if (Objects.equals(Long.class, clazz)) {
            if (propNode.canConvertToLong()) {
                return (T) Long.valueOf(propNode.asInt());
            }

            try {
                return (T) Long.valueOf(propNode.asText());
            }
            catch (Exception e) {
                return null;
            }
        }

        // 转Float
        if (Objects.equals(Float.class, clazz)) {
            if (propNode.isFloat()) {
                return (T) Float.valueOf(propNode.floatValue());
            }

            try {
                return (T) Float.valueOf(propNode.asText());
            }
            catch (Exception e) {
                return null;
            }
        }

        // 转Double
        if (Objects.equals(Double.class, clazz)) {
            if (propNode.isDouble()) {
                return (T) Double.valueOf(propNode.doubleValue());
            }
            try {
                return (T) Double.valueOf(propNode.asText());
            }
            catch (Exception e) {
                return null;
            }
        }

        // 转BigDecimal
        if (Objects.equals(BigDecimal.class, clazz)) {
            try {
                return (T) new BigDecimal(propNode.asText());
            }
            catch (Exception e) {
                return null;
            }
        }

        // 转String
        if (Objects.equals(String.class, clazz)) {
            return (T) propNode.asText();
        }

        return null;
    }

    /**
     * 获取对象的属性, 并转成指定类型, 如果属性为null则返回默认值
     *
     * @param jsonNode     json对象
     * @param propName     属性值
     * @param clazz        要转成的类型
     * @param defaultValue 默认值
     *
     * @return defaultValue: 属性不存在 或 属性值为null 或 转换失败
     */
    public static <T> T getProp(JsonNode jsonNode, String propName, Class<T> clazz, T defaultValue) {
        T propValue = getProp(jsonNode, propName, clazz);
        return propValue == null ? defaultValue : propValue;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> root = new HashMap<>();
        root.put("int", 123);
        root.put("intStr", "123");
        root.put("long", 321L);
        root.put("longStr", "321");
        root.put("float", 12.3F);
        root.put("floatStr", "12.3");
        root.put("double", 32.1D);
        root.put("doubleStr", "32.1");
        root.put("string", "this is a string");

        JsonNode jsonNode = toJsonNode(toJsonStr(root));

        System.out.println(getProp(jsonNode, "int", Integer.class));        // 123
        System.out.println(getProp(jsonNode, "intStr", Integer.class));     // 123
        System.out.println(getProp(jsonNode, "float", Integer.class));      // 12
        System.out.println(getProp(jsonNode, "floatStr", Integer.class));   // null
        System.out.println(getProp(jsonNode, "float", Float.class));        // 12.3
        System.out.println(getProp(jsonNode, "floatStr", Float.class));     // 12.3
        System.out.println(getProp(jsonNode, "float", BigDecimal.class));   // 12.3
        System.out.println(getProp(jsonNode, "floatStr", BigDecimal.class));// 12.3
    }


}
