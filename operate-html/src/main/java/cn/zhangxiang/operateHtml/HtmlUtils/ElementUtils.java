package cn.zhangxiang.operateHtml.HtmlUtils;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/**
* @ClassName: ElementUtils 
* @Description: TODO(利用jsoup操作HTML元素) 
* @author zhangxiang 
* @date 2017年10月24日 下午5:27:35 
*
 */
public class ElementUtils {
	
	/**
	 * 
	* @Title: getP 
	* @Description: TODO(生成段落P) 
	* @param @param marginTop 与上元素的间隔，带单位，如 "10px"
	* @param @param marginBottom 与下元素的间隔，带单位，如 "10px"
	* @param @param otherPreferences style中的其它属性
	* @param @return    设定文件 
	* @return Element    返回类型 
	* @throws
	 */
	public static Element getP(String marginTop,String marginBottom,String otherPreferences){
		Element p = new Element("p");
		String styleString = "orphans:0; text-align:justify; widows:0";
		if(StringUtils.isNotBlank(marginTop)){
			styleString += ";margin-top:"+marginTop;
		}
		if(StringUtils.isNotBlank(marginBottom)){
			styleString += ";margin-bottom:"+marginBottom;
		}
		if(StringUtils.isNotBlank(otherPreferences)){
			styleString += ";"+otherPreferences;
		}
		p.attr("style", styleString);
		return p;
	}

}
