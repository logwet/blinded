package me.logwet.blinded;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.SERVER)
public class BlindedServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        Blinded.onInitialize();

        Blinded.commonConfigHandler();
    }
}
