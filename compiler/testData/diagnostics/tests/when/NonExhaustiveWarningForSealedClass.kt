// LANGUAGE: +WarnAboutNonExhaustiveWhenOnAlgebraicTypes
/*
 * KOTLIN DIAGNOSTICS SPEC TEST (NEGATIVE)
 *
 * SPEC VERSION: 0.1-152
 * PRIMARY LINKS: expressions, when-expression -> paragraph 5 -> sentence 1
 * expressions, when-expression, exhaustive-when-expressions -> paragraph 1 -> sentence 1
 * expressions, when-expression, exhaustive-when-expressions -> paragraph 2 -> sentence 6
 * expressions, when-expression, exhaustive-when-expressions -> paragraph 2 -> sentence 7
 * expressions, when-expression -> paragraph 9 -> sentence 2
 * expressions, when-expression, exhaustive-when-expressions -> paragraph 3 -> sentence 1
 * type-inference, smart-casts, smart-cast-types -> paragraph 9 -> sentence 1
 */

sealed class S

object First : S()

class Derived(val s: String) : S()

object Last : S()

fun use(s: String) = s

fun foo(s: S) {
    <!NO_ELSE_IN_WHEN!>when<!> (s) {
        First -> {}
        is Derived -> use(<!DEBUG_INFO_SMARTCAST!>s<!>.s)
    }
}

fun bar(s: S): Int {
    return <!NO_ELSE_IN_WHEN!>when<!> (s) {
        First -> 1
        is Derived -> 2
    }
}

fun test1(s: S?) : Int {
    if (s == null) {
        return 0
    }
    <!NO_ELSE_IN_WHEN!>when<!> (<!DEBUG_INFO_SMARTCAST!>s<!>) {
        First -> 1
    }
    return 1
}

fun test2(s: S?): Int {
    if (s == null) {
        return 0
    }
    return <!NO_ELSE_IN_WHEN!>when<!> (<!DEBUG_INFO_SMARTCAST!>s<!>) {
        First -> 1
    }
}

fun test3(s: S?) : Int {
    return <!NO_ELSE_IN_WHEN!>when<!> (s) {
        First -> 1
        is Derived -> 2
    }
}

fun test4(s: S?) : Int {
    return <!NO_ELSE_IN_WHEN!>when<!> (s) {
        First -> 1
        null -> 2
    }
}
