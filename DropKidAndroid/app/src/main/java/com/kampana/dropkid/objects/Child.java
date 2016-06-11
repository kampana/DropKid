package com.kampana.dropkid.objects;

import java.net.URI;
import java.util.Date;

/**
 * Created by daniell on 11/06/16.
 */
public class Child {
    private URI childImage;
    private String childName;
    private Date dropOffTime;
    private Date pickupTime;

    public Child(URI childImage, String childName, Date dropOffTime, Date pickupTime) {
        this.childImage = childImage;
        this.childName = childName;
        this.dropOffTime = dropOffTime;
        this.pickupTime = pickupTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;

        if (childImage != null ? !childImage.equals(child.childImage) : child.childImage != null)
            return false;
        if (childName != null ? !childName.equals(child.childName) : child.childName != null)
            return false;
        if (dropOffTime != null ? !dropOffTime.equals(child.dropOffTime) : child.dropOffTime != null)
            return false;
        return pickupTime != null ? pickupTime.equals(child.pickupTime) : child.pickupTime == null;

    }

    @Override
    public int hashCode() {
        int result = childImage != null ? childImage.hashCode() : 0;
        result = 31 * result + (childName != null ? childName.hashCode() : 0);
        result = 31 * result + (dropOffTime != null ? dropOffTime.hashCode() : 0);
        result = 31 * result + (pickupTime != null ? pickupTime.hashCode() : 0);
        return result;
    }

    public URI getChildImage() {
        return childImage;
    }

    public void setChildImage(URI childImage) {
        this.childImage = childImage;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
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
