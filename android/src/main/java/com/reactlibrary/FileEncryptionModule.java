// FileEncryptionModule.java

package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.Callback;

import tgio.rncryptor.RNCryptorNative;
import java.io.File;

public class FileEncryptionModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public FileEncryptionModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "FileEncryption";
    }

     @ReactMethod
    public void encryptFile(String readPath, String writePath, String password, Promise promise) {
        try {
            RNCryptorNative.encryptFile(new File(readPath), new File(writePath), password);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject("error", e);
        }
    }

    @ReactMethod
    public void decryptFile(String readPath, String writePath, String password, Promise promise) {
        try {
            RNCryptorNative.decryptFile(new File(readPath), new File(writePath), password);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject("error", e);
        }
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }
}
