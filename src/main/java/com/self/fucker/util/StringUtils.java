package com.self.fucker.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.UUID;

/**
 * 
 * @ClassName: StringUtils
 * @Description: TODO
 * @author mengshanxi
 * @date 2017年9月13日 下午12:00:25
 *
 */
public class StringUtils {
	/**
	 * Email地址
	 */
	public static final String EMAIL_ADDRESS = "^[A-Za-z0-9_]+(?:[.-][A-Za-z0-9_]+)*@[A-Za-z0-9]+(?:[.-][A-Za-z0-9]+)*\\.[A-Za-z]{2,5}$";

	/**
	 * IP地址
	 */
	public static final String IP_ADDRESS = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

	/**
	 * 货币,允许带,千位符, 可选具有两位小数
	 */
	public static final String CURRENCY = "^[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{2})?$";

	/**
	 * 浮点数,允许科学记数法
	 */
	public static final String FLOAT_NUMBER = "^[-+]?[0-9]*\\.?[0-9]+(?:[eE][-+]?[0-9]+)?$";

	/**
	 * 整数
	 */
	public static final String INTEGER_NUMBER = "^[-+]?\\d+$";

	/**
	 * 网址
	 */
	public static final String URL = "^(https?|ftp|file)://[-A-Z0-9+&@#/%?=~_|!:,.;]*[-A-Z0-9+&@#/%=~_|]$";

	/**
	 * 身份证号码,15位或18位
	 */
	public static final String IDENTITY_CARD = "\\d{15}|\\d{18}";

	/**
	 * 中文字符
	 */
	public static final String CHINESE_CHARACTER = "[\u4e00-\u9fa5]+";

