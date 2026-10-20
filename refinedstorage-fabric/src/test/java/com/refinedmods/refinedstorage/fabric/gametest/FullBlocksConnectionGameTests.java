package com.refinedmods.refinedstorage.fabric.gametest;

import com.refinedmods.refinedstorage.common.MinecraftIntegrationTests;
import com.refinedmods.refinedstorage.common.networking.FullBlocksConnectionTest;

import java.lang.reflect.Method;

import net.fabricmc.fabric.api.gametest.v1.CustomTestMethodInvoker;
import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;

/**
 * Fabric game test entrypoint for {@link FullBlocksConnectionTest}.
 */
public class FullBlocksConnectionGameTests implements CustomTestMethodInvoker {
    @Override
    public void invokeTestMethod(final GameTestHelper helper, final Method method) {
        MinecraftIntegrationTests.get(FullBlocksConnectionTest.class, method.getName()).accept(helper);
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldConnectDefaultBlocksToDefaultCable(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldConnectDefaultBlocksToAnyColoredCable(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldConnectColoredBlocksToDefaultCable(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldConnectAnyColoredBlocksToAnyColoredCable(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }
}
