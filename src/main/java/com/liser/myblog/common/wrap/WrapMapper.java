package com.liser.myblog.common.wrap;

/**
 * <p>Description  </p>
 * <p>Company: http://www.uinnova.cn/ </p>
 *
 * @author LiMG
 * @Date 2018/3/28 11:22
 */
public class WrapMapper {

    public static <E> Wrapper<E> wrap(String code, String message, E o) {
        return new Wrapper(code, message, o);
    }

    public static <E> Wrapper<E> wrap(String code, String message) {
        return new Wrapper(code, message);
    }

    public static <E> Wrapper<E> wrap(String code) {
        return wrap(code, null);
    }

    public static <E> Wrapper<E> wrap(Exception e) {
        return new Wrapper("500", e.getMessage());
    }

    public static <E> E unWrap(Wrapper<E> wrapper) {
        return wrapper.getResult();
    }

    public static <E> Wrapper<E> illegalArgument() {
        return wrap("100", "参数非法");
    }

    /**
     * 系统异常
     * @param <E>
     * @return
     */
    public static <E> Wrapper<E> error() {
        return wrap("500", "系统内部异常");
    }

    /**
     * 操作成功
     * @param e
     * @param <E>
     * @return
     */
    public static <E> Wrapper<E> success(E e) {
        return wrap("200", "操作成功", e);
    }

    public static <E> Wrapper<E> ok() {
        return new Wrapper();
    }

    /**
     * 业务异常
     * @param e     异常对象
     * @param <E>   泛型对象
     * @return
     */
    public static <E> Wrapper<E> businessError(Exception e) {
        return wrap("800", e.getMessage());
    }

}
