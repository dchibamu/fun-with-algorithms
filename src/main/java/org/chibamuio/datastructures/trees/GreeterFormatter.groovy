package org.chibamuio.datastructures.trees;

import groovy.transform.CompileStatic;

@CompileStatic
class GreeterFormatter {

    static String greeting(final String name) {
        "Hello, ${name.capitalize()}"
    }
}
