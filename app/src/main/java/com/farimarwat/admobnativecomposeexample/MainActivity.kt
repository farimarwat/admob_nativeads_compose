package com.farimarwat.admobnativecomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.farimarwat.admobnativecomposeexample.ui.theme.AdmobnativeComposeExampleTheme
import com.farimarwat.composenativeadmob.nativead.BannerAdAdmobMedium
import com.farimarwat.composenativeadmob.nativead.BannerAdAdmobSmall
import com.farimarwat.composenativeadmob.nativead.rememberNativeAdState
import com.google.android.gms.ads.nativead.NativeAd

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
                    val context = LocalContext.current
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
        BannerAdAdmobSmall(loadedAd = adstate)
        Spacer(modifier = Modifier.fillMaxWidth())
        BannerAdAdmobMedium(loadedAd = adstate)
    }
}