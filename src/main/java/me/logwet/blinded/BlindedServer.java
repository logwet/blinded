package me.logwet.blinded;

import net.fabricmc.api.DedicatedServerModInitializer;
import org.apache.logging.log4j.Level;

public class BlindedServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        Blinded.log(Level.INFO, "Using Blinded v" + Blinded.VERSION + " by logwet!");

        Blinded.commonConfigHandler();
    }
}
