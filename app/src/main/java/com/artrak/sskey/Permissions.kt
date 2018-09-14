package com.artrak.sskey

import android.support.v4.app.ActivityCompat
import android.widget.Toast
import android.os.Build
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity



class Permissions {
    companion object {
        fun getPermission(thisActivity: AppCompatActivity) {
            if (ActivityCompat.checkSelfPermission(thisActivity, android.Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.checkSelfPermission(thisActivity, android.Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Toast.makeText(thisActivity, "Allow location access. Please", Toast.LENGTH_LONG)
                    ActivityCompat.requestPermissions(
                            thisActivity, arrayOf(
                            android.Manifest.permission.INTERNET,
                            android.Manifest.permission.ACCESS_NETWORK_STATE), 5622)
                }

            }

        }
    }
}