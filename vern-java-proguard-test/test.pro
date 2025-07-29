# Specify the entrypoint where ProGuard starts to determine what's reachable.
-keep class com.vern_sdk.api.proguard.** { *; }

# For the testing framework.
-keep class org.junit.** { *; }