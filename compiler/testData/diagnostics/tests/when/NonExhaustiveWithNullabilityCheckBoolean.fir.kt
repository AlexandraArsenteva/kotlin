fun foo(arg: Boolean?): Int {
    if (arg != null) {
        return <!NO_ELSE_IN_WHEN!>when<!> (arg) {
            true -> 1
        }
    }
    else {
        return -1
    }
}

fun bar(arg: Boolean?): Int {
    var x = 0
    if (arg != null) {
        <!NO_ELSE_IN_WHEN!>when<!> (arg) {
            true -> x = 1
        }
        return x
    }
    else {
        return -1
    }
}
