package com.jayeshsapplication.app.modules.feeds.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jayeshsapplication.app.modules.feeds.`data`.model.FeedsModel
import com.jayeshsapplication.app.modules.feeds.`data`.model.FeedsRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class FeedsVM : ViewModel(), KoinComponent {
  val feedsModel: MutableLiveData<FeedsModel> = MutableLiveData(FeedsModel())

  var navArguments: Bundle? = null

  val feedsList: MutableLiveData<MutableList<FeedsRowModel>> = MutableLiveData(mutableListOf())
}
