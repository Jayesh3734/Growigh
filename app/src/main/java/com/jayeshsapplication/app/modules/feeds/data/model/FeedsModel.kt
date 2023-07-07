package com.jayeshsapplication.app.modules.feeds.`data`.model

import com.jayeshsapplication.app.R
import com.jayeshsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class FeedsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHelloAyush: String? = MyApp.getInstance().resources.getString(R.string.lbl_hello_ayush)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBrowseBy: String? = MyApp.getInstance().resources.getString(R.string.lbl_browse_by)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_latest)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_older)

)
