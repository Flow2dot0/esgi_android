package com.florian.gustin

import android.graphics.Typeface
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yuka)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_drawable))
        valueOfText(R.id.barcode, R.string.barcode, "1234")
        valueOfText(R.id.quantity, R.string.quantity, "700 g")
        valueOfText(R.id.sold, R.string.sold, "Franprix")
        valueOfText(R.id.ingredients, R.string.ingredients, "Pain, poulet, ...")
        valueOfText(R.id.allergenes, R.string.allergenes, "cedricide, lepronicide")
        valueOfText(R.id.additives, R.string.additives, "Aucun")
    }

    private fun valueOfText(rId : Int, rString : Int, args : String){
        findViewById<TextView>(rId).setTextBold(getString(rString, args))
    }

    private fun TextView.setTextBold(text: String, separator: String = ":") {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        setText(builder)
    }
}