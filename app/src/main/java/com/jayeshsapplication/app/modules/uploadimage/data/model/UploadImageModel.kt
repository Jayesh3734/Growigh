package com.jayeshsapplication.app.modules.uploadimage.`data`.model

import com.jayeshsapplication.app.R
import com.jayeshsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class UploadImageModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtUploadImage: String? = MyApp.getInstance().resources.getString(R.string.lbl_upload_image)

)
