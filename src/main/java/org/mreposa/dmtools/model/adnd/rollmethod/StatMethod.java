package org.mreposa.dmtools.model.adnd.rollmethod;

import java.util.Random;

public abstract class StatMethod {
    public static final String[] AVAILABLE_METHODS = {"3d6", "5d6 best three", "4d6 drop lowest", "3d6 six times take best"};

    public abstract int generate(Random rand);
}
