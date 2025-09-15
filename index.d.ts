declare module 'react-native-file-encryption' {
  export interface FileEncryptionModule {
    /**
     * Encrypt a file using the provided password
     * @param readPath - Path to the file to encrypt
     * @param writePath - Path where the encrypted file will be saved
     * @param password - Password to use for encryption
     * @returns Promise that resolves to true on success
     */
    encryptFile(readPath: string, writePath: string, password: string): Promise<boolean>;

    /**
     * Decrypt a file using the provided password
     * @param readPath - Path to the encrypted file
     * @param writePath - Path where the decrypted file will be saved
     * @param password - Password to use for decryption
     * @returns Promise that resolves to true on success
     */
    decryptFile(readPath: string, writePath: string, password: string): Promise<boolean>;
  }

  const FileEncryption: FileEncryptionModule;
  export const encryptFile: FileEncryptionModule['encryptFile'];
  export const decryptFile: FileEncryptionModule['decryptFile'];
  export default FileEncryption;
}
