package com.Utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * json 操作工具类：
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/25 17:07
 */
public class JacksonUtil {


    private final static ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // 未知字段忽略
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        MAPPER.registerModule(new JavaTimeModule());
        MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    /**
     * 创建  jsonNode
     *
     * @return
     */
    public final static ObjectNode createObjectNode() {
        return MAPPER.createObjectNode();
    }

    /**
     * 创建 arraynode
     *
     * @return
     */
    public final static ArrayNode createArrayNode() {
        return MAPPER.createArrayNode();
    }

    /**
     * java 对象转换成 json 字符串
     *
     * @param input
     * @return
     */
    public final static String toJsonString(Object input) throws JsonProcessingException {
        return MAPPER.writeValueAsString(input);
    }

    /**
     * object 转换成 json
     * 支持 sring 字符，及 java 对象
     *
     * @param input
     * @return
     */
    public final static JsonNode toJsonNode(Object input) throws IOException {
        return (input instanceof String) ? readTree((String) input) : valueToTree(input);
    }

    /**
     * json 字符串 转换成json 对象
     *
     * @param input
     * @return
     */
    public final static JsonNode readTree(String input) throws IOException {
        if (input == null) {
            return null;
        }
        return MAPPER.readTree(input);
    }

    /**
     * java 对象 转换的 json对象
     *
     * @param object
     * @return
     */
    public final static JsonNode valueToTree(Object object) {
        return MAPPER.valueToTree(object);
    }

    /**
     * string 字符串 转 java class 对象
     *
     * @param input
     * @param clazz
     * @param <T>
     */
    public final static <T> T stringToObject(String input, Class<T> clazz) throws IOException {
        return MAPPER.readValue(input, clazz);
    }

    /**
     * string 字符串 转成 java 对象
     *
     * @param input
     * @param tClass
     * @param <T>
     * @return
     */
    public final static <T> T parseObject(String input, Class<T> tClass) throws IOException {
        return stringToObject(input, tClass);
    }

    /**
     * json 对象，转换 成java 对象
     *
     * @param input
     * @param tClass
     * @param <T>
     * @return
     */
    public final static <T> T parseObject(JsonNode input, Class<T> tClass) throws IOException {
        return treeToValue(input, tClass);
    }

    /**
     * json 对象 转换成 class
     *
     * @param jsonNode
     * @param clazz
     * @param <T>
     * @return
     */
    public final static <T> T treeToValue(JsonNode jsonNode, Class<T> clazz) throws IOException {
        return MAPPER.treeToValue(jsonNode, clazz);
    }

    /**
     * json 对象转换成 java 对象 list
     *
     * @param jsonNode
     * @param tClass
     * @param <T>
     * @return
     */
    public final static <T> List<T> treeToListValue(JsonNode jsonNode, Class<T> tClass) throws IOException {
        return (List<T>) treeToCollectionValues(jsonNode, List.class, tClass);
    }

    /**
     * json 对象 转换成 set
     *
     * @param jsonNode
     * @param tClass
     * @param <T>
     * @return
     */
    public final static <T> Set<T> treeToSetValue(JsonNode jsonNode, Class<T> tClass) throws IOException {
        return (Set<T>) treeToCollectionValues(jsonNode, Set.class, tClass);
    }

    /**
     * json 对象转换成 map
     *
     * @param jsonNode
     * @param kClass
     * @param vClass
     * @param <K>
     * @param <V>
     * @return
     */
    public final static <K, V> Map<K, V> treeToMapValue(JsonNode jsonNode, Class<K> kClass, Class<V> vClass) throws IOException {
        JavaType javaType = MAPPER.getTypeFactory().constructMapType(Map.class, kClass, vClass);
        ObjectReader objectReader = MAPPER.readerFor(javaType);
        return objectReader.readValue(jsonNode);
    }

    /**
     * json 字符串转换成 map
     *
     * @param jsonStr
     * @param <K>
     * @param <V>
     * @return
     */
    public final static <K, V> Map<K, V> treeToMapValue(String jsonStr, Class<K> kClass, Class<V> vClass) throws IOException {
        if (jsonStr == null) {
            return null;
        }
        JsonNode jsonNode = MAPPER.readTree(jsonStr);
        JavaType javaType = MAPPER.getTypeFactory().constructMapType(Map.class, kClass, vClass);
        ObjectReader objectReader = MAPPER.readerFor(javaType);
        return objectReader.readValue(jsonNode);
    }


    public final static <T> Collection<T> treeToCollectionValues(JsonNode jsonNode, Class<? extends Collection> collectionClazz, Class<T> tClass) throws IOException {
        JavaType javaType = MAPPER.getTypeFactory().constructCollectionType(collectionClazz, tClass);
        ObjectReader objectReader = MAPPER.readerFor(javaType);
        return objectReader.readValue(jsonNode);
    }

    /**
     * json 对象 转换的 list<T>
     *
     * @param input
     * @param tClass
     * @param <T>
     * @return
     */
    public final static <T> List<T> parseList(JsonNode input, Class<T> tClass) throws IOException {
        return treeToListValue(input, tClass);
    }

    /**
     * json 字符串，转换成 list
     *
     * @param input
     * @param tClass
     * @param <T>
     * @return
     */
    public final static <T> List<T> parseList(String input, Class<T> tClass) throws IOException {
        JavaType javaType = MAPPER.getTypeFactory().constructCollectionType(List.class, tClass);
        ObjectReader objectReader = MAPPER.readerFor(javaType);
        return objectReader.readValue(input);
    }

    /**
     * 判断 jsonnode  是否为 null
     *
     * @param jsonNode
     * @return
     */
    public final static boolean isNull(JsonNode jsonNode) {
        if (jsonNode == null) {
            return true;
        }
        return jsonNode.isNull();
    }

    /**
     * 判断jsonnode 是否存在
     *
     * @param jsonNode
     * @return
     */
    public final static boolean isMissingNode(JsonNode jsonNode) {
        if (jsonNode == null) {
            return true;
        }
        return jsonNode.isMissingNode();
    }

    /**
     * 判断 json node 是否 空数据
     *
     * @param jsonNode
     * @return
     */
    public final static boolean isEmpty(JsonNode jsonNode) {
        return isMissingNode(jsonNode) || isNull(jsonNode);
    }

    public final static <T> T readValue(String content, TypeReference<T> valueTypeRef)
            throws IOException {
        return MAPPER.readValue(content, valueTypeRef);
    }

}
