package com.github.qcha

class Schedule {
    private static enum Mode {
        FORWARD,
        BACKWARD,
        MERGED
    }

    static final Mode forward = Mode.FORWARD

    static final Mode backward = Mode.FORWARD

    static final Mode merged = Mode.MERGED

    private String start
    private Period period
    private Integer offset
    private Integer scope
    private Mode mode
    private String routine

    void start(String start) {
        this.start = start
    }

    void period(Period period) {
        this.period = period
    }

    void offset(Integer offset) {
        this.offset = offset
    }

    void scope(Integer scope) {
        this.scope = scope
    }

    void mode(Mode mode) {
        this.mode = mode
    }

    void routine(String routine) {
        this.routine = routine
    }
}
