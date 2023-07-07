package com.jayeshsapplication.app.modules.uploadimage.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jayeshsapplication.app.modules.uploadimage.`data`.model.UploadImageModel
import org.koin.core.KoinComponent

class UploadImageVM : ViewModel(), KoinComponent {
  val uploadImageModel: MutableLiveData<UploadImageModel> = MutableLiveData(UploadImageModel())

  var navArguments: Bundle? = null
}
