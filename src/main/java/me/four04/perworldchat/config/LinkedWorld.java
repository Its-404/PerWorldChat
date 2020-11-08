package me.four04.perworldchat.config;

import java.util.List;

public class LinkedWorld {

    private final List<String> linkedWorldNames;

    public LinkedWorld(List<String> linked) {
        this.linkedWorldNames = linked;
    }

    public List<String> getLinkedWorldNames() {
        return this.linkedWorldNames;
    }
}
