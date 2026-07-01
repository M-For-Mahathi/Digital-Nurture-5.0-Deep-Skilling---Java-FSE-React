package com.example;

public class Exercise1_3MyService {
    private Exercise1_3ExternalApi api;

    public Exercise1_3MyService(Exercise1_3ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}
