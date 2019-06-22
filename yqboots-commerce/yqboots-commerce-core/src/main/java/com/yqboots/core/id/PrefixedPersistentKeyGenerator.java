package com.yqboots.core.id;

import lombok.Setter;

/**
 * 在键值上加前缀
 */
public class PrefixedPersistentKeyGenerator extends PersistentKeyGenerator {
    @Setter
    private String prefix;

    @Override
    public Object generate() {
        return prefix + super.generate();
    }
}
