package com.github.qcha

import com.github.qcha.source.Source
import com.github.qcha.source.SourceScript

class ImportJob<T extends Source> extends Job {
    private T source

    T source(Class<? extends SourceScript<T>> source) {
        this.source = source.newInstance().with {
            run()
            it.source
        }
    }
}
