package com.self.fucker.util;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 *                                 
 * @ClassName: FastJsonUtil
 * @Description: TODO
 * @author mengshanxi
 * @date 2017年9月13日 下午12:02:24
 *
 */
public class FastJsonUtil {
	static {

		ParserConfig.getGlobalInstance().addAccept("com.sem.");
	}
	// 序列化属性
	private final static SerializerFeature[] serializerFeature = new SerializerFeature[] {
			SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullNumberAsZero,
			SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty,
			SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.BrowserSecure,
			SerializerFeature.BrowserCompatible };
	// 反序列化属性
	private final static Feature[] deserializerFeature = new Feature[] {

	};

	/**
	 * 将对象转换成json
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJsonString(Object obj) {
		if (obj == null) {
			return "{}";
		}
		return JSON.toJSONString(obj, serializerFeature);
	}

	/**
	 * 将对象转换成字节数组
	 * 
	 * @param obj
	 * @return
	 */
	public static byte[] toJsonBytes(Object obj) {
		if (obj == null) {
			return SerializeUtils.EMPTY_ARRAY;
		}
		return JSON.toJSONBytes(obj, serializerFeature);
	}

	/**
	 * 将json转换成对象
	 * 
	 * @param <T>
	 * 
	 * @param data
	 * @param className
	 * @return
	 */
	public static <T> T parseObject(byte[] data, Class<T> className) {
		if (SerializeUtils.isEmpty(data) || className == null) {
			return null;
		}
		return JSON.parseObject(data, className, deserializerFeature);
	}

	/**
	 * 通用Object序列化
	 * 
	 * @param data
	 * @return
	 */
	public static Object parseObject(byte[] data) {
		if (SerializeUtils.isEmpty(data)) {
			return null;
		}
		return JSON.parse(data, deserializerFeature);
	}

	/**
	 * 将json字节数组转换成map对象
	 * 
	 * @param data
	 * @return
	 */
	public static Map<String, Object> parseMap(byte[] data) {
		return JSON.parseObject(data, new TypeReference<Map<String, Object>>() {
		}.getType(), deserializerFeature);
	}

	/**
	 * 将json转换为没有class的JSONObject对象，可以通过getKey拿到所有的值
	 * 
	 * @param jsonString
	 * @return
	 */
	public static JSONObject parseJSONObject(byte[] data) {
		return JSON.parseObject(data, JSONObject.class, deserializerFeature);
	}

	/**
	 * 将json转换成对象
	 * 
	 * @param <T>
	 * 
	 * @param jsonString
	 * @param className
	 * @return
	 */
	public static <T> T parseObject(String jsonString, Class<T> className) {
		if (jsonString == null || className == null) {
			return null;
		}
		return JSON.parseObject(jsonString, className, deserializerFeature);
	}

	/**
	 * 将json字符串转换成map对象
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Map<String, Object> parseMap(String jsonString) {
		return JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>() {
		}, deserializerFeature);
	}

	/**
	 * 将json转换为没有class的JSONObject对象，可以通过getKey拿到所有的值
	 * 
	 * @param jsonString
	 * @return
	 */
	public static JSONObject parseJSONObject(String jsonString) {
		return JSON.parseObject(jsonString);
	}

	/**
	 * 将json转换成jsonArray
	 * 
	 * @param jsonString
	 * @return
	 */
	public static JSONArray parseJSONArray(String jsonString) {
		return JSON.parseArray(jsonString);
	}

	public static void main(String[] args) {
		String result = FastJsonUtil.toJsonString("我是一个测试");
		System.out.println("fastjson string::::" + result);
		System.out.println("判断结果::::" + "\"我是一个测试\"".equals(result));
	}
}
