package com.cdkj.loan.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : xieyj
 * @since : 2019-01-31 16:49
 */
public class EntityUtils {

    private final static Logger log = LoggerFactory
        .getLogger(EntityUtils.class);

    /**
     * 拷贝相同名称，不同类型的两个实体数据
     *
     * @param fromObj 数据源
     * @param toClazz 待拷贝类
     * @param <T2> 具体类
     * @return 具体类对象
     */
    public static <T1, T2> T2 copyData(T1 fromObj, Class<T2> toClazz) {
        // 获取数据源类字段
        Field[] objFields = fromObj.getClass().getDeclaredFields();

        // 新建一个返回类对象
        T2 data = getInstance(toClazz);
        Field[] dataFields = toClazz.getDeclaredFields();

        Map<String, Field> dataFieldMap = new HashMap<>();
        if (null != dataFields && dataFields.length > 0) {
            for (Field tmp : dataFields) {
                dataFieldMap.put(tmp.getName(), tmp);
            }
        }

        // Map<String, Field> dataFieldMap = Arrays.stream(dataFields)
        // .collect(Collectors.toMap(Field::getName, Function.identity()));

        // 遍历返回类对象字段
        for (Field objField : objFields) {
            copyField(objField, fromObj, dataFieldMap, data);
        }

        return data;
    }

    /**
     * 拷贝相同名称，不同类型的两个实体数据
     *
     * @param fromObj 数据源
     * @param toObj 待拷贝对象
     * @param <T2> 具体类
     * @return 具体类对象
     */
    public static <T1, T2> void copyData(T1 fromObj, T2 toObj) {
        // 获取数据源类字段
        Field[] objFields = fromObj.getClass().getDeclaredFields();
        Field[] dataFields = toObj.getClass().getDeclaredFields();

        Map<String, Field> dataFieldMap = new HashMap<>();
        if (null != dataFields && dataFields.length > 0) {
            for (Field tmp : dataFields) {
                dataFieldMap.put(tmp.getName(), tmp);
            }
        }

        // Map<String, Field> dataFieldMap = Arrays.stream(dataFields)
        // .collect(Collectors.toMap(Field::getName, Function.identity()));

        // 遍历返回类对象字段
        for (Field objField : objFields) {
            copyField(objField, fromObj, dataFieldMap, toObj);
        }
    }

    private static <T1, T2> void copyField(Field objField, T1 obj,
            Map<String, Field> dataFieldMap, T2 data) {
        if (!dataFieldMap.containsKey(objField.getName())) {
            return;
        }

        Field dataField = dataFieldMap.get(objField.getName());
        // 通过方法名，设置属性值
        String methodSet = "set"
                + objField.getName().substring(0, 1).toUpperCase()
                + objField.getName().substring(1);
        try {
            objField.setAccessible(true);
            Object value = objField.get(obj);
            objField.setAccessible(false);
            if (null == value) {
                return;
            }

            Method method = null;
            switch (dataField.getType().getName()) {
                case "java.lang.Integer":
                    value = Integer.parseInt(value.toString());
                    method = data.getClass().getMethod(methodSet,
                        Integer.class);
                    break;

                case "java.lang.Long":
                    value = Long.parseLong(value.toString());
                    method = data.getClass().getMethod(methodSet, Long.class);
                    break;

                case "java.lang.Double":
                    value = Double.parseDouble(value.toString());
                    method = data.getClass().getMethod(methodSet, Double.class);
                    break;

                case "java.math.BigDecimal":
                    value = new BigDecimal(value.toString());
                    method = data.getClass().getMethod(methodSet,
                        BigDecimal.class);
                    break;
                case "java.lang.String":
                    value = value.toString();
                    method = data.getClass().getMethod(methodSet, String.class);
                    break;
                case "java.util.Date":
                    value = DateUtil.strToDate(value.toString(),
                        DateUtil.DATA_TIME_PATTERN_1);
                    method = data.getClass().getMethod(methodSet, Date.class);
                    break;
                case "java.util.List":
                    value = (List) value;
                    method = data.getClass().getMethod(methodSet, List.class);
                    break;
                default:
                    method = data.getClass().getMethod(methodSet, Object.class);
                    break;
            }
            method.invoke(data, value);
        } catch (NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
            log.info("类型转换异常:{}", e.getMessage());
        }
    }

    /**
     * 获得泛型类的实例
     */
    private static <T2> T2 getInstance(Class<T2> tClass) {
        try {
            T2 t = tClass.newInstance();
            return t;
        } catch (InstantiationException e) {
            log.info("获取泛型类异常:{}", e.getMessage());
        } catch (IllegalAccessException e) {
            log.info("获取泛型类异常:{}", e.getMessage());
        }

        return null;
    }
}
