# AdMob Native Compose

A simple way to implement native ads in your Jetpack Compose Android project.

## Setup

Add the dependency in your app level `build.gradle`:

```gradle
dependencies {
    implementation 'io.github.farimarwat:admobnative-compose:1.3'
    implementation 'com.google.android.gms:play-services-ads:22.6.0'  // Required dependency
}
```

## Usage

### Basic Implementation

Add the below in `Manifest`

```
<application
...
<meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="${ADMOB_API_KEY}" />
</application>
```


The very basic example:
```kotlin
val adState = rememberNativeAdState(
    context = LocalContext.current,
    adUnitId = "your_ad_unit_id",
    refreshInterval = 60000L
)

BannerAdAdmobSmall(
    context = LocalContext.current,
    loadedAd = adState
)
```

Only two types of banners available:

```
BannerAdAdmobSmall()

BannerAdAdmobMedium()
```

### Custom Colors

```kotlin
val customColors = AdColors(
    headlineText = Color.White,
    bodyText = Color.Gray,
    buttonText = Color.Black,
    badgeText = Color.White
)

BannerAdAdmobSmall(
    context = LocalContext.current,
    loadedAd = adState,
    adColors = customColors
)
```

### With Error Handling

```kotlin
val adState = rememberNativeAdState(
    context = LocalContext.current,
    adUnitId = "your_ad_unit_id",
    refreshInterval = 60000L,
    onAdLoaded = {
        // Handle successful ad load
    },
    onAdFailedToLoad = { error ->
        // Handle ad load failure
    }
)
```

### Custom Backgrounds

```kotlin
BannerAdAdmobSmall(
    context = LocalContext.current,
    loadedAd = adState,
    adBackground = yourCustomDrawable,
    actionButtonBackground = yourButtonDrawable,
    badgeBackground = yourBadgeDrawable
)
```


