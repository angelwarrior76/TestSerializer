package com.homework.java.serialize.model;

public enum Type {

    SHORT("short", Short.class.getTypeName()),
    INTEGER("int", Integer.class.getTypeName()),
    LONG("long", Long.class.getTypeName()),
    DOUBLE("double", Double.class.getTypeName()),
    FLOAT("float", Float.class.getTypeName()),
    STRING("String", String.class.getTypeName()),
    BYTE("byte", Byte.class.getTypeName()),
    BOOLEAN("boolean", Boolean.class.getTypeName());

    private final String type, shell;

    Type(String type, String shell) {
        this.type = type;
        this.shell = shell;
    }

    /**
     * Поиск типа по имени, не бросающих исключений
     *
     * @param name имя типа
     * @return тип параметра для заданного имени, null - если не найден
     */
    public static Type findByName(String name) {
        Type ret = null;
        try {
            ret = valueOf(name);
        } catch (RuntimeException e) {
            ret = null;
        }
        return ret;
    }

    /**
     * Поиск типа по описанию, не бросающих исключений
     *
     * @param type описание типа
     * @return тип параметра для заданного имени, null - если не найден
     */
    public static Type findByType(String type) {
        Type ret = null;
        try {
            for (Type value : values()) {
                if (value.getType().equalsIgnoreCase(type)) {
                    ret = value;
                    break;
                }
            }
        } catch (RuntimeException e) {
            ret = null;
        }
        return ret;
    }

    /**
     * Поиск типа по описанию, не бросающих исключений
     *
     * @param shell описание типа
     * @return тип параметра для заданного имени, null - если не найден
     */
    public static Type findByShell(String shell) {
        Type ret = null;
        try {
            for (Type value : values()) {
                if (value.getShell().equalsIgnoreCase(shell)) {
                    ret = value;
                    break;
                }
            }
        } catch (RuntimeException e) {
            ret = null;
        }
        return ret;
    }

    public String getType() {
        return type;
    }

    public String getShell() {
        return shell;
    }

    @Override
    public String toString() {
        return type;
    }

}
