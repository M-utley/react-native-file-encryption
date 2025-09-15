// FileEncryptionModule.java

package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.Callback;

import tgio.rncryptor.RNCryptorNative;
import java.io.File;
import java.net.URI;

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

    /**
     * Converts a URI or file path to a proper File object
     * Handles both file:// URIs and direct file system paths
     */
    private File getFileFromPath(String path) {
        try {
            // If it's a file:// URI, convert to file system path
            if (path.startsWith("file://")) {
                URI uri = new URI(path);
                return new File(uri.getPath());
            } else {
                // Direct file system path
                return new File(path);
            }
        } catch (Exception e) {
            // Fallback to treating as direct path
            return new File(path);
        }
    }

    /**
     * Validates that a file exists and is readable
     */
    private boolean validateInputFile(File file, Promise promise) {
        if (!file.exists()) {
            promise.reject("error", "Input file does not exist: " + file.getAbsolutePath());
            return false;
        }
        if (!file.canRead()) {
            promise.reject("error", "Cannot read input file: " + file.getAbsolutePath());
            return false;
        }
        return true;
    }

    /**
     * Ensures the output directory exists and file is writable
     */
    private boolean validateOutputFile(File file, Promise promise) {
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                promise.reject("error", "Cannot create output directory: " + parentDir.getAbsolutePath());
                return false;
            }
        }
        return true;
    }

     @ReactMethod
    public void encryptFile(String readPath, String writePath, String password, Promise promise) {
        try {
            File inputFile = getFileFromPath(readPath);
            File outputFile = getFileFromPath(writePath);
            
            // Validate input file
            if (!validateInputFile(inputFile, promise)) {
                return;
            }
            
            // Validate output file
            if (!validateOutputFile(outputFile, promise)) {
                return;
            }
            
            RNCryptorNative.encryptFile(inputFile, outputFile, password);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject("error", e);
        }
    }

    @ReactMethod
    public void decryptFile(String readPath, String writePath, String password, Promise promise) {
        try {
            File inputFile = getFileFromPath(readPath);
            File outputFile = getFileFromPath(writePath);
            
            // Validate input file
            if (!validateInputFile(inputFile, promise)) {
                return;
            }
            
            // Validate output file
            if (!validateOutputFile(outputFile, promise)) {
                return;
            }
            
            RNCryptorNative.decryptFile(inputFile, outputFile, password);
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
