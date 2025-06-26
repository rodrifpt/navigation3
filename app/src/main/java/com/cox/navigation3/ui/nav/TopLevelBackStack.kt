package com.cox.navigation3.ui.nav
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList

class TopLevelBackStack<T : Any>(startKey: T) {

    private val initialKey = startKey

    private var topLevelStacks: LinkedHashMap<T, SnapshotStateList<T>> = linkedMapOf(
        startKey to mutableStateListOf(startKey)
    )

    var topLevelKey by mutableStateOf(startKey)
        private set

    val backStack = mutableStateListOf(startKey)

    fun addTopLevel(key: T) {
        if (topLevelKey == key) return

        if (topLevelStacks[key] == null) {
            topLevelStacks[key] = mutableStateListOf(key)
        }

        topLevelStacks.apply {
            remove(key)?.let { existingStack ->
                put(key, existingStack)
            }
        }

        topLevelKey = key
        updateBackStack()
    }

    fun add(key: T) {
        topLevelStacks[topLevelKey]?.add(key)
        updateBackStack()
    }

    fun removeLast() {
        val stack = topLevelStacks[topLevelKey] ?: return
        if (stack.size == 1) {
            topLevelStacks.clear()
            topLevelStacks[initialKey] = mutableStateListOf(initialKey)
            topLevelKey = initialKey
        } else {
            stack.removeLastOrNull()
        }

        updateBackStack()
    }

    private fun updateBackStack() {
        backStack.clear()
        backStack.addAll(topLevelStacks.values.flatten())
    }
}
