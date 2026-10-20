package com.refinedmods.refinedstorage.fabric.gametest;

import com.refinedmods.refinedstorage.common.MinecraftIntegrationTests;
import com.refinedmods.refinedstorage.common.storage.externalstorage.FluidExternalStorageTest;

import java.lang.reflect.Method;

import net.fabricmc.fabric.api.gametest.v1.CustomTestMethodInvoker;
import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;

/**
 * Fabric game test entrypoint for {@link FluidExternalStorageTest}.
 */
public class FluidExternalStorageGameTests implements CustomTestMethodInvoker {
    @Override
    public void invokeTestMethod(final GameTestHelper helper, final Method method) {
        MinecraftIntegrationTests.get(FluidExternalStorageTest.class, method.getName()).accept(helper);
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldExpose(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldInsertAllowlist(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldInsertBlocklist(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPropagateExternalExtractions(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPropagatePartialExternalExtractions(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldPropagateExternalInsertions(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }
}
