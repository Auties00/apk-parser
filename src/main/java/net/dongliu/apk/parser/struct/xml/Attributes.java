package net.dongliu.apk.parser.struct.xml;

/**
 * xml node attributes
 *
 * @author dongliu
 */
public class Attributes {

    private final Attribute[] attributes;

    public Attributes(int size) {
        this.attributes = new Attribute[size];
    }

    public void set(int i, Attribute attribute) {
        attributes[i] = attribute;
    }

    public Attribute get(String name) {
        for (Attribute attribute : attributes) {
            if (attribute.getName().equals(name)) {
                return attribute;
            }
        }
        return null;
    }


    /**
     * Get attribute with name, return value as string
     */
    public String getString(String name) {
        Attribute attribute = get(name);
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    public int size() {
        return attributes.length;
    }

    public boolean getBoolean(String name, boolean b) {
        String value = getString(name);
        return value == null ? b : Boolean.parseBoolean(value);
    }

    public Integer getInt(String name) {
        String value = getString(name);
        if (value == null) {
            return null;
        }
        if (value.startsWith("0x")) {
            return Integer.valueOf(value.substring(2), 16);
        }
        return Integer.valueOf(value);
    }

    public Long getLong(String name) {
        String value = getString(name);
        if (value == null) {
            return null;
        }
        if (value.startsWith("0x")) {
            return Long.valueOf(value.substring(2), 16);
        }
        return Long.valueOf(value);
    }

    /**
     * return all attributes
     */
    public Attribute[] values() {
        return this.attributes;
    }
}

