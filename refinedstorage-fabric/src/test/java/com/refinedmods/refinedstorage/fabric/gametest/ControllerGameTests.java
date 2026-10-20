package com.refinedmods.refinedstorage.fabric.gametest;

import com.refinedmods.refinedstorage.common.MinecraftIntegrationTests;
import com.refinedmods.refinedstorage.common.controller.ControllerTest;

import java.lang.reflect.Method;

import net.fabricmc.fabric.api.gametest.v1.CustomTestMethodInvoker;
import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;

/**
 * Fabric game test entrypoint for {@link ControllerTest}.
 */
public class ControllerGameTests implements CustomTestMethodInvoker {
    @Override
    public void invokeTestMethod(final GameTestHelper helper, final Method method) {
        MinecraftIntegrationTests.get(ControllerTest.class, method.getName()).accept(helper);
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldConsumeEnergy(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldNotConsumeEnergy(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }
}
