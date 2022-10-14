package github.wy.extension;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-14  21:28
 * @Version: 1.0.0
 * @Description: TODO
 */
public class Holder<T> {

    private volatile T value;

    public T get(){
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}
