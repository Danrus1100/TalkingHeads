package me.zipestudio.talkingheads.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class THClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        FabricLoader instance = FabricLoader.getInstance();

        if (!instance.getModContainer("plasmovoice").get().getMetadata().getVersion().getFriendlyString().startsWith("2.1")) {
            return;
        }

        if (instance.isModLoaded("plasmovoice")) {
            su.plo.voice.api.client.PlasmoVoiceClient.getAddonsLoader().load(new PlasmoVoiceAddon());
        }

    }

}
