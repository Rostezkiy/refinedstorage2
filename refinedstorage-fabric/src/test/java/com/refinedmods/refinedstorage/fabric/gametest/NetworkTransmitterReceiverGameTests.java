package com.refinedmods.refinedstorage.fabric.gametest;

import com.refinedmods.refinedstorage.common.MinecraftIntegrationTests;
import com.refinedmods.refinedstorage.common.networking.NetworkTransmitterReceiverTest;

import java.lang.reflect.Method;

import net.fabricmc.fabric.api.gametest.v1.CustomTestMethodInvoker;
import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;

/**
 * Fabric game test entrypoint for {@link NetworkTransmitterReceiverTest}.
 */
public class NetworkTransmitterReceiverGameTests implements CustomTestMethodInvoker {
    @Override
    public void invokeTestMethod(final GameTestHelper helper, final Method method) {
        MinecraftIntegrationTests.get(NetworkTransmitterReceiverTest.class, method.getName()).accept(helper);
    }

    @GameTest(structure = "refinedstorage:empty_15x15", maxTicks = 400)
    public void shouldTransmitAndReceiveNetworkInSameDimension(final GameTestHelper helper) {
        throw new UnsupportedOperationException("Invoked through invokeTestMethod");
    }
}
