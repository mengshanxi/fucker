package com.self.fucker.util;

/**
 * 
 * @ClassName: Converter
 * @Description: TODO
 * @author mengshanxi
 * @date 2017年9月13日 下午12:00:50
 *
 */
public class Converter {

	/**
	 * 
	 * @discription 将数据库字段名转义为属性名，去除下划线，连接处首字母大写
	 * @author
	 * @created 2015-12-21 下午2:11:35
	 * @param columnName
	 * @return
	 */
	public static String columnToProp(String columnName) {

		while (columnName.indexOf("_") != -1) {

			columnName = columnName.substring(0, columnName.indexOf("_"))
					+ columnName.substring(columnName.indexOf("_") + 1, columnName.indexOf("_") + 2).toUpperCase()
					+ columnName.substring(columnName.indexOf("_") + 2);
		}

		return columnName;

	}

	/**
	 * 
	 * @discription 将属性名转义为数据库字段名，添加下划线，连接处首字母小写
	 * @author
	 * @created 2015-12-21 下午2:12:19
	 * @param propName
	 * @return
	 */
	public static String propToColumn(String propName) {

		StringBuffer temp = new StringBuffer();

		for (int index = 0; index < propName.length(); index++) {

			if (Character.isUpperCase(propName.charAt(index))) {

				temp.append("_" + (propName.charAt(index) + "").toLowerCase());
				continue;
			}

			temp.append(propName.charAt(index));
		}
		return temp.toString();

	}
}
