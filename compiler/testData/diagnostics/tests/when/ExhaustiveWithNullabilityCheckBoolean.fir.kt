/*
 * KOTLIN DIAGNOSTICS SPEC TEST (POSITIVE)
 *
 * SPEC VERSION: 0.1-152
 * PRIMARY LINKS: expressions, when-expression -> paragraph 5 -> sentence 1
 * expressions, when-expression, exhaustive-when-expressions -> paragraph 2 -> sentence 3
 * expressions, when-expression, exhaustive-when-expressions -> paragraph 2 -> sentence 4
 * expressions, when-expression, exhaustive-when-expressions -> paragraph 2 -> sentence 5
 * type-inference, smart-casts, smart-cast-types -> paragraph 9 -> sentence 1
 */

// KT-7857: when exhaustiveness does not take previous nullability checks into account
fun foo(arg: Boolean?): Int {
    if (arg != null) {
        return when (arg) {
            true -> 1
            false -> 0
            // else or null branch should not be required here!
        }
    } 
    else {
        return -1
    }
}

//check for statements
fun bar(arg: Boolean?): Int {
    var x = 1
    if (arg != null) {
        when (arg) {
            true -> x = 1
            false -> x = 0
            // else or null branch should not be required here!
        }
        return x
    }
    else {
        return -1
    }
}
