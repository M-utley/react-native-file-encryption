# react-native-file-encryption

A React Native module for file encryption and decryption using RNCryptor (AES-256 encryption with HMAC authentication).

## Features

- **AES-256 encryption** with secure key derivation
- **HMAC authentication** for data integrity
- **Cross-platform** (iOS and Android)
- **TypeScript support** included
- **Promise-based API** for async operations
- **Secure random number generation**

## Installation

```bash
npm install react-native-file-encryption --save
```

### iOS

```bash
cd ios && pod install
```

### Android

No additional setup required for React Native 0.60+ (auto-linking).

## Usage

```javascript
import FileEncryption, { encryptFile, decryptFile } from 'react-native-file-encryption';

// Encrypt a file
await encryptFile(
  '/path/to/original/file.pdf',
  '/path/to/encrypted/file.pdf.enc',
  'your-secure-password'
);

// Decrypt a file
await decryptFile(
  '/path/to/encrypted/file.pdf.enc',
  '/path/to/decrypted/file.pdf',
  'your-secure-password'
);
```

## TypeScript Support

The module includes full TypeScript definitions:

```typescript
import { encryptFile, decryptFile } from 'react-native-file-encryption';

// All methods are fully typed
const success: boolean = await encryptFile(
  readPath: string,
  writePath: string,
  password: string
): Promise<boolean>;
```

## Requirements

- React Native >= 0.60.0
- iOS >= 13.4
- Android API >= 21

## Security

This module uses RNCryptor which provides:
- AES-256 encryption
- PBKDF2 key derivation (10,000 rounds)
- HMAC-SHA256 authentication
- Secure random IV generation