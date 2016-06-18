package com.kampana.dropkid.objects;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

/**
 * Created by daniell on 11/06/16.
 */
public class Kid {
    public static final String JSON_NAME = "name";
    public static final String JSON_IMAGE_PATH = "imagePath";
    public static final String JSON_DROP_OFF_TIME = "dropOffTime";
    public static final String JSON_PICKUP_TIME = "pickupTime";
    private URI image;
    private String name;
    private String dropOffTime;
    private String pickupTime;

    public Kid() {};

    public Kid(URI image, String name, String dropOffTime, String pickupTime) {
        this.image = image;
        this.name = name;
        this.dropOffTime = dropOffTime;
        this.pickupTime = pickupTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kid child = (Kid) o;

        if (image != null ? !image.equals(child.image) : child.image != null)
            return false;
        if (name != null ? !name.equals(child.name) : child.name != null)
            return false;
        if (dropOffTime != null ? !dropOffTime.equals(child.dropOffTime) : child.dropOffTime != null)
            return false;
        return pickupTime != null ? pickupTime.equals(child.pickupTime) : child.pickupTime == null;

    }

    @Override
    public int hashCode() {
        int result = image != null ? image.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dropOffTime != null ? dropOffTime.hashCode() : 0);
        result = 31 * result + (pickupTime != null ? pickupTime.hashCode() : 0);
        return result;
    }

    public URI getImage() {
        return image;
    }

    public String getImagePath() {
        if (getImage() != null) {
            return getImage().getPath();
        }
        return null;
    }

    public void setImage(URI image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(String dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }


    public String toJSON(){
        JSONObject jsonObject= new JSONObject();
        try {
            jsonObject.put(JSON_NAME, getName());
            jsonObject.put(JSON_IMAGE_PATH, getImagePath());
            jsonObject.put(JSON_DROP_OFF_TIME, getDropOffTime());
            jsonObject.put(JSON_PICKUP_TIME, getPickupTime());
            return jsonObject.toString();
        } catch (JSONException e) {
            Log.e(this.getClass().getName(), "Failed parsing json to string",e);
            return "";
        }
    }

    public void fromJSON(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        setName(jsonObject.getString(JSON_NAME));
        setImage(URI.create(jsonObject.getString(JSON_IMAGE_PATH)));
        setDropOffTime(jsonObject.getString(JSON_DROP_OFF_TIME));
        setPickupTime(jsonObject.getString(JSON_PICKUP_TIME));
    }
}
