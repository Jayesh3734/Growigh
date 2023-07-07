package com.jayeshsapplication.app.modules.introtwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.jayeshsapplication.app.R
import com.jayeshsapplication.app.appcomponents.base.BaseActivity
import com.jayeshsapplication.app.databinding.ActivityIntroTwoBinding
import com.jayeshsapplication.app.modules.introthree.ui.IntroThreeActivity
import com.jayeshsapplication.app.modules.introtwo.`data`.viewmodel.IntroTwoVM
import com.jayeshsapplication.app.modules.welcome.ui.WelcomeActivity
import kotlin.String
import kotlin.Unit

class IntroTwoActivity : BaseActivity<ActivityIntroTwoBinding>(R.layout.activity_intro_two) {
  private val viewModel: IntroTwoVM by viewModels<IntroTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.introTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageProgressbutton.setOnClickListener {
      val destIntent = IntroThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }

    binding.btnSkipIntro.setOnClickListener {
      val destIntent = WelcomeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "INTRO_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, IntroTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
















