# React Native File Encryption

A React Native module for file encryption using RNCryptor with 16KB page size support for Android 15+.

## Features

- ✅ **AES-256 encryption** using RNCryptor
- ✅ **16KB page size support** for Android 15+
- ✅ **Cross-platform** (Android & iOS)
- ✅ **TypeScript support**
- ✅ **Modern Gradle** (8.1.4) and Java 17
- ✅ **File path validation** and error handling

## Installation

```bash
npm install @skunkwerkz/react-native-file-encryption
```

### iOS Setup

Add to your `ios/Podfile`:

```ruby
pod 'react-native-file-encryption', :path => '../node_modules/@skunkwerkz/react-native-file-encryption'
```

Then run:

```bash
cd ios && pod install
```

### Android Setup

No additional setup required for Android.

## Usage

```javascript
import FileEncryption from '@skunkwerkz/react-native-file-encryption';

// Encrypt a file
await FileEncryption.encryptFile(
  '/path/to/input/file.pdf',
  '/path/to/output/file.enc',
  'your-password'
);

// Decrypt a file
await FileEncryption.decryptFile(
  '/path/to/encrypted/file.enc',
  '/path/to/output/file.pdf',
  'your-password'
);
```

## API

### `encryptFile(inputPath, outputPath, password)`

Encrypts a file using AES-256 encryption.

**Parameters:**
- `inputPath` (string): Path to the file to encrypt
- `outputPath` (string): Path where the encrypted file will be saved
- `password` (string): Password for encryption

**Returns:** Promise<boolean>

### `decryptFile(inputPath, outputPath, password)`

Decrypts a file that was encrypted with `encryptFile`.

**Parameters:**
- `inputPath` (string): Path to the encrypted file
- `outputPath` (string): Path where the decrypted file will be saved
- `password` (string): Password for decryption

**Returns:** Promise<boolean>

## Error Handling

The module includes comprehensive error handling:

- File existence validation
- File read/write permissions
- Directory creation
- Path validation (supports both file:// URIs and direct paths)

## Requirements

- React Native >= 0.60.0
- Android API 21+
- iOS 10.0+

## License

MIT

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Changelog

### 1.0.0
- Initial release
- RNCryptor integration
- 16KB page size support for Android 15+
- TypeScript definitions
- Cross-platform file encryption/decryption