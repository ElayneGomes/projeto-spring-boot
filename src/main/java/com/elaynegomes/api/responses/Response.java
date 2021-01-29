package com.elaynegomes.api.responses;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
    private T data;
    private List<String> erros;

    public Response() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        if(this.erros == null) {
            this.erros = new ArrayList<String>();
        }
        return erros;
    }
}
