package com.example.security.service;

public interface IMetadata<T> {
    T extractData();
    void uploadData(T data);
}
