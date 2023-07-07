package com.jayeshsapplication.app.modules.introthree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jayeshsapplication.app.modules.introthree.`data`.model.IntroThreeModel
import org.koin.core.KoinComponent

class IntroThreeVM : ViewModel(), KoinComponent {
  val introThreeModel: MutableLiveData<IntroThreeModel> = MutableLiveData(IntroThreeModel())

  var navArguments: Bundle? = null
}
