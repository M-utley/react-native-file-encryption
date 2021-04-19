// main index.js

import { NativeModules } from "react-native";

const { FileEncryption } = NativeModules;

export const { encryptFile, decryptFile } = FileEncryption;

export default FileEncryption;
