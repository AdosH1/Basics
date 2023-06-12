fun <T, R> List<T>.Reduce (f: (a: T, acc: R) -> R, acc: R) : R {
    var mut_acc = acc;
    for (e in this) {
        mut_acc = f(e, mut_acc);
    }
    return mut_acc;
}

fun <T, R> List<T>.Map (f: (a: T) -> R) : List<R> {
    var res = mutableListOf<R>();
    for (e in this) {
        res.add(f(e));
    }
    return res
}

fun <T> List<T>.Filter (f: (a: T) -> Boolean) : List<T> {
    var res = mutableListOf<T>();
    for (e in this) {
        if (f(e)) {
            res.add(e);
        }
    }
    return res
}

fun <T, R> List<T>.Unfold (f: (a : T) -> List<R>) : List<R> {
    var res = mutableListOf<R>();
    for (e in this) {
        val r = f(e);
        res.addAll(r);
    }
    return res;
}