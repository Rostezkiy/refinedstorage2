package com.refinedmods.refinedstorage.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;

import static com.refinedmods.refinedstorage.common.util.IdentifierUtil.MOD_ID;
import static com.refinedmods.refinedstorage.common.util.IdentifierUtil.createIdentifier;

@EventBusSubscriber(modid = MOD_ID)
public class RegisterTests {
    private static final boolean GENERATE_INSTANCE_JSONS = true;

    private RegisterTests() {
    }

    @SubscribeEvent
    public static void registerTests(final RegisterEvent e) {
        final List<MinecraftIntegrationTests.TestFunction> testFunctions = MinecraftIntegrationTests.getAll();
        if (GENERATE_INSTANCE_JSONS) {
            testFunctions.forEach(RegisterTests::generateInstanceJson);
        }
        e.register(Registries.TEST_FUNCTION, helper ->
            testFunctions.forEach(testFunction ->
                helper.register(createIdentifier(testFunction.name()), testFunction.handle())));
    }

    private static void generateInstanceJson(final MinecraftIntegrationTests.TestFunction testFunction) {
        final String path =
            "../src/test/resources/data/" + MOD_ID + "/test_instance/%s.json".formatted(testFunction.name());
        try {
            Files.writeString(Path.of(path), """
                {
                  "type": "minecraft:function",
                  "function": "%s:%s",
                  "structure": "%s:empty_15x15",
                  "environment": "minecraft:default",
                  "max_ticks": 400
                }
                """.formatted(MOD_ID, testFunction.name(), MOD_ID));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
