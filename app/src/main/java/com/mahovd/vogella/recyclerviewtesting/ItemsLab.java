package com.mahovd.vogella.recyclerviewtesting;

import android.content.Context;

import java.util.ArrayList;


/**
 * Created by mahovd on 22/11/15.
 * Model
 */
public class ItemsLab extends ArrayList<String>{

    private static ItemsLab sItemsLab;
    private ArrayList<String> mItems;

    public static ItemsLab get(Context context){
        if(sItemsLab == null){
            sItemsLab = new ItemsLab(context);
        }
        return sItemsLab;
    }

    private ItemsLab(Context context) {
        mItems = new ArrayList<>();

        for(int i=0;i<100;i++){
            mItems.add("TestString "+i);
        }
    }

    public ArrayList<String> getItems(){
        return mItems;
    }
}
