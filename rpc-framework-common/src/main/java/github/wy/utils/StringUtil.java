package github.wy.utils;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-14  21:24
 * @Version: 1.0.0
 * @Description: 字符串工具类
 */
public class StringUtil {

    public static boolean isBlank(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        for (int i = 0; i < s.length(); ++i) {
            if(!Character.isWhitespace(s.charAt(i))){
                return false;
            }

        }
        return true;
    }
}
