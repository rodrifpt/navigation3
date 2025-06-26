package com.cox.navigation3.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.cox.navigation3.data.floorPlans
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FloorPlanDetailViewModel @Inject constructor() : ViewModel() {

    fun getPlan(planId: Int) = floorPlans.find { it.id == planId } ?: throw IllegalArgumentException("Vehicle not found")
}
