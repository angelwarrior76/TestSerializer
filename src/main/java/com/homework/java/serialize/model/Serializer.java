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
import java.util.Map;

import org.json.JSONObject;

public class Serializer {

    private static final int BUFFER = 1024;
    private static final String ENCODING = "UTF-8";

    private static byte[] checkArray(byte[] array, int pos) {
        if (pos >= array.length) {
            int newSize = array.length * 2;
            byte[] newArray = new byte[newSize];
            System.arraycopy(array, 0, newArray, 0, array.length);
            return newArray;
        }
        return array;
    }

    private static byte[] createByteArray(String type, byte[] vbytes) throws UnsupportedEncodingException {
        byte[] array = new byte[BUFFER];
        byte[] tbytes = type.getBytes(ENCODING);
        System.arraycopy(tbytes, 0, array, 0, tbytes.length);
        byte[] sbytes = " ".getBytes(ENCODING);
        System.arraycopy(sbytes, 0, array, tbytes.length, sbytes.length);
        System.arraycopy(vbytes, 0, array, tbytes.length + sbytes.length, vbytes.length);
        return array;
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
            sb.append("{\"type\" : \"");
            Class clazz = obj.getClass();
            String type = clazz.getTypeName();
            if (clazz.isArray()) {
                sb.append("Array");
            } else {
                sb.append(type);
            }
            sb.append("\", \"value\" : ");

            System.out.println(" array: " + clazz.isArray());
            System.out.println(" primitive: " + clazz.isPrimitive());
            System.out.println(" synthetic: " + clazz.isSynthetic());
            System.out.println(" type: " + clazz.getTypeName());
            System.out.println(" local: " + clazz.isLocalClass());
            if (obj instanceof Collection) {
                sb.append("[");
                Collection<?> list = (Collection<?>) obj;
                for (Object item : list) {
                    //item.getClass()
                }
                Field[] flds = clazz.getDeclaredFields();
                for (Field f : flds) {
                    Class<?> c = f.getType();
                    if (c.isArray()) {
                        System.out.format("%s%n"
                                        + "           Field: %s%n"
                                        + "            Type: %s%n"
                                        + "  Component Type: %s%n",
                                f, f.getName(), c, c.getComponentType());
                    } else {
                        System.out.format("%s%n"
                                        + "           Field: %s%n"
                                        + "            Type: %s%n",
                                f, f.getName(), c);
                    }
                }
                sb.append("]");
            } else if (obj instanceof Map) {
                Field[] flds = clazz.getDeclaredFields();
                for (Field f : flds) {
                    Class<?> c = f.getType();
                    if (c.isArray()) {
                        System.out.format("%s%n"
                                        + "           Field: %s%n"
                                        + "            Type: %s%n"
                                        + "  Component Type: %s%n",
                                f, f.getName(), c, c.getComponentType());
                    } else {
                        System.out.format("%s%n"
                                        + "           Field: %s%n"
                                        + "            Type: %s%n",
                                f, f.getName(), c);
                    }
                }
            } else if (clazz.isArray()) {
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
                    Class<?> c = f.getType();
                    if (c.isArray()) {
                        System.out.format("%s%n"
                                        + "           Field: %s%n"
                                        + "            Type: %s%n"
                                        + "  Component Type: %s%n",
                                f, f.getName(), c, c.getComponentType());
                    } else {
                        System.out.format("%s%n"
                                        + "           Field: %s%n"
                                        + "            Type: %s%n",
                                f, f.getName(), c);
                    }
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
