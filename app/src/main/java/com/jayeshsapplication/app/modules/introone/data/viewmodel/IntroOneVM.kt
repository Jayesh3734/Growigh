package com.jayeshsapplication.app.modules.introone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jayeshsapplication.app.modules.introone.`data`.model.IntroOneModel
import org.koin.core.KoinComponent

class IntroOneVM : ViewModel(), KoinComponent {
  val introOneModel: MutableLiveData<IntroOneModel> = MutableLiveData(IntroOneModel())

  var navArguments: Bundle? = null
}
