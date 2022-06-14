package com.myproj.delizioso.common

interface EventHandler<E> {
    fun obtainEvent(event: E)
}