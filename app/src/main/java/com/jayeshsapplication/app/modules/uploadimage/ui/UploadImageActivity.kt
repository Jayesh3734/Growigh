package com.jayeshsapplication.app.modules.uploadimage.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.viewModels
import com.jayeshsapplication.app.R
import com.jayeshsapplication.app.appcomponents.base.BaseActivity
import com.jayeshsapplication.app.databinding.ActivityUploadImageBinding
import com.jayeshsapplication.app.modules.uploadimage.`data`.viewmodel.UploadImageVM
import com.jayeshsapplication.app.modules.welcome.ui.WelcomeActivity

class UploadImageActivity : BaseActivity<ActivityUploadImageBinding>(R.layout.activity_upload_image) {
  private val viewModel: UploadImageVM by viewModels<UploadImageVM>()
  private var selectedImageUri: Uri? = null

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.uploadImageVM = viewModel
  }

  override fun setUpClicks() {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }

    binding.btnSelectImage.setOnClickListener {
      openImagePicker()
    }
  }

  private fun openImagePicker() {
    val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    intent.type = "image/*"
    startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
      selectedImageUri = data.data
      binding.imageImageFour.setImageURI(selectedImageUri)
    }
  }

  companion object {
    const val TAG: String = "UPLOAD_IMAGE_ACTIVITY"
    private const val PICK_IMAGE_REQUEST_CODE = 100

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, UploadImageActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

