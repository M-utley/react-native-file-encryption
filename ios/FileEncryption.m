// FileEncryption.m

#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(FileEncryption, NSObject)

RCT_EXPORT_METHOD(sampleMethod:(NSString *)stringArgument numberParameter:(nonnull NSNumber *)numberArgument callback:(RCTResponseSenderBlock)callback)
{
    // TODO: Implement some actually useful functionality
    callback(@[[NSString stringWithFormat: @"numberArgument: %@ stringArgument: %@", numberArgument, stringArgument]]);
}

RCT_EXTERN_METHOD(encryptFile:(NSString *)readPath writePath:(NSString *)writePath password:(NSString *)password resolve:(RCTPromiseResolveBlock *)resolve reject:(RCTPromiseRejectBlock *)reject)
RCT_EXTERN_METHOD(decryptFile:(NSString *)readPath writePath:(NSString *)writePath password:(NSString *)password resolve:(RCTPromiseResolveBlock *)resolve reject:(RCTPromiseRejectBlock *)reject)

@end
