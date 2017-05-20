package com.coulcod.triangleview.util;

import android.support.annotation.Nullable;

/**
 * Created by {@author coulcod} on 20.05.17.
 */

public class Assertion {

    public static void nonnull(@Nullable Object obj) {
        if (obj == null) throw new AssertionException();
    }

    public static void assertTrue(boolean conduction) {
        if (!conduction) throw new AssertionException();
    }

}
