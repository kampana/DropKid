package com.kampana.dropkid.objects;

import java.net.URI;
import java.util.Date;

/**
 * Created by daniell on 11/06/16.
 */
public class Kid {
    private URI image;
    private String name;
    private Date dropOffTime;
    private Date pickupTime;

    public Kid(URI image, String name, Date dropOffTime, Date pickupTime) {
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

    public void setImage(URI image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(Date dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }
}
