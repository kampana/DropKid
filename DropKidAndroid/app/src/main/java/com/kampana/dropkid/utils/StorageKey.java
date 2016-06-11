package com.kampana.dropkid.utils;

public enum StorageKey {
        CHILD_NAME("childName"),
        DROP_OFF_TIME("childName"),
        PICKUP_TIME("childName"),
        CHILD_IMAGE("childImage");

        private String key;

        StorageKey(String key) {
            this.key = key;
        }

        public String getStorageKey(String childId) {
            return childId + "_" + key;
        }

    }