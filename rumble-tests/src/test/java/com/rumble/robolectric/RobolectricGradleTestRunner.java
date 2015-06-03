package com.rumble.robolectric;

import org.junit.runners.model.InitializationError;
import org.robolectric.AndroidManifest;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.res.Fs;

/**
 * Created by Davidf on 13/01/2015.
 */
public class RobolectricGradleTestRunner extends RobolectricTestRunner {

    private static final int MAX_SDK_SUPPORTED_BY_ROBOLECTRIC = 18;
    private final String buildVariant;

    /**
     * Creates a runner to run {@code testClass}. Looks in your working directory for your AndroidManifest.xml file
     * and res directory by default. Use the {@link Config} annotation to configure.
     *
     * @param testClass the test class to be run
     * @throws org.junit.runners.model.InitializationError if junit says so
     */
    public RobolectricGradleTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
        buildVariant = (com.rumble.BuildConfig.FLAVOR.isEmpty() ? "" : com.rumble.BuildConfig.FLAVOR + "/") + com.rumble.BuildConfig.BUILD_TYPE;
        System.setProperty("android.package", com.rumble.BuildConfig.APPLICATION_ID);
//        System.setProperty("android.manifest", "../app/build/intermediates/manifests/full/" + buildVariant + "/AndroidManifest.xml");
//        System.setProperty("android.resources", "../app/build/intermediates/res/" + buildVariant);
//        System.setProperty("android.assets", "../app/build/intermediates/assets/" + buildVariant);

    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        String manifestPath = "../rumble-sample/build/intermediates/manifests/full/" + buildVariant + "/AndroidManifest.xml";
        String resPath = "../rumble-sample/build/intermediates/res/" + buildVariant;
        String assetPath = "../rumble-sample/build/intermediates/assets/" + buildVariant;
        return new AndroidManifest( Fs.fileFromPath(manifestPath), Fs.fileFromPath(resPath), Fs.fileFromPath(assetPath)) {
            @Override
            public int getTargetSdkVersion() {
                return MAX_SDK_SUPPORTED_BY_ROBOLECTRIC;
            }
        };
    }
}
