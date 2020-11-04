package me.four04.perworldchat.config;

import java.util.List;

public class LinkedWorlds {

    private final List<String> linkedWorldNames;

    public LinkedWorlds(List<String> linked) {
        this.linkedWorldNames = linked;
    }

    public List<String> getLinkedWorldNames() {
        return this.linkedWorldNames;
    }
}
