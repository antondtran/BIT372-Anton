package com.example.unitcoverter;

import androidx.lifecycle.MutableLiveData;

public class User {
    public MutableLiveData<String> name;

    public User(String name) {
        this.name = new MutableLiveData<>();
        this.name.setValue(name);
    }
}
