/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.pipesnfilters;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class Pipeline<T> implements Pipe<T> {

    private List<Filter> filters;
    private int index;

    public Pipeline() {
        this.filters = new ArrayList<>();
        this.index = -1;
    }

    @Override
    public void nextFilter(Filter siguienteFiltro) {
        filters.add(siguienteFiltro);
    }

    @Override
    public T process(T data) throws Exception {
        for (Filter filter : this.filters) {
            filter.process(data);
        }
        return data;
    }

    @Override
    public Filter getTarget() {
        if (!this.filters.isEmpty()) {
            this.index = this.filters.size();
            return this.filters.get(this.index);
        }
        return null;
    }

}
