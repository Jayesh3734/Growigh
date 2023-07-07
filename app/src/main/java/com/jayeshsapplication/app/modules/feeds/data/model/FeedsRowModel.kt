package com.jayeshsapplication.app.modules.feeds.data.model

import com.jayeshsapplication.app.R
import com.jayeshsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class FeedsRowModel(
  var imageUrl: String? = null, // Add imageUrl property

  var txtTheVerge: String? = MyApp.getInstance().resources.getString(R.string.lbl_the_verge),
  var txtTechNews: String? = MyApp.getInstance().resources.getString(R.string.lbl_tech_news),
  var txtMetaexplainsh: String? = MyApp.getInstance().resources.getString(R.string.msg_meta_explains_h),
  var txtViewall9Comm: String? = MyApp.getInstance().resources.getString(R.string.msg_view_all_9_comm),
  var txtLikesCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_21_likes),
  var txtCommentsCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_9_comments),
  var txtShareOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_share)
)

