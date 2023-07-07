package com.jayeshsapplication.app.modules.introtwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jayeshsapplication.app.modules.introtwo.`data`.model.IntroTwoModel
import org.koin.core.KoinComponent

class IntroTwoVM : ViewModel(), KoinComponent {
  val introTwoModel: MutableLiveData<IntroTwoModel> = MutableLiveData(IntroTwoModel())

  var navArguments: Bundle? = null
}
