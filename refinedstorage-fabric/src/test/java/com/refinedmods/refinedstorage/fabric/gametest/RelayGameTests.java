package com.refinedmods.refinedstorage.fabric.gametest;

import com.refinedmods.refinedstorage.common.MinecraftIntegrationTests;
import com.refinedmods.refinedstorage.common.networking.RelayTest;

import java.lang.reflect.Method;

import net.fabricmc.fabric.api.gametest.v1.CustomTestMethodInvoker;
import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;

/**
 * Fabric game test entrypoint for {@link RelayTest}.
 */
public class RelayGameTests implements CustomTestMethodInvoker {
    @Override
    public void invokeTestMethod(final GameTestHelper helper, final Method method) {
        MinecraftIntegrationTests.get(RelayTest.class, method.getName()).accept(helper);
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughAll(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldNotPassThrough(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughEnergy(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughStorage(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughStorageBlocklist(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughStorageFuzzyBlocklist(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughStorageAllowlist(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughStorageFuzzyAllowlist(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughStorageAndInsertExtract(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughStorageAndInsert(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughStorageAndExtract(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughStorageAndRespectInsertPriority(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughStorageAndRespectExtractPriority(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughAutocraftingRootNetwork(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPassThroughAutocraftingSubNetwork(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }
}
