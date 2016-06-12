package com.kampana.dropkid.utils;

import com.kampana.dropkid.objects.Kid;

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
}
