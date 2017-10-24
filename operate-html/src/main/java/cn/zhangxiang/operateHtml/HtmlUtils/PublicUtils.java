package cn.zhangxiang.operateHtml.HtmlUtils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
* @ClassName: PublicUtils 
* @Description: TODO(相应的工具类方法) 
* @author zhangxiang 
* @date 2017年10月24日 下午2:38:04 
*
 */
public class PublicUtils {
	
	/**
	 * 英文数字转中文数字时使用，范围是1-99
	 */
	private static Map<String,String> zhNumMap = new HashMap<String,String>();
	
	/**
	 * 初始化数字和中文的对应
	 */
	static{
		zhNumMap.put("1", "一");
		zhNumMap.put("2", "二");
		zhNumMap.put("3", "三");
		zhNumMap.put("4", "四");
		zhNumMap.put("5", "五");
		zhNumMap.put("6", "六");
		zhNumMap.put("7", "七");
		zhNumMap.put("8", "八");
		zhNumMap.put("9", "九");
		zhNumMap.put("0", "十");
	}
	
	/**
	 * 
	* @Title: changePicUrlToBase64Code 
	* @Description: TODO(根据图片的路径转化成为base64码,转化失败则抛出异常) 
	* @param @param picUrl
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String changePicUrlToBase64Code(String picUrl) throws Exception{
		try{
			URL url = new URL(picUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");  
            conn.setConnectTimeout(5 * 1000);//请求有效时间  
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			 byte[] byteData = new byte[1024];
			 try{
				 int len=0;
				 while((len = inStream.read(byteData)) != -1){
					 outStream.write(byteData, 0, len);
				 }
				 inStream.close();
			 }catch(Exception e){
				 throw new Exception(e.getMessage());
			 }
			 Encoder encoder = java.util.Base64.getEncoder();
			 String afterEncodeStr = PublicElements.showBase64Title  + encoder.encodeToString(outStream.toByteArray());
			 return afterEncodeStr;
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	* @Title: getPicWidthAndHeightFromUrl 
	* @Description: TODO(根据图片的地址获取图片的宽和高) 
	* @param @param picUrl
	* @param @return
	* @param @throws Exception    设定文件 
	* @return Map<String,Double>    返回类型 
	* @throws
	 */
	public static Map<String,Double> getPicWidthAndHeightFromUrl(String picUrl) throws Exception {
		InputStream is = null;  
        BufferedImage src = null;  
        Map<String,Double> returnMap = new HashMap<String,Double>();
        try {  
            is = new FileInputStream(new File(picUrl));  
            src = javax.imageio.ImageIO.read(is);
            double width = src.getWidth(null); // 得到源图宽  
            double height = src.getHeight(null);//得到源图高
            returnMap.put(PublicElements.keyWidth, width);
            returnMap.put(PublicElements.keyheight, height);
            return returnMap;
        }catch (Exception e) {
        	throw new Exception(e.getMessage());
        }finally{
        	 is.close();
        }
	}
	
	/**
	* @Title: dealStringLength 
	* @Description: TODO(将长字符串截断，固定为每行展示设定的长度) 
	* @param @param oldString
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String dealStringLength(String oldString){
		if(StringUtils.isNotBlank(oldString)){
			double oldLength = oldString.length();
			if(oldLength > 0){
				StringBuffer newString = new StringBuffer();
				int cycleNum = (int)Math.ceil(oldLength/PublicElements.colLength);
				for(int i=0;i<cycleNum;i++){
					int endIndex = (i+1)*PublicElements.colLength;
					if(i == (cycleNum-1)){
						endIndex = (int)oldLength;
					}
					newString.append(oldString.substring(i*PublicElements.colLength, endIndex)).append(PublicElements.StringBRSign);
				}
				return newString.toString();
			}else{
				return "";
			}
		}else{
			return "";
		}
	}
	
	/**
	 * 
	* @Title: changeToZHNum 
	* @Description: TODO(将阿拉伯数字转化为中文数字，范围是一 到 九十九) 
	* @param @param num
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String changeToZHNum(String num) throws Exception{
		if(num == null || num.startsWith("0")){
			throw new Exception("请输入正确的数字！");
		}else{
			int numLength = num.length();
			if(numLength > 0){
				if(numLength == 1){
					if (!Character.isDigit(num.charAt(0))){
						throw new Exception("其中有非数字字符，请检查！");
					 }
					return zhNumMap.get(num);
				}else if(numLength == 2){
					String result = "";
					for(int i=0;i<numLength;i++){
						if (!Character.isDigit(num.charAt(i))){
							throw new Exception("其中有非数字字符，请检查！");
						 }
						String changeNum = String.valueOf(num.charAt(i));
						if(i==0){
							if(changeNum.equals("1")){
								result = zhNumMap.get("0");
							}else{
								result = zhNumMap.get(changeNum) + zhNumMap.get("0");
							}
						}else{
							result += zhNumMap.get(changeNum);
						}
					}
					return result;
				}else{
					throw new Exception("数字最大为99，请检查！");
				}
			}else{
				throw new Exception("数字长度必须大于0！");
			}
		}
	}
	
	/**
	* @Title: filterNull 
	* @Description: TODO(对传入的String进行处理，如果为空或者null，则返回""。否则返回原字符串) 
	* @param @param oldString    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static String filterNull(String oldString){
		if(StringUtils.isNotBlank(oldString)){
			return oldString;
		}else{
			return "";
		}
	}
	
}
