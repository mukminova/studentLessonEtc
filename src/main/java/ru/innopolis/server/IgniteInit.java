package ru.innopolis.server;

import org.apache.ignite.Ignition;

/**
 * Created by Li on 23.11.16.
 */
public class IgniteInit {

    public IgniteInit() {
        Ignition.start("ignite-config.xml");
    }
}
