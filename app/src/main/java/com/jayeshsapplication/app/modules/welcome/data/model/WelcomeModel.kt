package com.jayeshsapplication.app.modules.welcome.`data`.model

import com.jayeshsapplication.app.R
import com.jayeshsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class WelcomeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_welcome_ayush)

)
