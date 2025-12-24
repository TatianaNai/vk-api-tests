package ru.create_chat.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomGenerator {

    public static String randomStringWithLength(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static int randomIntWithBorders(int minNumber, int maxNumber) {
        return ThreadLocalRandom.current().nextInt(minNumber, maxNumber);
    }
}
