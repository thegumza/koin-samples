@file:Suppress("UNCHECKED_CAST")

package fr.ekito.myweatherapp.util.android

import androidx.fragment.app.FragmentActivity

/**
 * Retrieve argument from Activity intent
 */
fun <T : Any> androidx.fragment.app.FragmentActivity.argument(key: String) =
    lazy { intent.extras[key] as? T ?: error("Intent Argument $key is missing") }

