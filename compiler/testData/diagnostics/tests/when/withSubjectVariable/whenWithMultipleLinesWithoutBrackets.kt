fun test(x: Int) {
    var y = 1
    when (x) {
        10 ->
            y=10+1
            <!ASSIGNMENT_IN_EXPRESSION_CONTEXT!>y=y+1<!><!SYNTAX!><!>
    }
}