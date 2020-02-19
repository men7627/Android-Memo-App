package com.example.android_memo_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.android_memo_app.data.ListViewModel
import com.example.android_memo_app.data.MemoData

import kotlinx.android.synthetic.main.activity_list.*
import java.util.*

class ListActivity : AppCompatActivity() {

    private var viewModel: ListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
//            val intent = Intent(applicationContext, DetailActivity::class.java)
//            startActivity(intent)
            viewModel!!.let{
                var memoData = MemoData()
                memoData.title = "제목 테스트"
                memoData.summary = "요약내용 테스트"
                memoData.createdAt = Date()

                it.addMemo(memoData)
            }
        }

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.contentLayout, MemoListFragment())
        fragmentTransaction.commit()

        viewModel = application!!.let {
            ViewModelProvider(viewModelStore, ViewModelProvider.AndroidViewModelFactory(it))
                .get(ListViewModel::class.java)
        }
    }

}
