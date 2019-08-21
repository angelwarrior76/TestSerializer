package com.homework.java.serialize.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

public class Serializer {

    private static final String ENCODING = "UTF-8";

    private static String getMapValueString(Object obj) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        Map<?, ?> map = (Map<?, ?>) obj;
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) iterator.next();
            sb.append(getObjectValueString(entry.getKey()));
            sb.append(":");
            sb.append(getObjectValueString(entry.getValue()));
            if (iterator.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private static String getArrayValueString(Object obj) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        if (obj instanceof Object[]) {
            Object[] list = (Object[]) obj;
            for (int i = 0; i < list.length; i++) {
                if (list.length > 1 && i > 0) {
                    sb.append(",");
                }
                sb.append(getObjectValueString(list[i]));
            }
        } else {
            final Object[] boxedArray = new Object[Array.getLength(obj)];
            for (int i = 0; i < boxedArray.length; i++) {
                boxedArray[i] = Array.get(obj, i);
                if (boxedArray.length > 1 && i > 0) {
                    sb.append(",");
                }
                sb.append(getObjectValueString(boxedArray[i]));
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static String getCollectionValueString(Object obj) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        Collection<?> list = (Collection<?>) obj;
        Object[] array = list.toArray();
        for (int i = 0; i < array.length; i++) {
            if (array.length > 1 && i > 0) {
                sb.append(",");
            }
            sb.append(getObjectValueString(array[i]));
        }
        sb.append("]");
        return sb.toString();
    }

    private static String getObjectValueString(Object obj) {
        StringBuffer sb = new StringBuffer(0);
        if (obj instanceof Boolean || obj instanceof Byte
                || obj instanceof Character || obj instanceof String) {
            sb.append("\"");
        }
        sb.append(obj);
        if (obj instanceof Boolean || obj instanceof Byte
                || obj instanceof Character || obj instanceof String) {
            sb.append("\"");
        }
        return sb.toString();
    }

    public static byte[] object2bytes(Object obj) throws IOException {
        if (obj != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            return baos.toByteArray();
        }
        return null;
    }

    public static byte[] object2bytesv1(Object obj) throws IOException {
        if (obj != null) {
            StringBuffer sb = new StringBuffer(0);
            sb.append("{\"type\":\"");
            Class clazz = obj.getClass();
            String type = clazz.getTypeName();
            if (clazz.isArray()) {
                sb.append("Array");
            } else {
                sb.append(type);
            }
            sb.append("\",\"value\":");
            System.out.println(" array: " + clazz.isArray());
            System.out.println(" primitive: " + clazz.isPrimitive());
            System.out.println(" synthetic: " + clazz.isSynthetic());
            System.out.println(" type: " + clazz.getTypeName());
            System.out.println(" local: " + clazz.isLocalClass());
            if (obj instanceof Collection) {
                sb.append(getCollectionValueString(obj));
            } else if (obj instanceof Map) {
                sb.append(getMapValueString(obj));
            } else if (clazz.isArray()) {
                sb.append(getArrayValueString(obj));
            } else if (obj instanceof Byte || obj instanceof Character
                    || obj instanceof Short || obj instanceof Integer
                    || obj instanceof Long || obj instanceof Boolean
                    || obj instanceof Float || obj instanceof Double
                    || obj instanceof String || obj instanceof BigInteger
                    || obj instanceof BigDecimal) {
                sb.append(getObjectValueString(obj));
            } else {
                Field[] flds = clazz.getDeclaredFields();
                for (Field f : flds) {
                    sb.append("{\"");
                    sb.append(f.getName());
                    sb.append("\",\"type\":");
                    sb.append(f.getType());
                    sb.append("\",[");
                    Class<?> c = f.getType();
                    //if (f instanceof Collection) {
                    //    sb.append(getCollectionValueString(f));
                    //} else if (f instanceof Map) {
                    //    sb.append(getMapValueString(f));
                    /*} else*/ if (c.isArray()) {
                        sb.append(getArrayValueString(f));
                    } else {
                        sb.append(getObjectValueString(f));
                    }
                    sb.append("]");
                }
            }
            sb.append("}");
            System.out.println(" obj: " + sb.toString());
            return sb.toString().getBytes(ENCODING);
        }
        return null;
    }

    public static byte[] object2bytesv2(Object obj) throws UnsupportedEncodingException {
        if (obj != null) {
            return JSONObject.valueToString(JSONObject.wrap(obj)).getBytes(ENCODING);
        }
        return null;
    }

    public static Object bytes2object(byte[] data) throws IOException, ClassNotFoundException {
        if (data != null) {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object obj = ois.readObject();
            ois.close();
            return obj;
        }
        return null;
    }

    public static Object bytes2objectv1(byte[] data) throws IOException, ClassNotFoundException {
        if (data != null) {
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);
            return is.readObject();
        }
        return null;
    }

    public static Object bytes2objectv2(byte[] data) throws UnsupportedEncodingException {
        if (data != null) {
            return JSONObject.stringToValue(new String(data, ENCODING));
        }
        return null;
    }

}