	/**
	 * 信用卡
	 */
	public static final String CREDITCARD_GENERAL = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6011[0-9]{14}|3(?:0[0-5]|[68][0-9])[0-9]{11}|3[47][0-9]{13})$";

	/**
	 * 英文字母及下划线
	 */
	public static final String ALPHA = "^[a-zA-Z_]+$";

	/**
	 * 英文字母,数字及下划线
	 */
	public static final String ALPHANUM = "^[a-zA-Z0-9_]+$";
	/**
	 * 文件中不能包含的字符串
	 */
	public static final String[] NOTALLOWSTRING = { "\\", "/", "?", "*", "|", ">", "<", ":", "\"", "~", "`", " ", "[",
			"]" };
	// 8到20位必须包含数字和字母的正则
	public static final String PW_PATTERN = "^(?![^a-zA-Z]+$)(?!\\D+$).{8,20}$";

	/**
	 * 某个以逗号隔开的字符串中，是否包含某一个特定的值
	 * 
	 * @param key
	 * @param source
	 * @return
	 */
	public static boolean contains(String key, String source) {
		if (key == null || "".equals(key) || source == null || "".equals(source))
			return false;
		String[] splits = source.split(",");
		List<String> arrays = Arrays.asList(splits);
		return arrays.contains(key);
	}

	/**
	 * 按照分隔符将某一个String分成list
	 * 
	 * @param str
	 * @param delim
	 * @return
	 */
	public static List<String> split(String str, String delim) {
		List<String> splitList = new ArrayList<String>();
		StringTokenizer st = null;
		if (str == null)
			return splitList;
		if (delim != null)
			st = new StringTokenizer(str, delim);
		else
			st = new StringTokenizer(str);
		if (st != null && st.hasMoreTokens()) {
			while (st.hasMoreTokens())
				splitList.add(st.nextToken());
		}
		return splitList;
	}

	/**
	 * 传入一个经过format的number类型的数值，去掉其中的逗号
	 * 
	 * @param value
	 * @return
	 */
	public static String removeComma(String value) {
		if (value == null)
			return value;
		value = value.replace(",", "");
		value = value.replace("，", "");
		return value;
	}

	/**
	 * 验证传进入的值是否是整数
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isInteger(String number) {
		if (number == null)
			return false;
		boolean flag = true;
		flag = number.matches(INTEGER_NUMBER);
		return flag;
	}

	/**
	 * 验证传入的值是否是浮点数
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isFloat(String number) {
		if (number == null)
			return false;
		boolean flag = true;
		flag = number.matches(FLOAT_NUMBER);
		return flag;
	}

	/**
	 * 检查一个字符串是否是 email
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		if (email == null)
			return false;
		boolean flag = true;
		flag = email.matches(EMAIL_ADDRESS);
		return flag;
	}

	/**
	 * 将string的list转换成以逗号（,）隔开的字符串
	 * 
	 * @param list
	 * @return
	 */
	public static String join(List<String> list) {
		return join(list, ",");
	}

	/**
	 * 将集合类型合并成字符串
	 * 
	 * @param list
	 * @return
	 */
	public static String joinCollection(Collection<String> list) {
		return joinCollection(list, ",");
	}

	/**
	 * 将String的list转换成以delim隔开的字条串
	 * 
	 * @param list
	 * @param delim
	 * @return
	 */
	public static String join(List<String> list, String delim) {
		return joinCollection(list, delim);
	}

	/**
	 * 将集合类型合并成字符串
	 * 
	 * @param list
	 * @param delim
	 * @return
	 */
	public static String joinCollection(Collection<String> list, String delim) {
		if (list == null || list.isEmpty())
			return null;
		StringBuilder buf = new StringBuilder();
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			buf.append((String) i.next());
			if (i.hasNext())
				buf.append(delim);
		}
		return buf.toString();
	}

	/**
	 * 根据一个object，得到格式化后的string，这里只处理基本类型，其他类型直接toString
	 * 
	 * @param value
	 * @return
	 */
	public static String getValueString(Object value) {
		if (value == null || "".equals(value))
			return "";
		if (value instanceof String) {
			return (String) value;
		}
		if (value instanceof Date) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format((Date) value);
		} else if (value instanceof Integer) {
			DecimalFormat df = new DecimalFormat("#");
			return df.format((Integer) value);
		} else if (value instanceof Long) {
			DecimalFormat df = new DecimalFormat("#");
			return df.format((Long) value);
		} else if (value instanceof Float) {
			DecimalFormat df = new DecimalFormat("#.##");
			return df.format((Float) value);
		} else if (value instanceof Double) {
			DecimalFormat df = new DecimalFormat("#.##");
			return df.format((Double) value);
		} else if (value instanceof Timestamp) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Timestamp ts = (Timestamp) value;
			return df.format(new Date(ts.getTime()));
		} else if (value instanceof Calendar) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Calendar ts = (Calendar) value;
			return df.format(ts.getTime());
		} else if (value instanceof Enum) {
			return ((Enum) value).name();
		} else {
			return value.toString();
		}
	}

	/**
	 * 判断一个操作系统是不是windows
	 * 
	 * @return
	 */
	public static boolean isOSWindow() {
		Properties prop = System.getProperties();
		String fileSeparator = (String) prop.get("file.separator");
		if ("/".equals(fileSeparator))
			return false;
		if ("\\".equals(fileSeparator))
			return true;
		return false;
	}

	/**
	 * 判断一个字符串是否是null或者""
	 * 
	 * StringUtils.isEmpty(null) = true StringUtils.isEmpty("") = true
	 * StringUtils.isEmpty(" ") = false StringUtils.isEmpty("bob") = false
	 * StringUtils.isEmpty(" bob ") = false
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}

	/**
	 * 判断一个字符串是否不是null或者""
	 * 
	 * StringUtils.isNotEmpty(null) = false StringUtils.isNotEmpty("") = false
	 * StringUtils.isNotEmpty(" ") = true StringUtils.isNotEmpty("bob") = true
	 * StringUtils.isNotEmpty(" bob ") = true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return StringUtils.isNotEmpty(str);
	}

	/**
	 * 判断一个字符串是否是null或者是""或者是" "或者whitespace
	 * 
	 * StringUtils.isBlank(null) = true StringUtils.isBlank("") = true
	 * StringUtils.isBlank(" ") = true StringUtils.isBlank("bob") = false
	 * StringUtils.isBlank(" bob ") = false
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return StringUtils.isBlank(str);
	}

	/**
	 * 判断一个字符是否不是null或者""或者" "或者whitespace
	 * 
	 * StringUtils.isNotBlank(null) = false StringUtils.isNotBlank("") = false
	 * StringUtils.isNotBlank(" ") = false StringUtils.isNotBlank("bob") = true
	 * StringUtils.isNotBlank(" bob ") = true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return StringUtils.isNotBlank(str);
	}

	/**
	 * 去掉空格
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		return StringUtils.trim(str);
	}

	/**
	 * 删除字串中的所有空格
	 * 
	 * @param str
	 * @return
	 */
	public static String removeBlank(String str) {
		String noTrim = "";
		if (StringUtils.isNotBlank(str)) {
			noTrim = str.replaceAll(" ", "");
		}
		return noTrim;
	}

	/**
	 * 字符串中是否含有不能识别的字符
	 * 
	 * @param str
	 * @return
	 */
	public static boolean allow(String str) {
		if (isBlank(str))
			return false;
		for (String notAllow : NOTALLOWSTRING) {
			if (str.indexOf(notAllow) >= 0) {
				return false;
			}
		}
		return true;
	}

	public static String substringBefore(String str, String separator) {
		if (isEmpty(str) || separator == null) {
			return str;
		}
		if (separator.length() == 0) {
			return "";
		}
		int pos = str.indexOf(separator);
		if (pos == -1) {
			return str;
		}
		return str.substring(0, pos);

	}

	public static String substringAfter(String str, String separator) {
		if (isEmpty(str)) {
			return str;
		}
		if (separator == null) {
			return "";
		}
		int pos = str.indexOf(separator);
		if (pos == -1) {
			return "";
		}
		return str.substring(pos + separator.length());

	}

	public static boolean equalsIgnoreCase(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);

	}

	public static void main(String[] args) {
		String test = "a 我的       人";
		System.out.println(allow(test));
		System.out.println(UUID.randomUUID().toString());
	}
}
