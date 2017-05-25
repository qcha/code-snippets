package com.github.qcha.source

class FileSource extends Source {
    private String uri
    private String username
    private String password

    void uri(String uri) {
        this.uri = uri
    }

    void username(String username) {
        this.username = username
    }

    void password(String password) {
        this.password = password
    }
}
