package com.raj.fragmentlifecycle

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.raj.fragmentlifecycle.ui.theme.FragmentLifeCycleTheme

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        enableEdgeToEdge()
        nonComposeUI()
        /*setContent {
            FragmentLifeCycleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        MainScreen()
                    }
                }
            }
        }*/
    }

    fun nonComposeUI() {
        setContentView(R.layout.activity_main)
        findViewById<FrameLayout>(R.id.containerId)
        findViewById<Button>(R.id.addFragmentA).setOnClickListener {
            supportFragmentManager.commit {
                add(R.id.containerId, FragmentA())
            }
        }
        findViewById<Button>(R.id.addFragmentB).setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.containerId, FragmentB())
                addToBackStack("this-transaction")
            }
        }
    }

    @Composable
    fun MainScreen() {
        val fragmentStr = rememberSaveable {
            mutableStateOf(
                "FragmentA"
            )
        }
        Column(modifier = Modifier.fillMaxSize()) {
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
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = .2f),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
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
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
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