package com.jayeshsapplication.app.modules.introthree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.jayeshsapplication.app.R
import com.jayeshsapplication.app.appcomponents.base.BaseActivity
import com.jayeshsapplication.app.databinding.ActivityIntroThreeBinding
import com.jayeshsapplication.app.modules.introone.ui.IntroOneActivity
import com.jayeshsapplication.app.modules.introthree.`data`.viewmodel.IntroThreeVM
import com.jayeshsapplication.app.modules.welcome.ui.WelcomeActivity
import kotlin.String
import kotlin.Unit

class IntroThreeActivity : BaseActivity<ActivityIntroThreeBinding>(R.layout.activity_intro_three) {
  private val viewModel: IntroThreeVM by viewModels<IntroThreeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.introThreeVM = viewModel
    }

    override fun setUpClicks(): Unit {
        binding.imageProgressbutton.setOnClickListener {
            val destIntent = WelcomeActivity.getIntent(this, null)
            startActivity(destIntent)
        }

        binding.btnSkipIntro.setOnClickListener {
            val destIntent = WelcomeActivity.getIntent(this, null)
            startActivity(destIntent)
        }
    }

    companion object {
      const val TAG: String = "INTRO_THREE_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, IntroThreeActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }


























