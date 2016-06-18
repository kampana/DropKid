package com.kampana.dropkid.utils;

import com.kampana.dropkid.objects.Kid;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Uri on 12/06/2016.
 */
@Singleton
public class DataAccessLayer {

    @Inject StorageUtils storageUtils;

    /**
     * Adding a new kid, or overwriting existing one
     */
    public void saveKid(Kid kid) {
        storageUtils.writeString(kid.getName(),kid.toJSON());
    }

    /**
     * @return list of kids
     */
    public List<Kid> readKids() {
        List<Kid> kids = new ArrayList<>();
        Collection<String> allValues = storageUtils.readAllValues();
        for (String jsonKid : allValues) {
            Kid kid = new Kid();
            try {
                kid.fromJSON(jsonKid);
            } catch (JSONException e) {
                e.printStackTrace();//TODO URI handle logging
            }
            kids.add(kid);
        }
        return kids;
    }
}
