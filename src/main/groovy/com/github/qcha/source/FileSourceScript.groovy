package com.github.qcha.source

abstract class FileSourceScript extends SourceScript<FileSource> {
    @Delegate
    final FileSource source = new FileSource()
}