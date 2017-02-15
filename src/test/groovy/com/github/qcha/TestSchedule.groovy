package com.github.qcha

import groovy.transform.BaseScript

@BaseScript WorkflowScript flow

schedule {
    start '2017.01.01' // default now
    period 2.day // default 1.day
    offset 1 // default 0
    scope 2 // default 1
    mode merged //backward, default forward
    routine '*/1 * * * * *'
}


jobs {
    'Job_1' load {

    }
}