package com.jayeshsapplication.app.modules.introone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import com.jayeshsapplication.app.R
import com.jayeshsapplication.app.appcomponents.base.BaseActivity
import com.jayeshsapplication.app.databinding.ActivityIntroOneBinding
import com.jayeshsapplication.app.modules.introone.`data`.viewmodel.IntroOneVM
import com.jayeshsapplication.app.modules.introtwo.ui.IntroTwoActivity
import com.jayeshsapplication.app.modules.welcome.ui.WelcomeActivity
import kotlin.String
import kotlin.Unit

class IntroOneActivity : BaseActivity<ActivityIntroOneBinding>(R.layout.activity_intro_one) {
  private val viewModel: IntroOneVM by viewModels<IntroOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.introOneVM = viewModel

    val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
    val isFirstTimeLaunch = sharedPreferences.getBoolean("firstTimeLaunch", true)

    if (isFirstTimeLaunch) {
      val editor = sharedPreferences.edit()
      editor.putBoolean("firstTimeLaunch", false)
      editor.apply()
    } else {
      navigateToWelcomeScreen()
    }
  }

  private fun navigateToIntroOneScreen() {
    val intent = Intent(this, IntroOneActivity::class.java)
    startActivity(intent)
    finish()
  }

  private fun navigateToWelcomeScreen() {
    val intent = Intent(this, WelcomeActivity::class.java)
    startActivity(intent)
    finish()
  }

  override fun setUpClicks(): Unit {
    binding.imageClock.setOnClickListener {
      val destIntent = IntroTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }

    binding.btnSkipIntro.setOnClickListener {
      val destIntent = WelcomeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "INTRO_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, IntroOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}















