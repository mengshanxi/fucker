package com.self.fucker.util;

import java.util.HashMap;

/**
 * 
 * @ClassName: DatatableParamUtil
 * @Description: TODO
 * @author mengshanxi
 * @date 2017年9月13日 下午12:02:17
 *
 */
public class DatatableParamUtil {
	/**
	 * 由于目前web和app使用的同一套接口，但两边传输的参数并不一致，因此，需要此方法来转换成对应的map。
	 * 
	 * @param jsonParam
	 * @return
	 */
	public static HashMap<String, Object> decodeParam(String jsonParam) {
		HashMap<String, Object> maps = new HashMap<String, Object>();
		if (jsonParam.startsWith("{")) {
			maps.putAll((HashMap<String, Object>) FastJsonUtil.parseMap(jsonParam));
		} else {
			String[] params = jsonParam.split("&");
			for (int index = 0; index < params.length; index++) {
				if (!(null == params[index].substring(params[index].indexOf("=") + 1)
						|| ("").equals(params[index].substring(params[index].indexOf("=") + 1)))) {
					maps.put(params[index].substring(0, params[index].indexOf("=")),
							params[index].substring(params[index].indexOf("=") + 1));
				}

			}
		}
		return maps;
	}
}
