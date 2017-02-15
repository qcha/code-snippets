package com.github.qcha

import static com.github.qcha.utils.Utils.delegate
import static groovy.lang.Closure.DELEGATE_FIRST

abstract class WorkflowScript extends Script {
    private Schedule schedule = new Schedule()
    private Jobs jobs = new Jobs()

    void schedule(@DelegatesTo(strategy = DELEGATE_FIRST, value = Schedule) Closure closure) {
        delegate(schedule, closure)
    }

    void jobs(@DelegatesTo(strategy = DELEGATE_FIRST, value = Jobs) Closure closure) {
        delegate(jobs, closure)
    }
}
