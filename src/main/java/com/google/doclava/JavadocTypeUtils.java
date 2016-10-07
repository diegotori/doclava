package com.google.doclava;

import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;

/**
 * Simple Javadoc {@link Type} utility class that safely retrieves values by catching the
 * uncaught Exceptions that occur due to certain type such as Generic types.
 *
 * Created by diegotori on 10/6/16.
 */

final class JavadocTypeUtils {

    private JavadocTypeUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Safely gets the {@link #toString()} value of the given {@link Type}. Otherwise, it falls
     * back to {@link Type#qualifiedTypeName()}.
     * @param t the Type to use
     * @return the value of {@link Type#toString()}. Otherwise, the value of
     * {@link Type#qualifiedTypeName()}.
     */
    static String toStringOrQualifiedTypeName(final Type t){
        if(t == null){
            throw new IllegalArgumentException("Please use a valid Type instance");
        }
        String className;
        try {
            className =  t.toString();
        } catch (Exception e){
            className = t.qualifiedTypeName();
        }
        return className;
    }

    /**
     * Safely gets the {@link #toString()} value of the given {@link Type}. Otherwise, it falls
     * back to {@link Type#typeName()}.
     * @param t the Type to use
     * @return the value of {@link Type#toString()}. Otherwise, the value of
     * {@link Type#typeName()}.
     */
    static String toStringOrTypeName(final Type t){
        if(t == null){
            throw new IllegalArgumentException("Please use a valid Type instance");
        }
        String className;
        try {
            className =  t.toString();
        } catch (Exception e){
            className = t.typeName();
        }
        return className;
    }

    /**
     * Safely gets the bounds of the given {@link TypeVariable}.
     * @param t the TypeVariable to use.
     * @return the TypeVariable's bounds, or {@code null} if there are none, or if there was an
     * error in getting them.
     */
    static Type[] safelyGetTypeVariableBounds(final TypeVariable t){
        if(t == null){
            throw new IllegalArgumentException("Please use a valid Type instance");
        }
        Type[] bounds = null;
        try {
            bounds = t.bounds();
        } catch (Exception ignored) {
        }
        return bounds;
    }
}
