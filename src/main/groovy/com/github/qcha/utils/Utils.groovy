package com.github.qcha.utils

import static groovy.lang.Closure.DELEGATE_FIRST
import com.google.common.collect.Iterators

class Utils {
    static <T> T delegate(T object, Closure closure) {
        closure.delegate = object
        closure.resolveStrategy = DELEGATE_FIRST
        closure()
        object
    }

    static getArgument(arguments) {
        Iterators.getOnlyElement(Iterators.forArray(arguments as Object[]))
    }
}