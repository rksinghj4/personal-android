package com.raj.fragmentlifecycle

import android.util.Log
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit

const val FRAGMENT_CONTAINER_ID = 12345

/**
 * FragmentActivity: The Context must be cast to FragmentActivity to access the supportFragmentManager.
 * This means the Activity hosting your Compose UI must inherit from AppCompatActivity or FragmentActivity.
 */

@Composable
fun FragmentInCompose(fragment: Fragment, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val fragmentManager = (context as FragmentActivity).supportFragmentManager
    // Create a unique ID for our Fragment container
    val containerId = FRAGMENT_CONTAINER_ID

    //AndroidView is a composable
    AndroidView(
        factory = {
            FrameLayout(context).apply {
                id = containerId
            }
        },
        modifier = modifier,

        update = {
            // This block is called when the composable is recomposed
            // Use FragmentManager to add the Fragment to the container
            /**
             * The update block ensures that the Fragment is only added once.
             * The if (fragmentManager.findFragmentById(...) == null)
             * check prevents the fragment from being re-added on every recomposition.
             */

           /* if (fragmentManager.findFragmentById(containerId) == null) {
                fragmentManager.commit {
                    add(containerId, fragment)
                    //addToBackStack("nameForBackStackState")//Transaction name bhi kah sakte hain
                }
            }*/

            fragmentManager.commit {
                add(containerId, fragment)
                if (fragment.arguments?.getString("WhichFragment", "") == "FragmentB"){
                    addToBackStack("nameForBackStackState")//Transaction name bhi kah sakte hain
                }
            }
        })

    // Optional: Use DisposableEffect to clean up the fragment when the composable leaves the screen
    // This is useful for preventing memory leaks in more complex scenarios.

    DisposableEffect(Unit) {
        onDispose {
            fragmentManager.findFragmentById(containerId)?.let { existingFragment ->
                //Note: We are not manually writing code for begin transaction.
                //Evey time we need new transaction object to commit operations.
                //One transaction object can commit only once.

               /* fragmentManager.commit {
                    Log.d("FragmentRemoved", "DisposableEffect - onDispose")
                    remove(existingFragment)
                }*/
            }
        }
    }
}