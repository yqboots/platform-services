package com.yqboots.commerce.core.id;

import com.yqboots.commerce.core.entity.SequenceRepository;
import lombok.Setter;

/**
 * 在键值上加前缀
 */
public class PrefixedPersistentKeyGenerator extends PersistentKeyGenerator {
    @Setter
    private String prefix;

    public PrefixedPersistentKeyGenerator(String key, SequenceRepository sequenceRepository) {
        super(key, sequenceRepository);
    }

    @Override
    public Object generate() {
        return prefix + super.generate();
    }
}
