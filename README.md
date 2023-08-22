# Admob Nativeads JetPack Compose
Integrate AdMob Native Ads seamlessly into your Android app with our Jetpack Compose Android Library. Unlock new revenue streams by effortlessly blending native ads into your app's user interface. Our library offers easy-to-implement components for precise ad targeting, customizable formats, and seamless ad loading and rendering. Enhance user engagement while maintaining a consistent user experience. Maximize monetization potential with AdMob Native Ads and our Jetpack Compose Android Library today.

<img src="https://github.com/farimarwat/admob_nativeads_compose/blob/main/demo.png" width="30%" height="30%"/>


### Step 1: 
Implement:
```
  implementation 'com.google.android.gms:play-services-ads:22.1.0'
  implementation 'io.github.farimarwat:admobnative-compose:1.2'
```
and also include this in Manifest file:
```
<application
...
<meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="${ADMOB_API_KEY}" />
</application>
```

### Usage:
```
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdmobnativeComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //get a context to use in the library
                    val context = LocalContext.current

                    //get nativead state
                    val adstate = rememberNativeAdState(context = context, adUnitId = BuildConfig.ADMOB_NATIVE_TEST)

                    MainScreen(adstate = adstate)
                }
            }
        }
    }
}

@Composable
fun MainScreen(adstate: NativeAd?){
    Column(modifier = Modifier.fillMaxSize()){

        //Small Banner
        BannerAdAdmobSmall(loadedAd = adstate)
        Spacer(modifier = Modifier.fillMaxWidth())
        //Medium Banner
        BannerAdAdmobMedium(loadedAd = adstate)
    }
}
```

### rememberNativeAdState
```
rememberNativeAdState(context = context,
                        adUnitId = "adunit id", 
                        refreshInterval = 60000 
                    )
```

This function takes 3 params:
1. Context
2. Ad Unit Id which is provided by admob for native ad
3. Refresh Interval to auto refresh ad. if not given then 60 seconds is default which is recommanded by google.

### Change Log
**1.1**

ANR fixed

**1.0**

Initial release
