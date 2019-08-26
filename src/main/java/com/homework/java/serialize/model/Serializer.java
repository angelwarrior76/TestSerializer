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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
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

    private static Object getObjectValue(String str) {
        if ("".equals(str)) {
            return str;
        } else if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        } else if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        } else if ("null".equalsIgnoreCase(str)) {
            return null;
        } else {
            char initial = str.charAt(0);
            if (initial >= '0' && initial <= '9' || initial == '-') {
                if (str.indexOf(46) > -1 || str.indexOf(101) > -1 || str.indexOf(69) > -1 || "-0".equals(str)) {
                    if (str.length() > 14) {
                        return new BigDecimal(str);
                    } else {
                        Double d = Double.valueOf(str);
                        return (!d.isInfinite() && !d.isNaN() ? d : new BigDecimal(str));
                    }
                } else {
                    BigInteger bi = new BigInteger(str);
                    if (bi.bitLength() <= 31) {
                        return bi.intValue();
                    } else {
                        Long l = Long.valueOf(str);
                        if (str.equals(l.toString())) {
                            if (l == (long) l.intValue()) {
                                return l.intValue();
                            }
                            return l;
                        }
                        return (bi.bitLength() <= 63 ? bi.longValue() : bi);
                    }
                }
            }
            return str;
        }
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

    public static byte[] object2bytesv1(Object obj) throws IOException, IllegalAccessException {
        if (obj != null) {
            StringBuffer sb = new StringBuffer(0);
            sb.append("{\"type\":\"");
            Class clazz = obj.getClass();
            String type = clazz.getTypeName();
            if (clazz.isArray()) {
                sb.append(clazz.getComponentType().getTypeName());
            } else {
                sb.append(type);
            }
            sb.append("\",\"value\":");
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
                for (int i = 0; i < flds.length; i++) {
                    if (flds.length > 1 && i > 0) {
                        sb.append(",");
                    }
                    sb.append("{\"name\":\"");
                    sb.append(flds[i].getName());
                    sb.append("\",\"type\":");
                    Class<?> c = flds[i].getType();
                    if (c.isArray()) {
                        sb.append("Array");
                    } else {
                        sb.append(c.getTypeName());
                    }
                    sb.append("\",\"value\":{");
                    if (flds[i].get(obj) instanceof Collection) {
                        sb.append(getCollectionValueString(flds[i].get(obj)));
                    } else if (flds[i].get(obj) instanceof Map) {
                        sb.append(getMapValueString(flds[i].get(obj)));
                    } else if (c.isArray()) {
                        sb.append(getArrayValueString(flds[i].get(obj)));
                    } else {
                        sb.append(getObjectValueString(flds[i].get(obj)));
                    }
                    sb.append("}");
                }
            }
            sb.append("}");
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

    public static Object bytes2objectv1(byte[] data) throws IOException, IllegalAccessException, InstantiationException {
        if (data != null) {
            Object ret = null;
            String str = new String(data, ENCODING);
            int ts = str.indexOf(":\""), tf = str.indexOf("\",\"value");
            String type = str.substring(ts + 2, tf);
            boolean isarray = str.indexOf("value\":[") > 0;
            Object obj = null;
            try {
                Class<?> clazz = Class.forName(type);
                obj = clazz.newInstance();
            } catch (ClassNotFoundException e) {
                switch (type) {
                    case "int":
                        obj = Integer.class;
                        break;
                    case "short":
                        obj = Short.class;
                        break;
                    case "long":
                        obj = Long.class;
                        break;
                    case "float":
                        obj = Float.class;
                        break;
                    case "double":
                        obj = Double.class;
                        break;
                    case "byte":
                        obj = Byte.class;
                        break;
                    case "boolean":
                        obj = Boolean.class;
                        break;
                    case "char":
                        obj = Character.class;
                        break;
                }
            }
            int vs = str.indexOf("value\":") + 8, vf = str.lastIndexOf("}") - 1;
            String value = str.substring(vs, vf);
            if (obj instanceof Collection) {
                String strings[] = value.split(",");
                Object values[] = new Object[strings.length];
                for (int i = 0; i < strings.length; i++) {
                    values[i] = getObjectValue(strings[i]);
                }
                ret = Arrays.asList(values);
            } else if (obj instanceof Map) {
                Map map = new HashMap(0);
                String strings[] = value.split(",");
                for (int i = 0; i < strings.length; i++) {
                    String pair[] = strings[i].split(":");
                    String key = pair[0], val = pair[1];
                    map.put(getObjectValue(key), getObjectValue(val));
                }
                ret = map;
            } else if (isarray) {
                String strings[] = value.split(",");
                Object values[] = new Object[strings.length];
                for (int i = 0; i < strings.length; i++) {
                    values[i] = getObjectValue(strings[i]);
                }
                ret = values;
            } else if (obj instanceof Byte || obj instanceof Character
                    || obj instanceof Short || obj instanceof Integer
                    || obj instanceof Long || obj instanceof Boolean
                    || obj instanceof Float || obj instanceof Double
                    || obj instanceof String || obj instanceof BigInteger
                    || obj instanceof BigDecimal) {
                ret = getObjectValue(value);
            } else {
                //
            }
            return ret;
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
