[![](https://jitpack.io/v/usoamic/usoamickt.svg)](https://jitpack.io/#usoamic/usoamickt)
# usoamic.kt

Kotlin library for interaction with Usoamic contract

## Example For Android
```
val usoamic = Usoamic(
    fileName = "FILE_NAME.json",
    filePath = applicationContext.applicationInfo.dataDir,
    networkType = NetworkType.MAINNET,
    nodeProvider = NodeProvider.MYETHERWALLET
)
```

## Gradle Setup
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.usoamic:validateutilkt:v1.0.0'
}
```

## Dependencies
```gradle
dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    implementation 'org.web3j:core:4.3.1'

    testImplementation 'org.jetbrains.kotlin:kotlin-test-junit5:1.3.50'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.5.0'
}
```
