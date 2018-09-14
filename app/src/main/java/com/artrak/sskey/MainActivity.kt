package com.artrak.sskey

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.artrak.sskey.newOld.LoggingIn
import com.artrak.sskey.newOld.SearchRepositoryProviderGeneral
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import android.location.LocationManager
import com.artrak.sskey.R.id.connectStatusText


class MainActivity : AppCompatActivity() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // check Permissions---------------------------------------------------------
        Permissions.getPermission(this)
        // My Location ---------------------------------------------------------

        // loginIn
        loginBtn.setOnClickListener { loginIn() }
   }




    private fun loginIn(){
        val repository = SearchRepositoryProviderGeneral.provideSearchRepositoryGeneral()
        repository.postLogin(LoggingIn(loginText.text.toString(), passText.text.toString()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                    result ->
                    this.toast("$result")
                    openManagerPass()
                }, { error ->
                    error.printStackTrace()
                })
    }

    private fun openManagerPass(){
        val i = Intent(this, ManagerPass::class.java)
        //i.putExtra("userId", 5)
        startActivity(i)
    }


    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}



fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()




//    private fun checkHome(){
//        val repository = SearchRepositoryProviderGeneral.provideSearchRepositoryGeneral()
//        repository.getHome()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe ({
//                    result ->
//                    connectStatusText.text = result.message
//                    connectStatusText.setTextColor(Color.GREEN)
//                }, { error ->
//                    error.printStackTrace()
//                    connectStatusText.text = "Not found"
//                    connectStatusText.setTextColor(Color.RED)
//                })
//    }