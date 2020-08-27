package mimi.o.browser4g

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.InterstitialAd
import com.startapp.sdk.adsbase.StartAppAd
import com.startapp.sdk.adsbase.StartAppSDK
import java.util.*


class SplashActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd
    private var adRespons = true
    private var runable: Runnable? = null
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//        MobileAds.initialize(this, "ca-app-pub-2322131950454521~6253376330")
//        startApp
        StartAppSDK.init(this, "132229622", "207763060", true);

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val lastopen = prefs.getInt("lastopen", 0)

        val editor = prefs.edit()
        editor.putInt("lastopen", Date().hours)
        editor.apply()

        if (lastopen == Date().hours){
            val i = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(i)
            return
        }

//        mInterstitialAd = InterstitialAd(this)
//        mInterstitialAd.adUnitId = "ca-app-pub-2322131950454521/3627212999"
//        mInterstitialAd.loadAd(AdRequest.Builder().build())

//        mInterstitialAd.adListener = object : AdListener() {
//            override fun onAdLoaded() {
//                if(!adRespons)
//                    return
//
//                handler.removeCallbacks(runable)
//                handler.post(runable)
//                Log.i("Ads", "onAdLoaded")
//            }
//
//            override fun onAdFailedToLoad(errorCode: Int) {
//                if(!adRespons)
//                    return
//
//                handler.removeCallbacks(runable)
//                handler.post(runable)
//                Log.i("Ads", "onAdFailedToLoad")
//            }
//
//            override fun onAdOpened() {
//                Log.i("Ads", "onAdOpened")
//            }
//
//            override fun onAdLeftApplication() {
//                Log.i("Ads", "onAdLeftApplication")
//            }
//
//            override fun onAdClosed() {
//                Log.i("Ads", "onAdClosed")
//                val i = Intent(this@SplashActivity, MainActivity::class.java)
//                startActivity(i)
//            }
//        }

//        runable = Runnable {
//            adRespons = false
//            if (mInterstitialAd.isLoaded) {
//                Log.i("Ads", "onAdSHOOOW")
//                mInterstitialAd.show()
//            } else {
//                Log.d("Ads", "The interstitial wasn't loaded yet.")
//                val i = Intent(this@SplashActivity, MainActivity::class.java)
//                startActivity(i)
//            }
//        }

        startDelay(4000)
    }

    fun startDelay(time: Long){
        handler.removeCallbacks(runable)
        handler.postDelayed(runable, time)
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}





