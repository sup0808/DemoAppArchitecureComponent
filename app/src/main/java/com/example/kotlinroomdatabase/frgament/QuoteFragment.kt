package com.example.kotlinroomdatabase.frgament

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinroomdatabase.QuoteApplication
import com.example.kotlinroomdatabase.R
import com.example.kotlinroomdatabase.databinding.FragmentHomeBinding
import com.example.kotlinroomdatabase.databinding.FragmentQuotesBinding
import com.example.kotlinroomdatabase.databinding.FragmentSettingsBinding
import com.example.kotlinroomdatabase.models.Quote
import com.example.kotlinroomdatabase.repository.Response
import com.example.kotlinroomdatabase.viewmodel.MainViewModel
import com.example.kotlinroomdatabase.viewmodel.MainViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject


class QuoteActivity : AppCompatActivity() {

    lateinit var binding: FragmentQuotesBinding

    lateinit var quoteAdapter: QuoteAdapter

    @Inject
    lateinit var mainViewModel : MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.fragment_quotes)

        setupUI()
        setUpViewModel()
        setUpObserver()
    }





    private fun setUpViewModel(){
        // val map =  (application as QuoteApplication).component.getMap()

        (application as QuoteApplication).component.injectQuote(this)
        mainViewModel = ViewModelProvider(this,mainViewModelFactory)[MainViewModel::class.java]
    }

    private fun setUpObserver(){
        lifecycleScope.launch {
            mainViewModel.quotes.collect{
                when(it){
                    is Response.Loading ->{
                        //show progress
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE

                    }
                    is Response.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.recyclerView.visibility = View.VISIBLE
                        renderList(it.datas!!.results)
                        Toast.makeText(this@QuoteActivity,"Result :: ${it.datas?.results?.size}", Toast.LENGTH_LONG).show()
                    }
                    is Response.Error -> {
                        //Handle error
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this@QuoteActivity,it.errorMessage, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    fun renderList(quotes : List<Quote>){
        quoteAdapter.addData(quotes)
        quoteAdapter.notifyDataSetChanged()
    }


    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this@QuoteActivity)
        quoteAdapter =
            QuoteAdapter(
                arrayListOf()
            )
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = quoteAdapter
    }

}