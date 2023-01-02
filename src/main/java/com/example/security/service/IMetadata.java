package com.example.security.service;

import java.util.List;

public interface IMetadata<T> {
    List<T> extractData();
    void uploadData(T data);
}
