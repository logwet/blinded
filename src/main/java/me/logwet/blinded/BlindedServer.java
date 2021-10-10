package me.logwet.blinded;

import net.fabricmc.api.DedicatedServerModInitializer;
import org.apache.logging.log4j.Level;

public class BlindedServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        Blinded.onInitialize();

        Blinded.commonConfigHandler();
    }
}
