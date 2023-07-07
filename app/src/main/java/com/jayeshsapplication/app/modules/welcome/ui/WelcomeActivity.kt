package com.jayeshsapplication.app.modules.welcome.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.jayeshsapplication.app.R
import com.jayeshsapplication.app.appcomponents.base.BaseActivity
import com.jayeshsapplication.app.databinding.ActivityWelcomeBinding
import com.jayeshsapplication.app.modules.feeds.ui.FeedsActivity
import com.jayeshsapplication.app.modules.introone.ui.IntroOneActivity
import com.jayeshsapplication.app.modules.introtwo.ui.IntroTwoActivity
import com.jayeshsapplication.app.modules.uploadimage.ui.UploadImageActivity
import com.jayeshsapplication.app.modules.welcome.`data`.viewmodel.WelcomeVM
import kotlin.String
import kotlin.Unit

class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>(R.layout.activity_welcome) {
  private val viewModel: WelcomeVM by viewModels<WelcomeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.welcomeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnFeeds.setOnClickListener {
      val destIntent = FeedsActivity.getIntent(this, null)
      startActivity(destIntent)
    }

    binding.btnUploadImage.setOnClickListener {
      val destIntent = UploadImageActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "WELCOME_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, WelcomeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
