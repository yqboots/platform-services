package com.yqboots.core.id;

import lombok.Setter;

import java.util.UUID;

/**
 * 存储于数据库表中的键值
 */
public class PersistentKeyGenerator implements KeyGenerator {
    /**
     * 用于区分不同类型的Key，比如用于User，取名user;用于Order, 取名order
     */
    @Setter
    protected String key;
    /**
     * 数字的位数
     */
    @Setter
    protected int digits;
    @Setter
    private PersistentKeyGenerator.Type type;

    public PersistentKeyGenerator() {
        this.type = PersistentKeyGenerator.Type.numeric;
    }

    @Override
    public Object generate() {
        if (this.type == PersistentKeyGenerator.Type.uuid) {
            return UUID.randomUUID().toString();
        }

        // TODO:

        return null;
    }

    public static enum Type {
        alphanumeric(0, true),
        numeric(1, true),
        uuid(2, false);

        private final int number;
        private final boolean resettable;

        private Type(int number, boolean resettable) {
            this.number = number;
            this.resettable = resettable;
        }
    }
}
