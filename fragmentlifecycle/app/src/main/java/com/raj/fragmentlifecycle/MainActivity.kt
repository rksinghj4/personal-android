package com.raj.fragmentlifecycle

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.raj.fragmentlifecycle.ui.theme.FragmentLifeCycleTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
       enableEdgeToEdge()
        //nonComposeUI()
        setContent {
            FragmentLifeCycleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(innerPadding)
                }
            }
        }
    }

    /**
     * In AndroidManifest file, for MainActivity we have
     * android:configChanges="orientation|screenSize" then
     *  on screen rotation - no other lifecycle method of activity is called.
     *  only overridden onConfigurationChanged will be called.
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(TAG, "onConfigurationChanged")

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "ORIENTATION_PORTRAIT", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "ORIENTATION_LANDSCAPE", Toast.LENGTH_SHORT).show()
        }
    }

    fun nonComposeUI() {
        setContentView(R.layout.activity_main)
        /*supportFragmentManager.commit {
            add(R.id.containerId, FragmentA())
        }*/
        findViewById<Button>(R.id.addFragmentA).setOnClickListener {
            supportFragmentManager.commit {
                add(R.id.containerId, FragmentA())
            }
        }
        findViewById<Button>(R.id.addFragmentB).setOnClickListener {
            supportFragmentManager.commit {
                add(R.id.containerId, FragmentB())
                addToBackStack("this-transaction")
            }
        }
    }

    @Composable
    fun MainScreen(innerPadding: PaddingValues) {
        val fragmentStr = rememberSaveable {
            mutableStateOf(
                "FragmentA"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = .8f),
                contentAlignment = Alignment.Center
            ) {
                if (fragmentStr.value == "FragmentA") {
                    FragmentInCompose(FragmentA())
                }

                if (fragmentStr.value == "FragmentB") {
                    FragmentInCompose(FragmentB())
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(Color.Cyan),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(modifier = Modifier.wrapContentSize(), onClick = {
                        fragmentStr.value = "FragmentA"
                    }) {
                        Text(text = "Add FragmentA")
                    }

                    Button(
                        modifier = Modifier.wrapContentSize(), onClick = {
                            fragmentStr.value = "FragmentB"
                        }) {
                        Text(text = "Add FragmentB")
                    }
                }
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")


        lifecycleScope.launch {
            delay(2000) // simulate loading critical data
            //(TTID will appear as Displayed, TTFD appears as Fully drawn.)
            reportFullyDrawn()//Tells the system: "Now my app is fully ready for the user."
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
        //finish()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        return super.getOnBackInvokedDispatcher()
        Log.d(TAG, "getOnBackInvokedDispatcher")

    }

    override fun onBackPressed() {
        // super.onBackPressed() -> this will force the activity to finish()
        Log.d(TAG, "onBackPressed")

        // This is the correct method to move the entire task to the background
        // The 'true' flag means it will be moved to the back, not finished.
        //moveTaskToBack(true) //onBackPressed() -> onPause() -> onStop()

        //Use either one way: Either moveTaskToBack(true) or below

        //If we just use following code: onBackPressed() -> onPause() -> onStop()
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FragmentLifeCycleTheme {
        Greeting("Android")
    }
}