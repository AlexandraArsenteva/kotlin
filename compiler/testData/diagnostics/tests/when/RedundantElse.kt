/*
 * KOTLIN DIAGNOSTICS SPEC TEST (NEGATIVE)
 *
 * SPEC VERSION: 0.1-152
 * PRIMARY LINKS: expressions, when-expression -> paragraph 5 -> sentence 1
 * expressions, when-expression, exhaustive-when-expressions -> paragraph 2 -> sentence 3
 * expressions, when-expression, exhaustive-when-expressions -> paragraph 2 -> sentence 6
 * expressions, when-expression, exhaustive-when-expressions -> paragraph 2 -> sentence 9
 * expressions, when-expression -> paragraph 6 -> sentence 10
 * expressions, when-expression -> paragraph 6 -> sentence 11
 */

// FILE: MyEnum.java
public enum MyEnum {
    SINGLE;

    public static MyEnum getInstance() {
        return SINGLE;
    }
}


// FILE: test.kt

sealed class X {
    class A : X()
    class B : X()
}

fun foo(x: X) = when (x) {
    is X.A -> {}
    is X.B -> {}
    <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> {}
}

fun barWithNull(x: X?): String = when (x) {
    is X.A -> "A"
    is X.B -> "B"
    null -> "null"
    <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> "Unreachable"
}

fun bar(x: X?): String = when (x) {
    is X.A -> "A"
    is X.B -> "B"
    else -> "" // no warning
}

fun justUse(x: X) {
    when (x) {
        is X.A -> {}
        is X.B -> {}
        // Redundant even in statement position
        <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> {}
    }
}

enum class E {
    A, B
}

fun foo(e: E): String = when (e) {
    E.A -> "A"
    E.B -> "B"
    <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> ""
}

fun bar(e: E?): String = when (e) {
    E.A -> "A"
    E.B -> "B"
    else -> "" // no warning
}

fun barWithNull(e: E?): String = when (e) {
    E.A -> "A"
    E.B -> "B"
    null -> ""
    <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> ""
}

fun justUse(e: E) {
    when (e) {
        E.A -> "A"
        E.B -> "B"
        // Redundant even in statement position
        <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> {}
    }
}

fun foo(b: Boolean) = when (b) {
    true -> 1
    false -> 0
    <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> -1
}

fun justUse(b: Boolean) {
    when (b) {
        true -> 1
        false -> 0
        // Redundant even in statement position
        <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> -1
    }
}

fun barWithNull(b: Boolean?) = when (b) {
    true -> "1"
    false -> "2"
    null -> "3"
    <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> "0"
}

fun bar(b: Boolean?): String = when (b) {
    true -> "1"
    false -> "0"
    else -> "" // no warning
}

fun useJava(): String {
    val me = MyEnum.getInstance()
    return when (me) {
        MyEnum.SINGLE -> "OK"
        else -> "FAIL" // no warning
    }
}
