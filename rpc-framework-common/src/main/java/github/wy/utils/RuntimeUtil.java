package github.wy.utils;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-25  13:56
 * @Version: 1.0.0
 * @Description: TODO
 */
public class RuntimeUtil {

    /**
     * 获取CPU的核心数
     */

    public static int cpus(){
        return Runtime.getRuntime().availableProcessors();
    }
}
