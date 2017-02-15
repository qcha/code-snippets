package com.github.qcha

import static com.github.qcha.utils.Utils.delegate
import static com.github.qcha.utils.Utils.getArgument
import static groovy.lang.Closure.DELEGATE_FIRST

class Jobs {
    private Set<Job> jobs

    def methodMissing(String name, arguments) {
        jobs << (getArgument(arguments) as Job)
    }

    void load(@DelegatesTo(strategy = DELEGATE_FIRST, value = LoadJob) Closure closure) {
        delegate(new LoadJob(), closure)
    }
}
