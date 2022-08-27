package com.dev.myclinique.utils;

public class Enumeration {

    public enum ROOM_TYPE {
        General("Général"),
        Delux("Luxe"),
        Super_Delux("Super luxe");

        private final String desc;

        ROOM_TYPE(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    public enum BILL_STATE {
        Paid("Payé"),
        Unpaid("Pas apyé");

        private final String desc;

        BILL_STATE(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    public enum TYPE_CATEGORY {
        Medicine("Médicament"),
        Other("Autre");

        private final String desc;

        TYPE_CATEGORY(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }
}
