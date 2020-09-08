package mimi.o.browser4g

//import com.facebook.ads.AudienceNetworkAds
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.facebook.ads.*
import java.util.*


class SplashActivity : AppCompatActivity() {

    private lateinit var interstitialAd: InterstitialAd
    private val TAG: String = SplashActivity::class.java.getSimpleName()
    private var adRespons = true
    private var runable: Runnable? = null
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//        MobileAds.initialize(this, "ca-app-pub-2322131950454521~6253376330")
//        startApp
//        StartAppSDK.init(this, "132229622", "207763060", true);
        AudienceNetworkAds.initialize(this)
        interstitialAd = InterstitialAd(this, "957023064793265_957023834793188")
//        AdSettings.addTestDevice("eaddb484-f84b-4dd3-b557-778768515286")
        AdSettings.clearTestDevices()
        interstitialAd.setAdListener(object : InterstitialAdListener {
            override fun onInterstitialDisplayed(ad: Ad?) {
                // Interstitial ad displayed callback
                Log.e(TAG, "Interstitial ad displayed.")
            }

            override fun onInterstitialDismissed(ad: Ad?) {
                // Interstitial dismissed callback
                Log.e(TAG, "Interstitial ad dismissed.")
            }

            override fun onError(ad: Ad?, adError: AdError) {
                // Ad error callback
                Log.e(TAG, "Interstitial ad failed to load: " + adError.errorMessage)
            }

            override fun onAdLoaded(ad: Ad?) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!")
                // Show the ad
                interstitialAd.show()
            }

            override fun onAdClicked(ad: Ad?) {
                // Ad clicked callback
                Log.d(TAG, "Interstitial ad clicked!")
            }

            override fun onLoggingImpression(ad: Ad?) {
                // Ad impression logged callback
                Log.d(TAG, "Interstitial ad impression logged!")
            }
        })

        interstitialAd.loadAd()


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





