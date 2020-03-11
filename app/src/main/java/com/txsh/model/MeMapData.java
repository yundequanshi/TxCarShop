package com.txsh.model;

import java.io.Serializable;

/**
 * Created by Marcello on 2015/6/8.
 */
public class MeMapData implements Serializable{

    public int id;

    public String value;

    public MeMapData() {
    }
    public MeMapData(int id, String value) {
        this.id = id;
        this.value = value;
    }
}
