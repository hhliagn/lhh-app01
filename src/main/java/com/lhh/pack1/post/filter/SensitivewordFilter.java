package com.lhh.pack1.post.filter;

import com.lhh.base.utils.CommUtils;
import org.hibernate.validator.internal.util.privilegedactions.GetResource;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;

/**  
 * @Description: 敏感词过滤  
 * @version 1.0  
 */  
public class SensitivewordFilter {  
    @SuppressWarnings("rawtypes")  
    private static Map sensitiveWordMap = null;
    public static int minMatchTYpe = 1; // 最小匹配规则  
    public static int maxMatchType = 2; // 最大匹配规则  
      
      
    /**  
     * 获取文字中的敏感词  
     *   
     * @param txt  
     *            文字
     * @return  
     * @version 1.0  
     */ 
    public static Set<String> getSensitiveWord(String txt) {
        Set<String> sensitiveWordList = new HashSet<String>();  
        for(int i = 0 ; i < txt.length() ; i++){  
            int length = CheckSensitiveWord(txt, i); // 判断是否包含敏感字符  
            if (length > 0) { // 存在,加入list中  
                sensitiveWordList.add(txt.substring(i, i+length));  
                i = i + length - 1; // 减1的原因，是因为for会自增  
            }  
        }  
        return sensitiveWordList;  
    }  
      
    /**  
     * 替换敏感字字符  
     *   
     * @param txt  
     * @param matchType  
     * @param replaceChar  
     *            替换字符，默认*  
     * @version 1.0  
     */  
    public String replaceSensitiveWord(String txt, int matchType, String replaceChar) {  
        String resultTxt = txt;  
        Set<String> set = getSensitiveWord(txt); // 获取所有的敏感词  
        Iterator<String> iterator = set.iterator();  
        String word = null;  
        String replaceString = null;  
        while (iterator.hasNext()) {  
            word = iterator.next();  
            replaceString = getReplaceChars(replaceChar, word.length());  
            resultTxt = resultTxt.replaceAll(word, replaceString);  
        }  
        return resultTxt;  
    }  
      
    /**  
     * 获取替换字符串  
     *   
     * @param replaceChar  
     * @param length  
     * @return  
     * @version 1.0  
     */  
    private String getReplaceChars(String replaceChar, int length) {  
        String resultReplace = replaceChar;  
        for(int i = 1 ; i < length ; i++){  
            resultReplace += replaceChar;  
        }  
        return resultReplace;  
    }  
      
    /**  
     * 检查文字中是否包含敏感字符，检查规则如下：<br>  
     *   
     * @param txt  
     * @param beginIndex
     * @return，如果存在，则返回敏感词字符的长度，不存在返回0  
     * @version 1.0  
     */ 
    @SuppressWarnings({ "rawtypes"})  
    public static int CheckSensitiveWord(String txt,int beginIndex){
        boolean flag = false; // 敏感词结束标识位：用于敏感词只有1位的情况  
        int matchFlag = 0; // 匹配标识数默认为0  
        char word = 0; 
        Map nowMap = sensitiveChangeDFA();  
        for(int i = beginIndex; i < txt.length() ; i++){  
            word = txt.charAt(i);  
            nowMap = (Map) nowMap.get(word); // 获取指定key  
            if (nowMap != null) { // 存在，则判断是否为最后一个  
                matchFlag++; // 找到相应key，匹配标识+1  
                if ("1".equals(nowMap.get("isEnd"))) { // 如果为最后一个匹配规则,结束循环，返回匹配标识数  
                    flag = true; // 结束标志位为true  
                }  
            }else { // 不存在，直接返回  
                break;  
            }  
        }  
        if (matchFlag < 2 || !flag) { // 长度必须大于等于1，为词  
            matchFlag = 0;  
        }  
        return matchFlag;  
    }  
      
    /**  
     * action调用 方法说明  
     *   
     * @author yxs  
     * @since 替换主入口
     * @param word  
     * @return  
     */  
    public static String SensitivewordFilterHandler(String word) {  
        SensitivewordFilter filter = new SensitivewordFilter();  
        String result = "";  
        if (word != null) {  
            result = filter.replaceSensitiveWord(word, maxMatchType, "*");  
        }  
        return result;  
    }  
    /**  
     * 读取敏感词库，将敏感词放入HashSet中，构建一个DFA算法模型：<br>
     * @throws Exception 
     */ 
    @SuppressWarnings({ "rawtypes", "unchecked" })  
    private static Map sensitiveChangeDFA() {
    	Set<String> keyWordSet=new HashSet<String>();
    	try {
    		if(CommUtils.isNull(sensitiveWordMap)){
    			File file=new File(GetResource.class.getClassLoader().getResource("words").getPath());
    			 File[] tempList = file.listFiles();
    			 for (int i = 0; i < tempList.length; i++) {
    				 BufferedInputStream fis = new BufferedInputStream(String.class.getResourceAsStream("/file/"+tempList[i].getName()));
    	        		InputStreamReader isr=new InputStreamReader(fis,"UTF8");
    	        		BufferedReader reader = new BufferedReader(isr, 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
    	        		while (reader.ready()) {
    	        			String line = reader.readLine();
    	        			keyWordSet.add(line);
    	        		}
				}
            	sensitiveWordMap = new HashMap(keyWordSet.size()); // 初始化敏感词容器，减少扩容操作  
                String key = null;    
                Map nowMap = null;  
                Map<String, String> newWorMap = null;  
                // 迭代keyWordSet  
                Iterator<String> iterator = keyWordSet.iterator();  
                while(iterator.hasNext()){  
                    key = iterator.next(); // 关键字  
                    nowMap = sensitiveWordMap;  
                    for(int i = 0 ; i < key.length() ; i++){  
                        char keyChar = key.charAt(i); // 转换成char型  
                        Object wordMap = nowMap.get(keyChar); // 获取  
                        if (wordMap != null) { // 如果存在该key，直接赋值  
                            nowMap = (Map) wordMap;  
                        }else { // 不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个  
                            newWorMap = new HashMap<String,String>();  
                            newWorMap.put("isEnd", "0"); // 不是最后一个  
                            nowMap.put(keyChar, newWorMap);  
                            nowMap = newWorMap;  
                        }  
                        if(i == key.length() - 1){  
                            nowMap.put("isEnd", "1"); // 最后一个  
                        }  
                    }  
                }
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return sensitiveWordMap;
    } 

    public  void Test() { 
    	/*sensitiveUtil("");*/
       String string = "爱女人敏感词难过就躺刘自宾在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着。你是中国复兴党,中国人民 万岁";  
        Set<String> set = getSensitiveWord(string);  
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);  
        System.out.println(SensitivewordFilterHandler(string));  
    } 
    
    public static Set<String> sensitiveUtil(String str){
    	Set<String> set=new HashSet<String>();
    	try {
    		set = getSensitiveWord(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return set;
    }
} 
