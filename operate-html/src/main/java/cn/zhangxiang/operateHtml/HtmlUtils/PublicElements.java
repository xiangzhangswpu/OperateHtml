package cn.zhangxiang.operateHtml.HtmlUtils;

/**
* @ClassName: PublicElements 
* @Description: TODO(生成HTML文档过程中的静态变量) 
* @author zhangxiang 
* @date 2017年10月23日 下午3:08:00 
*
 */
public class PublicElements {
	
	/**
	 * 为了生成严格的HTML自定义替换标签
	 */
	public static final String ReplaceSign = "staticReplaceSign";
	
	/**
	 * 最终生成的HTML需要被替换的字符
	 */
	public static final String repalceOldOther = "class=\"replaceSignDontMove\"\\>";
	
	/**
	 * 最终生成的html需要替换后的字符
	 */
	public static final String repalceNewOther = "\\/\\>";
	
	/**
	 * windows下默认生成文件的地址
	 */
	public static final String initFilePath = "D://genFile";
	
	/**
	 * html 后缀
	 */
	public static final String htmlEnd = ".html";
	
	/**
	 * pdf 后缀
	 */
	public static final String pdfEnd = ".pdf";
	
	/**
	 * 表示宽的key
	 */
	public static final String keyWidth = "width";
	
	/**
	 * 表示高的key
	 */
	public static final String keyheight = "height";
	
	/**
	 * base64码展示图片时需要默认前置
	 */
	public static final String showBase64Title = "data:image/png;base64,";
	
	/**
	 * 初始化table每一行展示的列数
	 */
	public static final double initTableCols = 4;
	
	/**
	 * 每行展示字符长度
	 */
	public static final int colLength = 50;
	
	/**
	 * 长字符串断符，使用xmlrender的方式将html生成PDF时使用
	 */
	public static final String StringBRSign = " ";
	
	

}
