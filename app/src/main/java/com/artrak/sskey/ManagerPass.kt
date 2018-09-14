package com.artrak.sskey

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.artrak.sskey.newOld.LoggingIn
import com.artrak.sskey.newOld.Password
import com.artrak.sskey.newOld.SearchRepositoryGeneral
import com.artrak.sskey.newOld.SearchRepositoryProviderGeneral
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_manager_pass.*

class ManagerPass : AppCompatActivity() {

    //val compositeDisposable: CompositeDisposable = CompositeDisposable()
    //https://www.youtube.com/watch?v=KFo1bO05Jho
    //https://www.raywenderlich.com/155-android-listview-tutorial-with-kotlin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_pass)

        loginIn()
    }

    private fun loginIn(){
        val repository = SearchRepositoryProviderGeneral.provideSearchRepositoryGeneral()
        repository.postLogin(LoggingIn("admin9@gmail.com", "admin9"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                    result ->
                    this.toast("$result")
                    getListPass(repository)
                }, { error ->
                    error.printStackTrace()
                })
    }

    private fun getListPass(repository: SearchRepositoryGeneral){
        //val repository = SearchRepositoryProviderGeneral.provideSearchRepositoryGeneral()
        repository.getListPass()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                    result ->

                    var adapter = PassListAdapter(this, result.passwords as ArrayList<Password>)
                    list_view_pass?.adapter = adapter
                    adapter?.notifyDataSetChanged()

                    var list =result.passwords
                    //connectStatusText.setTextColor(Color.GREEN)
                }, { error ->
                    error.printStackTrace()
                    //connectStatusText.text = "Not found"
                    //connectStatusText.setTextColor(Color.RED)
                })
    }
}
