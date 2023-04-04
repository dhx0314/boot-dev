package cn.dhx.enums;

public enum CallDirectEnum {

    IN("in"),
    OUT("out");

    String type;

    CallDirectEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}
