package com.github.qcha

class LoadJob extends Job {
    Source source

    String target

    Source source(String source) {
        this.source = new Source(source)
    }

    void target(String target) {
        this.target = target
    }
}