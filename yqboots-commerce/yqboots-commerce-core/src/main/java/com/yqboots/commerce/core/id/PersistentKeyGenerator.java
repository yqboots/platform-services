package com.yqboots.commerce.core.id;

import com.yqboots.commerce.core.entity.Sequence;
import com.yqboots.commerce.core.entity.SequenceRepository;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * 存储于数据库表中的键值
 */
public class PersistentKeyGenerator implements KeyGenerator {
    /**
     * 用于区分不同类型的Key，比如用于User，取名user;用于Order, 取名order
     */
    private final String key;
    private final SequenceRepository sequenceRepository;
    /**
     * 位数
     */
    @Setter
    private int digits = 8;
    /**
     * 起始数字，默认为0
     */
    @Setter
    private long start = 0;

    @Setter
    private PersistentKeyGenerator.Type type;

    public PersistentKeyGenerator(final String key,
                                  final SequenceRepository sequenceRepository) {
        this.key = key;
        this.sequenceRepository = sequenceRepository;
        this.type = PersistentKeyGenerator.Type.numeric;
    }

    @Override
    public Object generate() {
        if (this.type == PersistentKeyGenerator.Type.uuid) {
            return UUID.randomUUID().toString();
        }

        synchronized (key) {
            Sequence sequence = sequenceRepository.findByType(key);
            if (sequence == null) {
                sequence = new Sequence();
                sequence.setType(key);
                sequence.setCurrentValue(StringUtils.leftPad(start + "", digits));
            } else {
                sequence.setCurrentValue(StringUtils.leftPad(sequence.getCurrentValue() + 1, digits));
            }

            return sequenceRepository.save(sequence).getCurrentValue();
        }
    }

    public enum Type {
        alphanumeric(0, true),
        numeric(1, true),
        uuid(2, false);

        private final int number;
        private final boolean resettable;

        Type(int number, boolean resettable) {
            this.number = number;
            this.resettable = resettable;
        }
    }
}
