package androiddeveloper.belajarandroiddasar

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var nameET: EditText
    private lateinit var sayButton: Button
    private lateinit var sayTV: TextView

    private fun initComponent(){
        nameET = findViewById(R.id.nameET)
        sayButton = findViewById(R.id.sayButton)
        sayTV = findViewById(R.id.sayTV)

    }

    private fun checkFingerprint(){
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE","Feature Fingerprint ON")
        }else{
            Log.i("FEATURE","Feature Fingerprint OFF")
        }
    }

    private fun checkPlatformVersion(){
        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S_V2){
            Log.i("SDK", "Disable feature, because version sdk is lower than 33")
        }
    }

    private fun printHello(name: String){
        Log.i("DEBUG", name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_activity)

        sayTV.text = "Hi.."

        sayButton.setOnClickListener {

            val named = "Andridm"
            printHello(named)

            checkFingerprint()
            //checkPlatformVersion()
            initComponent()

            Log.d("BAD", "This is debug log")
            Log.i("BAD", "This is info log")
            Log.w("BAD", "This is warning log")
            Log.e("BAD", "This is error log")

            Log.i("ValueResources", resources.getInteger(R.integer.maxPage).toString())
            Log.i("ValueResources", resources.getBoolean(R.bool.isProductionsMode).toString())
            Log.i("ValueResources", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("ValueResources", resources.getColor(R.color.background, theme).toString())

            sayButton.setBackgroundColor(resources.getColor(R.color.background, theme))

            //memanggil arroy string
            val name = nameET.text.toString()
            sayTV.text = resources.getString(R.string.sayTextView, name)

            resources.getStringArray(R.array.names).forEach {
                Log.i("BAD", it)
            }

            //memanggil file json file manager
//            val json = assets.open("sample.json")
//                .bufferedReader()
//                .use { it.readText() }
//
//            Log.i("Asset", json)

            //memanggil file json pada res raw
            val json = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }

            Log.i("Asset", json)
        }
    }
}