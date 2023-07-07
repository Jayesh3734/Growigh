package com.jayeshsapplication.app.modules.feeds.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.jayeshsapplication.app.R
import com.jayeshsapplication.app.appcomponents.base.BaseActivity
import com.jayeshsapplication.app.databinding.ActivityFeedsBinding
import com.jayeshsapplication.app.modules.feeds.data.model.FeedsRowModel
import com.jayeshsapplication.app.modules.feeds.data.viewmodel.FeedsVM
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FeedsActivity : BaseActivity<ActivityFeedsBinding>(R.layout.activity_feeds) {
  private val viewModel: FeedsVM by viewModels<FeedsVM>()
  private lateinit var feedsAdapter: FeedsAdapter

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    feedsAdapter = FeedsAdapter(emptyList())
    binding.recyclerFeeds.adapter = feedsAdapter

    fetchImageUrls()

    binding.feedsVM = viewModel
    setUpSearchViewSearchFormListener()
  }

  override fun setUpClicks() {
  }

  private fun fetchImageUrls() {
    val retrofit = Retrofit.Builder()
      .baseUrl("https://pixabay.com")
      .addConverterFactory(GsonConverterFactory.create())
      .build()

    val apiService = retrofit.create(PixabayApiService::class.java)
    val apiKey = "38127550-b931af06bc203c3cf91100db6"
    val call = apiService.getImages(apiKey)

    call.enqueue(object : Callback<PixabayApiResponse> {
      override fun onResponse(
        call: Call<PixabayApiResponse>,
        response: Response<PixabayApiResponse>
      ) {
        if (response.isSuccessful) {
          val pixabayApiResponse = response.body()
          val imageUrls = pixabayApiResponse?.hits?.map { it.webformatURL } ?: emptyList()
          val feedsList = imageUrls.map { FeedsRowModel(imageUrl = it) }
          feedsAdapter.updateData(feedsList)
        }
      }

      override fun onFailure(call: Call<PixabayApiResponse>, t: Throwable) {
        // Handle API call failure
      }
    })
  }

  fun onClickRecyclerFeeds(
    view: View,
    position: Int,
    item: FeedsRowModel
  ) {
    // Handle item click
  }

  private fun setUpSearchViewSearchFormListener() {
    binding.searchViewSearchForm.setOnQueryTextListener(object :
      SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(p0: String): Boolean {
        return false
      }

      override fun onQueryTextChange(p0: String): Boolean {
        return false
      }
    })
  }

  companion object {
    const val TAG: String = "FEEDS_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, FeedsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
