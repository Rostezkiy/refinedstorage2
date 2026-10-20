package com.refinedmods.refinedstorage.common;

import com.refinedmods.refinedstorage.common.autocrafting.autocrafter.AutocrafterTest;
import com.refinedmods.refinedstorage.common.constructordestructor.ConstructorTest;
import com.refinedmods.refinedstorage.common.constructordestructor.DestructorTest;
import com.refinedmods.refinedstorage.common.controller.ControllerTest;
import com.refinedmods.refinedstorage.common.detector.DetectorTest;
import com.refinedmods.refinedstorage.common.exporter.ExporterTest;
import com.refinedmods.refinedstorage.common.iface.InterfaceTest;
import com.refinedmods.refinedstorage.common.importer.ImporterTest;
import com.refinedmods.refinedstorage.common.networking.CableLikePartsConnectionTest;
import com.refinedmods.refinedstorage.common.networking.FullBlocksConnectionTest;
import com.refinedmods.refinedstorage.common.networking.NetworkTransmitterReceiverTest;
import com.refinedmods.refinedstorage.common.networking.RelayTest;
import com.refinedmods.refinedstorage.common.storage.diskdrive.FluidDiskDriveTest;
import com.refinedmods.refinedstorage.common.storage.diskdrive.ItemDiskDriveTest;
import com.refinedmods.refinedstorage.common.storage.diskinterface.DiskInterfaceTest;
import com.refinedmods.refinedstorage.common.storage.externalstorage.FluidExternalStorageTest;
import com.refinedmods.refinedstorage.common.storage.externalstorage.ItemExternalStorageTest;
import com.refinedmods.refinedstorage.common.storage.storageblock.FluidStorageBlockTest;
import com.refinedmods.refinedstorage.common.storage.storageblock.ItemStorageBlockTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import com.google.common.base.CaseFormat;
import net.minecraft.gametest.framework.GameTestHelper;

/**
 * Discovers all methods annotated with {@link MinecraftIntegrationTest} and exposes them as game test functions.
 */
public final class MinecraftIntegrationTests {
    private static final List<Class<?>> TEST_CLASSES = List.of(
        AutocrafterTest.class,
        ConstructorTest.class,
        DestructorTest.class,
        ControllerTest.class,
        DetectorTest.class,
        ExporterTest.class,
        InterfaceTest.class,
        ImporterTest.class,
        NetworkTransmitterReceiverTest.class,
        CableLikePartsConnectionTest.class,
        FullBlocksConnectionTest.class,
        RelayTest.class,
        FluidDiskDriveTest.class,
        ItemDiskDriveTest.class,
        DiskInterfaceTest.class,
        FluidExternalStorageTest.class,
        ItemExternalStorageTest.class,
        FluidStorageBlockTest.class,
        ItemStorageBlockTest.class
    );

    private static final List<TestFunction> TEST_FUNCTIONS = discoverTestFunctions();

    private MinecraftIntegrationTests() {
    }

    public static List<TestFunction> getAll() {
        return TEST_FUNCTIONS;
    }

    public static Consumer<GameTestHelper> get(final Class<?> testClass, final String methodName) {
        return TEST_FUNCTIONS.stream()
            .filter(testFunction -> testFunction.testClass() == testClass
                && testFunction.methodName().equals(methodName))
            .findFirst()
            .map(TestFunction::handle)
            .orElseThrow(() -> new IllegalArgumentException(
                "No test function found for " + testClass.getName() + "#" + methodName
            ));
    }

    private static List<TestFunction> discoverTestFunctions() {
        final List<TestFunction> testFunctions = new ArrayList<>();
        final Set<String> testFunctionNames = new HashSet<>();
        for (final Class<?> testClass : TEST_CLASSES) {
            for (final Method method : testClass.getMethods()) {
                if (method.getAnnotation(MinecraftIntegrationTest.class) != null) {
                    final TestFunction testFunction = TestFunction.of(testClass, method);
                    if (!testFunctionNames.add(testFunction.name())) {
                        throw new IllegalStateException("Duplicate test function name: " + testFunction.name());
                    }
                    testFunctions.add(testFunction);
                }
            }
        }
        return List.copyOf(testFunctions);
    }

    /**
     * A single game test function.
     *
     * @param testClass  the class the test method is declared in
     * @param methodName the name of the test method
     * @param name       the unique name of the test function
     * @param handle     the test function itself
     */
    public record TestFunction(Class<?> testClass, String methodName, String name, Consumer<GameTestHelper> handle) {
        public static TestFunction of(final Class<?> testClass, final Method method) {
            final String name =
                CaseFormat.UPPER_CAMEL.to(
                    CaseFormat.LOWER_UNDERSCORE,
                    testClass.getSimpleName().replace("Test", "")
                ) + "_" + CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, method.getName());
            return new TestFunction(testClass, method.getName(), name, helper -> {
                try {
                    method.invoke(null, helper);
                } catch (final IllegalAccessException | InvocationTargetException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }
}
